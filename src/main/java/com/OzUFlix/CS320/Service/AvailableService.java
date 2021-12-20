package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Repository.AvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableService {
    @Autowired
    AvailableRepository availableRepository;

    public Available save(Available available){ return availableRepository.save(available); }

    public List<Available> findAll(){ return availableRepository.findAll();}

    public Available findById(int id){ return availableRepository.findById(id); }

    public void deleteById(int id){ availableRepository.deleteById(id); }
}