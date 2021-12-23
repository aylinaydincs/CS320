package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.DTO.RentDTO;
import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController {

    @Autowired
    RentService RentService;

    @GetMapping
    public List<RentDTO> findAll(){ return RentService.findAll(); }

    @GetMapping("/{Rent-id}")
    public RentDTO getRentById(@PathVariable("Rent-id") int id) {return RentService.findById(id); }

    @DeleteMapping("/{Rent-id}")
    public void deleteById(@PathVariable("Rent-id") int id){ RentService.deleteById(id); }

    @PostMapping
    public Rent saveRent(@RequestBody Rent Rent){
        return RentService.save(Rent);
    }
}

