package org.beesley.pitrainbroker.dao;

import org.beesley.pitrainbroker.model.MotorControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorControlRepository extends JpaRepository<MotorControl, Integer> {

}
