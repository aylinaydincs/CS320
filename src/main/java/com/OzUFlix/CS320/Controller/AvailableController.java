package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.DTO.AvailableDTO;
import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Model.Movie;
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
    public List<AvailableDTO> findAll() {
        return availableMovieService.findAll();
    }

    @GetMapping("/{available-id}")
    public AvailableDTO getAvailableById(@PathVariable("available-id") int id) {
        return availableMovieService.findById(id); }

    @PostMapping
    public Available save(Available available) {
        return availableMovieService.save(available);
    }

    @DeleteMapping("/{available-id}")
    public void deleteById(@PathVariable("available-id") int id) {
        availableMovieService.deleteById(id);
    }

    /*
    @PostMapping("/{available-id}/movie/{movie-id}")
    public AvailableDTO saveAvailableMovie(@PathVariable("available-id") int availableId,@PathVariable("movie-id") int movieId) {
        return availableMovieService.saveMovie(movieId, availableId);
    }
*/
}

