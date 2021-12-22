package com.OzUFlix.CS320.Service;


import com.OzUFlix.CS320.Model.Topic;
import com.OzUFlix.CS320.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    public Topic save(Topic topic){ return topicRepository.save(topic); }

    public List<Topic> findAll(){ return topicRepository.findAll();}

    public Topic findById(int id){ return topicRepository.findById(id); }

    public void deleteById(int id){
        topicRepository.deleteById(id);
    }
}