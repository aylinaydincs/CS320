package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
    @Autowired
    RentRepository rentRepository;

    public Rent save(Rent rent){ return rentRepository.save(rent); }

    public List<Rent> findAll(){ return rentRepository.findAll();}

    public Rent findById(int id){ return rentRepository.findById(id); }

    public void deleteById(int id){ rentRepository.deleteById(id); }
}