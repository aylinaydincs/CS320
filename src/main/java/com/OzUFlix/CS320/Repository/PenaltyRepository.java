package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenaltyRepository extends JpaRepository<Penalty, Integer> {

    public Penalty findById(int id);

}