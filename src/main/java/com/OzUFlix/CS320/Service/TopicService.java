package com.OzUFlix.CS320.Service;


import com.OzUFlix.CS320.DTO.TopicDTO;
import com.OzUFlix.CS320.Model.Movie;
import com.OzUFlix.CS320.Model.Topic;
import com.OzUFlix.CS320.Repository.MovieRepository;
import com.OzUFlix.CS320.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    @Autowired
    MovieRepository movieRepository;

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

    public TopicDTO saveMovie(int topicId, int movieId){
        Movie movie = movieRepository.findById(movieId);
        Topic topic = topicRepository.findById(topicId);
        List<Movie> list = new ArrayList<>();
        list.addAll(topic.getMovies());
        list.add(movie);
        topic.setMovies(list);
        topicRepository.save(topic);
        TopicDTO topicDTO = new TopicDTO(topic.getId(),topic.getName(),topic.getMovies());

        movie.setTopic(topic);
        movieRepository.save(movie);

        return  topicDTO;
    }

}