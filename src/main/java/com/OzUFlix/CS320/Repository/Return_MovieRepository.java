package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Return_Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Return_MovieRepository extends JpaRepository<Return_Movie, Integer> {

    public Return_Movie findById(int id);

}