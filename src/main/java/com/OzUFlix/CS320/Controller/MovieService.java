package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.Model.Movie;
import com.OzUFlix.CS320.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie save(Movie movie){ return movieRepository.save(movie); }

    public List<Movie> findAll(){ return movieRepository.findAll();}

    public Movie findById(int id){ return movieRepository.findById(id); }

    public void deleteById(int id){ movieRepository.deleteById(id); }
}