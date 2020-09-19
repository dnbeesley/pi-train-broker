package org.beesley.pitrain.broker.models;

import java.util.List;
import org.beesley.pitrain.models.Line;
import org.beesley.pitrain.models.TurnOut;

/**
 * Class containing all the information for a GUI to render the layout.
 */
public class LayoutState {
  private int height;
  private List<Line> lines;
  private List<TurnOut> turnOuts;
  private int width;

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public List<Line> getLines() {
    return lines;
  }

  public void setLines(List<Line> lines) {
    this.lines = lines;
  }

  public List<TurnOut> getTurnOuts() {
    return turnOuts;
  }

  public void setTurnOuts(List<TurnOut> turnOuts) {
    this.turnOuts = turnOuts;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }
}
