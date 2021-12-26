package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.AvailableDTO;
import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Model.Movie;
import com.OzUFlix.CS320.Repository.AvailableRepository;
import com.OzUFlix.CS320.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailableService {
    @Autowired
    AvailableRepository availableRepository;

    @Autowired
    MovieRepository movieRepository;

    public Available save(Available available){ return availableRepository.save(available);}
/*
    public AvailableDTO saveMovie(int movieId, int availableId){
        Movie movie = movieRepository.findById(movieId);
        Available available = availableRepository.findById(availableId);
        List<Movie> list = new ArrayList<>();
        list.addAll(available.getMovies());
        if(availableId==1){
            Available availableNot = availableRepository.findById(availableId+1);
            availableNot.getMovies().remove(movie);
        }else{
            Available availableNot = availableRepository.findById(availableId-1);
            availableNot.getMovies().remove(movie);
        }
        list.add(movie);
        available.setMovies(list);
        availableRepository.save(available);
        AvailableDTO availableDTO = new AvailableDTO(available.getId(),available.getInfo(), available.getMovies());

        movie.setAvailable(available);
        movieRepository.save(movie);

        return  availableDTO;
    }
*/
    public List<AvailableDTO> findAll(){
        List<Available> availables = availableRepository.findAll();
        List<AvailableDTO> availableDTOs = new ArrayList<AvailableDTO>();
        for (Available available: availables) {
            availableDTOs.add(new AvailableDTO(available.getId(),available.getInfo(),available.getMovies()));
        }
        return availableDTOs;
    }

    public AvailableDTO findById(int id){
        Available available = availableRepository.findById(id);
        AvailableDTO availableDTO = new AvailableDTO(available.getId(),available.getInfo(), available.getMovies());
        return  availableDTO;
    }

    public void deleteById(int id){ availableRepository.deleteById(id); }
}