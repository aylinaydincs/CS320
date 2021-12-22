package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.Model.Penalty;
import com.OzUFlix.CS320.Repository.PenaltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyService {
    @Autowired
    PenaltyRepository penaltyRepository;

    public Penalty save(Penalty penalty){ return penaltyRepository.save(penalty); }

    public List<Penalty> findAll(){ return penaltyRepository.findAll();}

    public Penalty findById(int id){ return penaltyRepository.findById(id); }

    public void deleteById(int id){ penaltyRepository.deleteById(id); }
}