package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Service.AvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/availableMovies")
public class AvailableController {

    @Autowired
    AvailableService availableMovieService;

    @GetMapping
    public List<Available> findAll() {
        return availableMovieService.findAll();
    }

    @GetMapping("/{available-id}")
    public Available getAvailableById(@PathVariable("available-id") int id) {
        return availableMovieService.findById(id);
    }

    @DeleteMapping("/{available-id}")
    public void deleteById(@PathVariable("available-id") int id) {
        availableMovieService.deleteById(id);
    }

    @PostMapping
    public Available saveAvailableMovie(@RequestBody Available availableMovie) {
        return availableMovieService.save(availableMovie);
    }
}
