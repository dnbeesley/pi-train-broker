package org.beesley.pitrainbroker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The entity class for a line in the layout.
 */
@Entity
@Table(name = "LINE")
public class Line {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "END_NODE_ID")
  private Node endNode;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "MOTOR_CONTROL_ID")
  private MotorControl motorControl;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "START_NODE_ID")
  private Node startNode;

  /**
   * Gets the identifier.
   * @return The identifier.
   */
  public int getId() {
    return Id;
  }

  /**
   * Sets the identifier.
   * @param id The identifier.
   */
  public void setId(int id) {
    Id = id;
  }

  /**
   * Gets the end node.
   * @return The end node.
   */
  public Node getEndNode() {
    return endNode;
  }

  /**
   * Sets the end node.
   * @param endNode The end node.
   */
  public void setEndNode(Node endNode) {
    this.endNode = endNode;
  }

  /**
   * Gets the motor control.
   * @return The motor control.
   */
  public MotorControl getMotorControl() {
    return motorControl;
  }

  /**
   * Sets the motor control.
   * @param motorControl The motor control.
   */
  public void setMotorControlId(MotorControl motorControl) {
    this.motorControl = motorControl;
  }

  /**
   * Gets the start node.
   * @return The start node.
   */
  public Node getStartNode() {
    return startNode;
  }

  /**
   * Sets the start node.
   * @param startNode The start node.
   */
  public void setStartNodeId(Node startNode) {
    this.startNode = startNode;
  }
}
