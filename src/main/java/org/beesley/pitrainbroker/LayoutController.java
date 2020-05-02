package org.beesley.pitrainbroker;

import java.util.List;
import java.util.Optional;
import org.beesley.pitrainbroker.controllers.MotorController;
import org.beesley.pitrainbroker.dao.LineRepository;
import org.beesley.pitrainbroker.dao.NodeRepository;
import org.beesley.pitrainbroker.dao.TurnOutRepository;
import org.beesley.pitrainbroker.model.LayoutState;
import org.beesley.pitrainbroker.model.Line;
import org.beesley.pitrainbroker.model.MotorControl;
import org.beesley.pitrainbroker.model.Node;
import org.beesley.pitrainbroker.model.TurnOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@CrossOrigin
public class LayoutController {
  @Autowired
  private MotorController motorController;

  @Autowired
  private LineRepository lineRepository;

  @Autowired
  private NodeRepository nodeRepository;

  @Autowired
  private TurnOutRepository turnOutRepository;

  @GetMapping("api/layout")
  @ResponseBody
  public LayoutState get() {
    LayoutState state = new LayoutState();
    state.setLines(getAllLines());
    state.setTurnOuts(getAllTurnOuts());
    return state;
  }

  @PostMapping("api/motor")
  @ResponseBody
  public MotorControl postMotorCommand(MotorControl motorControl) {
    return motorController.setState(motorControl.getId(), motorControl.getSpeed(),
        motorControl.isReversed());
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

  private static <TEntity, TId> TEntity findById(TId id, JpaRepository<TEntity, TId> repository) {
    Optional<TEntity> queryResult = repository.findById(id);
    if (!queryResult.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching entity in database.");
    }

    return queryResult.get();
  }
}
