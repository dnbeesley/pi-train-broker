package org.beesley.pitrain.broker.dao;

import org.beesley.pitrain.broker.models.TurnOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnOutRepository extends JpaRepository<TurnOut, Integer> {

}
