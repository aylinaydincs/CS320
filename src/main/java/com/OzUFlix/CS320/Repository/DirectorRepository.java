package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

    public Director findById(int id);

}