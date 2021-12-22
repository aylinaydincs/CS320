package com.OzUFlix.CS320.Controller;

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
    public List<Topic> findAll(){ return topicService.findAll(); }

    @GetMapping("/{topic-id}")
    public Topic getUserById(@PathVariable("topic-id") int id) {return topicService.findById(id); }

    @DeleteMapping("/{topic-id}")
    public void deleteById(@PathVariable("topic-id") int id){ topicService.deleteById(id); }

    @PostMapping
    public Topic saveUser(@RequestBody Topic topic){
        return topicService.save(topic);
    }
}