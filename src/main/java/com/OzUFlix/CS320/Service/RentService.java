package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.PenaltyDTO;
import com.OzUFlix.CS320.DTO.RentDTO;
import com.OzUFlix.CS320.Model.Penalty;
import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentService {
    @Autowired
    RentRepository rentRepository;

    public Rent save(Rent rent){ return rentRepository.save(rent); }

    public List<RentDTO> findAll(){
        List<Rent> rents = rentRepository.findAll();
        List<RentDTO> rentDTOS = new ArrayList<>();
        for (Rent rent: rents) {
            rentDTOS.add(new RentDTO(rent.getId(),rent.getUser(),rent.getMovie(),rent.getDate(), rent.getPenalty(),rent.getReturn_movie()));
        }
        return rentDTOS;
    }

    public RentDTO findById(int id){
        Rent rent = rentRepository.findById(id);
        RentDTO rentDTO = new RentDTO(rent.getId(),rent.getUser(),rent.getMovie(),rent.getDate(), rent.getPenalty(),rent.getReturn_movie());
        return  rentDTO;
    }

    public void deleteById(int id){ rentRepository.deleteById(id); }
}