package org.beesley.pitrainbroker.controllers;

import org.beesley.pitrainbroker.model.MotorControl;

public interface MotorController {
  MotorControl setState(int id, short power, boolean reversed);
}
