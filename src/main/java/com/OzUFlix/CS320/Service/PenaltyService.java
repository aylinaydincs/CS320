package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.DirectorDTO;
import com.OzUFlix.CS320.DTO.PenaltyDTO;
import com.OzUFlix.CS320.Model.Director;
import com.OzUFlix.CS320.Model.Penalty;
import com.OzUFlix.CS320.Repository.PenaltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PenaltyService {
    @Autowired
    PenaltyRepository penaltyRepository;

    public Penalty save(Penalty penalty){ return penaltyRepository.save(penalty); }

    public List<PenaltyDTO> findAll(){
        List<Penalty> penalties = penaltyRepository.findAll();
        List<PenaltyDTO> penaltyDTOS = new ArrayList<PenaltyDTO>();
        for (Penalty penalty: penalties) {
            penaltyDTOS.add(new PenaltyDTO(penalty.getId(),penalty.getUser(),penalty.getRent(),penalty.getReturn_movie()));
        }
        return penaltyDTOS;
    }

    public PenaltyDTO findById(int id){
        Penalty penalty = penaltyRepository.findById(id);
        PenaltyDTO penaltyDTO = new PenaltyDTO(penalty.getId(),penalty.getUser(),penalty.getRent(),penalty.getReturn_movie());
        return  penaltyDTO;
    }

    public void deleteById(int id){ penaltyRepository.deleteById(id); }
}