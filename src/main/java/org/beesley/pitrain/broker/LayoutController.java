package org.beesley.pitrain.broker;

import java.util.List;
import java.util.Optional;
import org.beesley.pitrain.broker.dao.LineRepository;
import org.beesley.pitrain.broker.dao.MotorControlRepository;
import org.beesley.pitrain.broker.dao.NodeRepository;
import org.beesley.pitrain.broker.dao.TurnOutRepository;
import org.beesley.pitrain.broker.models.LayoutState;
import org.beesley.pitrain.broker.models.Line;
import org.beesley.pitrain.broker.models.MotorControl;
import org.beesley.pitrain.broker.models.Node;
import org.beesley.pitrain.broker.models.TurnOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class LayoutController {
  private static final int Margin = 50;

  @Autowired
  private LineRepository lineRepository;

  @Autowired
  private MotorControlRepository motorControlRepository;

  @Autowired
  private NodeRepository nodeRepository;

  @Autowired
  private SimpMessagingTemplate template;

  @Autowired
  private TurnOutRepository turnOutRepository;

  @GetMapping("api/layout")
  @ResponseBody
  public LayoutState get() {
    LayoutState state = new LayoutState();
    state.setLines(getAllLines());
    state.setTurnOuts(getAllTurnOuts());
    List<Node> nodes = getAllNodes();
    state.setHeight(nodes.stream().map(node -> node.getTop()).max((a, b) -> a - b).get() + Margin);
    state.setWidth(nodes.stream().map(node -> node.getLeft()).max((a, b) -> a - b).get() + Margin);
    return state;
  }

  @GetMapping("api/layout/motor-control")
  @ResponseBody
  public List<MotorControl> getAllMotorControls() {
    return motorControlRepository.findAll();
  }

  @GetMapping("api/layout/motor-control/{motorControlId}")
  @ResponseBody
  public MotorControl getMotorControl(@PathVariable int motorControlId) {
    return findById(motorControlId, motorControlRepository);
  }

  @GetMapping("api/layout/line")
  @ResponseBody
  public List<Line> getAllLines() {
    return lineRepository.findAll();
  }

  @GetMapping("api/layout/line/{lineId}")
  @ResponseBody
  public Line getLine(@PathVariable int lineId) {
    return findById(lineId, lineRepository);
  }

  @GetMapping("api/layout/node")
  @ResponseBody
  public List<Node> getAllNodes() {
    return nodeRepository.findAll();
  }

  @GetMapping("api/layout/node/{lineId}")
  @ResponseBody
  public Node getNode(@PathVariable int nodeId) {
    return findById(nodeId, nodeRepository);
  }

  @GetMapping("api/layout/turn-out")
  @ResponseBody
  public List<TurnOut> getAllTurnOuts() {
    return turnOutRepository.findAll();
  }

  @GetMapping("api/layout/turn-out/{turnOutId}")
  @ResponseBody
  public TurnOut getTurnOut(@PathVariable int turnOutId) {
    return findById(turnOutId, turnOutRepository);
  }

  @MessageMapping("/send/motor-control")
  @SendTo("/topic/motor-control")
  public MotorControl sendMotorControlCmd(MotorControl motorControl) {
    Optional<MotorControl> result = motorControlRepository.findById(motorControl.getId());
    if (result.isPresent()) {
      MotorControl item = result.get();
      item.setReversed(motorControl.isReversed());
      item.setSpeed(motorControl.getSpeed());
      motorControlRepository.save(item);
      template.convertAndSend("/topic/motor", result);
      return item;
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching entity in database.");
    }
  }

  private static <TEntity, TId> TEntity findById(TId id, JpaRepository<TEntity, TId> repository) {
    Optional<TEntity> queryResult = repository.findById(id);
    if (!queryResult.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching entity in database.");
    }

    return queryResult.get();
  }
}
