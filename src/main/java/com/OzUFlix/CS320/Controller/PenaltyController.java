package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.Model.Penalty;
import com.OzUFlix.CS320.Service.PenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/penalties")
public class PenaltyController {

    @Autowired
    PenaltyService penaltyService;

    @GetMapping
    public List<Penalty> findAll(){ return penaltyService.findAll(); }

    @GetMapping("/{penalty-id}")
    public Penalty getUserById(@PathVariable("penalty-id") int id) {return penaltyService.findById(id); }

    @DeleteMapping("/{penalty-id}")
    public void deleteById(@PathVariable("penalty-id") int id){ penaltyService.deleteById(id); }

    @PostMapping
    public Penalty saveUser(@RequestBody Penalty penalty){
        return penaltyService.save(penalty);
    }
}

