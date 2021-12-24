package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.DTO.MovieDTO;
import com.OzUFlix.CS320.DTO.PenaltyDTO;
import com.OzUFlix.CS320.DTO.RentDTO;
import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController {

    @Autowired
    RentService rentService;

    @GetMapping
    public List<RentDTO> findAll(){ return rentService.findAll(); }

    @GetMapping("/{Rent-id}")
    public RentDTO getRentById(@PathVariable("Rent-id") int id) { return rentService.findById(id); }

    @DeleteMapping("/{Rent-id}")
    public void deleteById(@PathVariable("Rent-id") int id){ rentService.deleteById(id); }

    @PostMapping
    public Rent save(Rent rent) {
        return rentService.save(rent);
    }

    @PostMapping("/user/{user-id}/movie/{movie-id}")
    public RentDTO saveRent(@RequestBody Rent Rent, @PathVariable("user-id") int userId, @PathVariable("movie-id") int movieId) {
        return rentService.saveRent(Rent, userId, movieId);
    }

    @GetMapping("/most")
    public MovieDTO getMost() { return rentService.getMost(); }

}

