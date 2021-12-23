package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.DTO.Return_MovieDTO;
import com.OzUFlix.CS320.Model.Return_Movie;
import com.OzUFlix.CS320.Service.Return_MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/return_movies")
public class Return_MovieController {

    @Autowired
    Return_MovieService Return_MovieService;

    @GetMapping
    public List<Return_MovieDTO> findAll(){ return Return_MovieService.findAll(); }

    @GetMapping("/{Return_Movie-id}")
    public Return_MovieDTO getReturn_MovieById(@PathVariable("Return_Movie-id") int id) {return Return_MovieService.findById(id); }

    @DeleteMapping("/{Return_Movie-id}")
    public void deleteById(@PathVariable("Return_Movie-id") int id){ Return_MovieService.deleteById(id); }

    @PostMapping
    public Return_Movie saveReturn_Movie(@RequestBody Return_Movie Return_Movie){
        return Return_MovieService.save(Return_Movie);
    }
}
