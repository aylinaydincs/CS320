package com.OzUFlix.CS320.Repository;

import com.OzUFlix.CS320.Model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

    public Rent findById(int id);

}