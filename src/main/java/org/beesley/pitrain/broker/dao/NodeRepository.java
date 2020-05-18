package org.beesley.pitrain.broker.dao;

import org.beesley.pitrain.broker.models.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer> {

}
