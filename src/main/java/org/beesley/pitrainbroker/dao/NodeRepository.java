package org.beesley.pitrainbroker.dao;

import org.beesley.pitrainbroker.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer> {

}
