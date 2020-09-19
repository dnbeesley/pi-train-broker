package org.beesley.pitrain.broker.dao;

import org.beesley.pitrain.models.MotorControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorControlRepository extends JpaRepository<MotorControl, Integer> {

}
