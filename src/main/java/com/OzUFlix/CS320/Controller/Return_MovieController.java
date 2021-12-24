package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.DTO.RentDTO;
import com.OzUFlix.CS320.DTO.Return_MovieDTO;
import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Model.Return_Movie;
import com.OzUFlix.CS320.Service.Return_MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/return_movies")
public class Return_MovieController {

    @Autowired
    Return_MovieService return_MovieService;

    @GetMapping
    public List<Return_MovieDTO> findAll(){ return return_MovieService.findAll(); }

    @GetMapping("/{Return_Movie-id}")
    public Return_MovieDTO getReturn_MovieById(@PathVariable("Return_Movie-id") int id) {return return_MovieService.findById(id); }

    @DeleteMapping("/{Return_Movie-id}")
    public void deleteById(@PathVariable("Return_Movie-id") int id){ return_MovieService.deleteById(id); }

    @PostMapping
    public Return_Movie save(Return_Movie return_movie) {
        return return_MovieService.save(return_movie);
    }

    @PostMapping("/rent/{rent-id}")
    public Return_MovieDTO saveReturnMovie(@RequestBody Return_Movie returnMovie, @PathVariable("rent-id") int rentId) {
        return return_MovieService.saveReturnMovie(returnMovie, rentId);
    }

}
