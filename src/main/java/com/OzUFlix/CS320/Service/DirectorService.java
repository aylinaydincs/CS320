package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.Model.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Autowired
    DirectorService directorService;

    public Director save(Director director){ return directorService.save(director); }

    public List<Director> findAll(){ return directorService.findAll();}

    public Director findById(int id){ return directorService.findById(id); }

    public void deleteById(int id){ directorService.deleteById(id); }
}