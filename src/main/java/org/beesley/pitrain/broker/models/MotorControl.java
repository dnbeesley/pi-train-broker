package org.beesley.pitrain.broker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class for a motor control unit on the layout.
 */
@Entity
@Table(name = "MOTOR_CONTROL")
public class MotorControl {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "IS_REVERSED")
  private boolean isReversed;

  @Column(name = "FORWARD_PIN")
  private byte forwardPin;

  @Column(name = "REVERSE_PIN")
  private byte reversePin;

  @Column(name = "SPEED")
  private short speed;

  @Column(name = "SPEED_PIN")
  private byte speedPin;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isReversed() {
    return isReversed;
  }

  public void setReversed(boolean isReversed) {
    this.isReversed = isReversed;
  }

  public byte getForwardPin() {
    return forwardPin;
  }

  public void setForwardPin(byte forwardPin) {
    this.forwardPin = forwardPin;
  }

  public byte getReversePin() {
    return reversePin;
  }

  public void setReversePin(byte reversePin) {
    this.reversePin = reversePin;
  }

  public short getSpeed() {
    return speed;
  }

  public void setSpeed(short speed) {
    this.speed = speed;
  }

  public byte getSpeedPin() {
    return speedPin;
  }

  public void setSpeedPin(byte speedPin) {
    this.speedPin = speedPin;
  }
}
