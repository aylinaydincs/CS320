package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public Movie findById(int id);

}