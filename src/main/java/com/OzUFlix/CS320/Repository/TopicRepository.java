package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    public Topic findById(int id);

}