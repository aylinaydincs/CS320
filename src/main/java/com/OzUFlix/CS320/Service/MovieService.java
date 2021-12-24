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

    public MovieDTO saveDirector(int movieId, int directorId){
        Director director = directorRepository.findById(directorId);
        Movie movie = movieRepository.findById(movieId);
        movie.setDirector(director);
        movieRepository.save(movie);
        MovieDTO movieDTO = new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents());

        List<Movie> list = new ArrayList<>();
        list.addAll(director.getMovies());
        list.add(movie);
        director.setMovies(list);
        directorRepository.save(director);

        return  movieDTO;
    }

    public MovieDTO saveTopic(int movieId, int topicId){
        Topic topic = topicRepository.findById(topicId);
        Movie movie = movieRepository.findById(movieId);
        movie.setTopic(topic);
        movieRepository.save(movie);
        MovieDTO movieDTO = new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents());

        List<Movie> list = new ArrayList<>();
        list.addAll(topic.getMovies());
        list.add(movie);
        topic.setMovies(list);
        topicRepository.save(topic);

        return  movieDTO;
    }

    public MovieDTO saveAvailable(int movieId, int availableId){
        Available available = availableRepository.findById(availableId);
        Movie movie = movieRepository.findById(movieId);
        movie.setAvailable(available);
        movieRepository.save(movie);
        MovieDTO movieDTO = new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents());

        List<Movie> list = new ArrayList<>();
        list.addAll(available.getMovies());
        list.add(movie);
        available.setMovies(list);
        availableRepository.save(available);

        return  movieDTO;
    }

    public MovieDTO saveRent(int movieId, int rentId){
        Rent rent = rentRepository.findById(rentId);
        Movie movie = movieRepository.findById(movieId);
        List<Rent> list = new ArrayList<>();
        list.addAll(movie.getRents());
        list.add(rent);
        movie.setRents(list);
        MovieDTO movieDTO = new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents());

        rent.setMovie(movie);
        rentRepository.save(rent);

        return  movieDTO;
    }


}