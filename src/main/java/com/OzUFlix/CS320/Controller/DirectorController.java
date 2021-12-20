package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.Model.Director;
import com.OzUFlix.CS320.Service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    DirectorService directorService;

    @GetMapping
    public List<Director> findAll() {
        return directorService.findAll();
    }

    @GetMapping("/{director-id}")
    public Director getMovieById(@PathVariable("director-id") int id) {
        return directorService.findById(id);
    }

    @DeleteMapping("/{director-id}")
    public void deleteById(@PathVariable("director-id") int id) {
        directorService.deleteById(id);
    }

    @PostMapping
    public Director saveMovie(@RequestBody Director director) {
        return directorService.save(director);
    }

}
