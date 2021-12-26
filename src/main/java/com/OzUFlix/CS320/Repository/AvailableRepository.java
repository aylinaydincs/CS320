package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableRepository extends JpaRepository<Available, Integer> {

    public Available findById(int id);


}