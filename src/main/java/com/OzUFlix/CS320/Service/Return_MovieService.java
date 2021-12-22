package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.Model.Return_Movie;
import com.OzUFlix.CS320.Repository.Return_MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Return_MovieService {
    @Autowired
    Return_MovieRepository return_movieRepository;

    public Return_Movie save(Return_Movie return_Movie){ return return_movieRepository.save(return_Movie); }

    public List<Return_Movie> findAll(){ return return_movieRepository.findAll();}

    public Return_Movie findById(int id){ return return_movieRepository.findById(id); }

    public void deleteById(int id){ return_movieRepository.deleteById(id); }
}