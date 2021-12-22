package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public Movie findById(int id);

    @Query("SELECT m FROM Movie m WHERE m.available = ?1")
    public List<Movie> searchMovie(int available);

}