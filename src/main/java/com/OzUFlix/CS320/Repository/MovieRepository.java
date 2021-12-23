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

    @Query("SELECT m FROM Movie AS m WHERE m.name= ?1")
    public List<Movie> findMovieByName(String movieInfo);

    @Query("SELECT m FROM Movie AS m INNER JOIN m.topic AS t WHERE t.name= ?1")
    public List<Movie> findMovieByTopic(String movieInfo);

    @Query("SELECT m FROM Movie AS m INNER JOIN m.director AS d WHERE d.name= ?1")
    public List<Movie> findMovieByDirector(String movieInfo);

    @Query("SELECT m FROM Movie AS m INNER JOIN m.available AS a WHERE a.info= ?1")
    public List<Movie> findMovieByAvailable(int movieInfo);

}