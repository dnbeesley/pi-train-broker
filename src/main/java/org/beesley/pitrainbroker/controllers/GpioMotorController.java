package org.beesley.pitrainbroker.controllers;

import java.util.HashMap;
import java.util.Map;
import org.beesley.pitrainbroker.dao.MotorControlRepository;
import org.beesley.pitrainbroker.model.MotorControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;

@Component
public class GpioMotorController extends RaspiController implements MotorController, AutoCloseable {

  private final MotorControlRepository motorControlRepository;
  private final GpioController gpio;
  private final Map<Integer, GpioPinDigitalOutput> forwardPinMap;
  private final Map<Integer, GpioPinDigitalOutput> reversePinMap;
  private final Map<Integer, GpioPinPwmOutput> speedPinMap;

  @Autowired
  public GpioMotorController(MotorControlRepository motorControlRepository) {
    this.motorControlRepository = motorControlRepository;
    gpio = GpioFactory.getInstance();
    forwardPinMap = new HashMap<Integer, GpioPinDigitalOutput>();
    reversePinMap = new HashMap<Integer, GpioPinDigitalOutput>();
    speedPinMap = new HashMap<Integer, GpioPinPwmOutput>();

    motorControlRepository.findAll().forEach(motorControl -> {
      forwardPinMap.put(motorControl.getId(),
          gpio.provisionDigitalOutputPin(parsePin(motorControl.getForwardPin())));
      reversePinMap.put(motorControl.getId(),
          gpio.provisionDigitalOutputPin(parsePin(motorControl.getReversePin())));
      speedPinMap.put(motorControl.getId(),
          gpio.provisionPwmOutputPin(parsePin(motorControl.getSpeedPin())));
    });
  }

  @Override
  public void close() {
    this.gpio.shutdown();
  }

  @Override
  public MotorControl setState(int id, short speed, boolean reversed) {
    MotorControl result = motorControlRepository.getOne(id);
    if (result == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Motor control with specified ID not found.");
    }
    result.setReversed(reversed);
    result.setSpeed(speed);

    motorControlRepository.save(result);
    forwardPinMap.get(id).setState(!reversed && speed != 0);
    reversePinMap.get(id).setState(reversed && speed != 0);
    speedPinMap.get(id).setPwm(result.getSpeed());

    return result;
  }
}
