package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieService movieService;

    public Movie save(Movie movie){ return movieService.save(movie); }

    public List<Movie> findAll(){ return movieService.findAll();}

    public Movie findById(int id){ return movieService.findById(id); }

    public void deleteById(int id){ movieService.deleteById(id); }
}