package org.beesley.pitrainbroker.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.pi4j.io.gpio.Pin;

public class RaspiControllerTests extends RaspiController {
  @Test
  public void testParsePin() {
    for (byte i = 0; i <= 20; i++) {
      testParsePin(i);
    }
  }

  private static void testParsePin(byte i) {
    Pin pin = parsePin(i);
    assertEquals(i, pin.getAddress());
  }
}
