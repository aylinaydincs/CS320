package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.AvailableDTO;
import com.OzUFlix.CS320.DTO.DirectorDTO;
import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Model.Director;
import com.OzUFlix.CS320.Model.Movie;
import com.OzUFlix.CS320.Repository.DirectorRepository;
import com.OzUFlix.CS320.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

    public Director save(Director director){ return directorRepository.save(director); }

    public List<DirectorDTO> findAll(){
        List<Director> directors = directorRepository.findAll();
        List<DirectorDTO> directorDTOs = new ArrayList<DirectorDTO>();
        for (Director director: directors) {
            directorDTOs.add(new DirectorDTO(director.getId(),director.getName(),director.getMovies()));
        }
        return directorDTOs;
    }

    public DirectorDTO findById(int id){
        Director director = directorRepository.findById(id);
        DirectorDTO directorDTO = new DirectorDTO(director.getId(),director.getName(),director.getMovies());
        return  directorDTO;
    }

    public DirectorDTO saveMovie(int directorId, int movieId){
        Movie movie = movieRepository.findById(movieId);
        Director director = directorRepository.findById(directorId);
        List<Movie> list = new ArrayList<>();
        list.addAll(director.getMovies());
        list.add(movie);
        director.setMovies(list);
        directorRepository.save(director);
        DirectorDTO directorDTO = new DirectorDTO(director.getId(),director.getName(),director.getMovies());

        movie.setDirector(director);
        movieRepository.save(movie);

        return  directorDTO;
    }

    public void deleteById(int id){ directorRepository.deleteById(id); }
}