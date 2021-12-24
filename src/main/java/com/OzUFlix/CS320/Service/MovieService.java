package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.DirectorDTO;
import com.OzUFlix.CS320.DTO.MovieDTO;
import com.OzUFlix.CS320.Model.*;
import com.OzUFlix.CS320.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    AvailableRepository availableRepository;

    @Autowired
    RentRepository rentRepository;

    public Movie save(Movie movie){ return movieRepository.save(movie); }

    public List<MovieDTO> findAll(){
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();
        for (Movie movie: movies) {
            movieDTOs.add(new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents()));
        }
        return movieDTOs;
    }

    public MovieDTO findById(int id){
        Movie movie = movieRepository.findById(id);
        MovieDTO movieDTO = new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents());
        return  movieDTO;
    }

    public List<MovieDTO> searchMovie(String movieInfo){
        List<MovieDTO> movieDTOS = new ArrayList<>();

        List<Movie> movieNames = movieRepository.findMovieByName(movieInfo);
        List<Movie> movieTopics = movieRepository.findMovieByTopic(movieInfo);
        List<Movie> movieDirectors = movieRepository.findMovieByDirector(movieInfo);

        for (Movie movie : movieNames){
            movieDTOS.add(new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents()));
        }
        for (Movie movie : movieTopics){
            movieDTOS.add(new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents()));
        }
        for (Movie movie : movieDirectors){
            movieDTOS.add(new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents()));
        }

        return movieDTOS;
    }

    public List<MovieDTO> searchMovie(int movieInfo){
        List<MovieDTO> movieDTOS = new ArrayList<>();

        List<Movie> movieNames = movieRepository.findMovieByAvailable(movieInfo);

        for (Movie movie : movieNames){
            movieDTOS.add(new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents()));
        }
        return movieDTOS;
    }

    public void deleteById(int id){ movieRepository.deleteById(id); }

    public MovieDTO saveMovie(Movie movie, int directorId, int topicId){
        Director director = directorRepository.findById(directorId);
        movie.setDirector(director);

        Topic topic = topicRepository.findById(topicId);
        movie.setTopic(topic);

        Available available = availableRepository.findById(1);
        movie.setAvailable(available);

        movieRepository.save(movie);
        MovieDTO movieDTO = new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents());

        List<Movie> listDirector = new ArrayList<>();
        listDirector.addAll(director.getMovies());
        listDirector.add(movie);
        director.setMovies(listDirector);
        directorRepository.save(director);

        List<Movie> listTopic = new ArrayList<>();
        listTopic.addAll(topic.getMovies());
        listTopic.add(movie);
        topic.setMovies(listTopic);
        topicRepository.save(topic);

        List<Movie> listAvailable = new ArrayList<>();
        listAvailable.addAll(available.getMovies());
        listAvailable.add(movie);
        available.setMovies(listAvailable);
        availableRepository.save(available);

        return movieDTO;
    }

}