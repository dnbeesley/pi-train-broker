package org.beesley.pitrain.broker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The entity class for a node in the layout.
 */
@Entity
@Table(name = "NODE")
public class Node {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;

  @Column(name = "\"LEFT\"")
  private int Left;

  @Column(name = "TOP")
  private int Top;

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
   * Gets the number of pixels from the left.
   * 
   * @return The number of pixels from the left.
   */
  public int getLeft() {
    return Left;
  }

  /**
   * Sets the number of pixels from the left.
   * 
   * @param left The number of pixels from the left.
   */
  public void setLeft(int left) {
    Left = left;
  }

  /**
   * Gets the number of pixels from the top.
   * 
   * @return The number of pixels from the top.
   */
  public int getTop() {
    return Top;
  }

  /**
   * Sets the number of pixels from the top.
   * 
   * @param left The number of pixels from the top.
   */
  public void setTop(int top) {
    Top = top;
  }
}
