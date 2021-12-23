package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Available;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableRepository extends JpaRepository<Available, Integer> {

    public Available findById(int id);

}