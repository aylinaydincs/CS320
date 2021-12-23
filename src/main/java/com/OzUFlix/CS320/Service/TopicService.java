package com.OzUFlix.CS320.Service;


import com.OzUFlix.CS320.DTO.RentDTO;
import com.OzUFlix.CS320.DTO.TopicDTO;
import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Model.Topic;
import com.OzUFlix.CS320.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    public Topic save(Topic topic){ return topicRepository.save(topic); }

    public List<TopicDTO> findAll(){
        List<Topic> topics = topicRepository.findAll();
        List<TopicDTO> topicDTOS = new ArrayList<>();
        for (Topic topic: topics) {
            topicDTOS.add(new TopicDTO(topic.getId(),topic.getName(),topic.getMovies()));
        }
        return topicDTOS;
    }

    public TopicDTO findById(int id){
        Topic topic = topicRepository.findById(id);
        TopicDTO topicDTO = new TopicDTO(topic.getId(),topic.getName(),topic.getMovies());
        return  topicDTO;
    }

    public void deleteById(int id){
        topicRepository.deleteById(id);
    }
}