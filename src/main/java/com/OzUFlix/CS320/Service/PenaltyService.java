package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.Model.Penalty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyService {
    @Autowired
    PenaltyService penaltyService;

    public Penalty save(Penalty penalty){ return penaltyService.save(penalty); }

    public List<Penalty> findAll(){ return penaltyService.findAll();}

    public Penalty findById(int id){ return penaltyService.findById(id); }

    public void deleteById(int id){ penaltyService.deleteById(id); }
}