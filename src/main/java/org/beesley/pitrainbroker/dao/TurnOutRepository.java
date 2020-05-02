package org.beesley.pitrainbroker.dao;

import org.beesley.pitrainbroker.model.TurnOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnOutRepository extends JpaRepository<TurnOut, Integer> {

}
