package org.beesley.pitrain.broker.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The entity class for a turn out.
 */
@Entity
@Table(name = "TURN_OUT")
public class TurnOut {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "COMMON_NODE_ID")
  private Node commonNode;

  @Column(name = "FORWARD_PIN")
  private byte forwardPin;

  @Column(name = "FORWARD_SENSOR_PIN", nullable = true)
  private Byte forwardSensorPin;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "FORWARD_NODE_ID")
  private Node forwardNode;

  @Column(name = "SENSOR_ADDRESS", nullable = true)
  private Short sensorAddress;

  @Column(name = "TURN_OUT_PIN")
  private byte turnOutPin;

  @Column(name = "TURN_OUT_SENSOR_PIN", nullable = true)
  private Byte turnOutSensorPin;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "TURN_OUT_NODE_ID")
  private Node turnOutNode;

  @Column(name = "TURNED_OUT")
  private boolean turnedOut;

  /**
   * Gets the identifier.
   * 
   * @return The identifier.
   */
  public int getId() {
    return Id;
  }

  /**
   * Sets the identifier.
   * 
   * @param id The identifier.
   */
  public void setId(int id) {
    Id = id;
  }

  /**
   * Gets the common node.
   * 
   * @return The common node.
   */
  public Node getCommonNode() {
    return commonNode;
  }

  /**
   * Sets the common node.
   * 
   * @param commonNode The common node.
   */
  public void setCommonNode(Node commonNode) {
    this.commonNode = commonNode;
  }

  /**
   * Gets the forward pin.
   * 
   * @return The forward pin.
   */
  public byte getForwardPin() {
    return forwardPin;
  }

  /**
   * Sets the forward pin
   * 
   * @param forwardPin The forward pin.
   */
  public void setForwardPin(byte forwardPin) {
    this.forwardPin = forwardPin;
  }

  /**
   * Gets the forward sensor pin.
   * 
   * @return The forward sensor pin.
   */
  public Byte getForwardSensorPin() {
    return forwardSensorPin;
  }

  /**
   * Sets the forward sensor pin.
   * 
   * @param forwardSensorPin The forward sensor pin.
   */
  public void setForwardSensorPin(Byte forwardSensorPin) {
    this.forwardSensorPin = forwardSensorPin;
  }

  /**
   * Gets the forward node.
   * 
   * @return The forward node.
   */
  public Node getForwardNode() {
    return forwardNode;
  }

  /**
   * Sets the forward node.
   * 
   * @param forwardNode The forward node.
   */
  public void setForwardNode(Node forwardNode) {
    this.forwardNode = forwardNode;
  }

  /**
   * Gets the sensor address.
   * @return The sensor address.
   */
  public Short getSensorAddress() {
    return sensorAddress;
  }

  /**
   * Sets the sensor address.
   * @param sensorAddress The sensor address.
   */
  public void setSensorAddress(Short sensorAddress) {
    this.sensorAddress = sensorAddress;
  }

  /**
   * Gets the turn out pin.
   * @return The turn out pin.
   */
  public byte getTurnOutPin() {
    return turnOutPin;
  }

  /**
   * Sets the turn out pin.
   * @param turnOutPin The turn out pin.
   */
  public void setTurnOutPin(byte turnOutPin) {
    this.turnOutPin = turnOutPin;
  }

  /**
   * Gets the turn out sensor pin.
   * @return The turn out sensor pin.
   */
  public Byte getTurnOutSensorPin() {
    return turnOutSensorPin;
  }

  /**
   * Sets the turn out sensor pin.
   * @param turnOutSensorPin The turn out sensor pin.
   */
  public void setTurnOutSensorPin(Byte turnOutSensorPin) {
    this.turnOutSensorPin = turnOutSensorPin;
  }

  /**
   * Gets the turn out node.
   * 
   * @return The turn out node.
   */
  public Node getTurnOutNode() {
    return turnOutNode;
  }

  /**
   * Sets the turn out node.
   * 
   * @param turnOutNode The turn out node.
   */
  public void setTurnOutNode(Node turnOutNode) {
    this.turnOutNode = turnOutNode;
  }

  /**
   * Gets a value to indicate whether it's turned out.
   * 
   * @return A value to indicate whether it's turned out.
   */
  public boolean isTurnedOut() {
    return turnedOut;
  }

  /**
   * Sets a value to indicate whether it's turned out.
   * 
   * @param turnedOut A value to indicate whether it's turned out.
   */
  public void setTurnedOut(boolean turnedOut) {
    this.turnedOut = turnedOut;
  }
}
