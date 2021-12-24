package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.DTO.AvailableDTO;
import com.OzUFlix.CS320.DTO.TopicDTO;
import com.OzUFlix.CS320.Model.Topic;
import com.OzUFlix.CS320.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping
    public List<TopicDTO> findAll(){ return topicService.findAll(); }

    @GetMapping("/{topic-id}")
    public TopicDTO getUserById(@PathVariable("topic-id") int id) {return topicService.findById(id); }

    @DeleteMapping("/{topic-id}")
    public void deleteById(@PathVariable("topic-id") int id){ topicService.deleteById(id); }

    @PostMapping
    public Topic save(@RequestBody Topic topic){
        return topicService.save(topic);
    }

    @PostMapping("/{topic-id}/movie/{movie-id}")
    public TopicDTO saveMovie(@PathVariable("topic-id") int topicId, @PathVariable("movie-id") int movieId) {
        return topicService.saveMovie(topicId, movieId);
    }
}