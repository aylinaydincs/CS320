package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.AvailableDTO;
import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Repository.AvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailableService {
    @Autowired
    AvailableRepository availableRepository;

    public Available save(Available available){ return availableRepository.save(available); }

    public List<AvailableDTO> findAll(){
        List<Available> availables = availableRepository.findAll();
        List<AvailableDTO> availableDTOs = new ArrayList<AvailableDTO>();
        for (Available available: availables) {
            availableDTOs.add(new AvailableDTO(available.getId(),available.getInfo(),available.getMovies()));
        }
        return availableDTOs;
    }

    public AvailableDTO findById(int id){
        Available available = availableRepository.findById(id);
        AvailableDTO availableDTO = new AvailableDTO(available.getId(),available.getInfo(), available.getMovies());
        return  availableDTO;
    }

    public void deleteById(int id){ availableRepository.deleteById(id); }
}