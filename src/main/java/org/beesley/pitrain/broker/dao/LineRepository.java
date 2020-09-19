package org.beesley.pitrain.broker.dao;

import org.beesley.pitrain.models.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<Line, Integer> {

}
