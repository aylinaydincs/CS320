package com.OzUFlix.CS320.DTO;

import com.OzUFlix.CS320.Model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class AvailableDTO {
    private int id;
    private int info;
    private List<Movie> movies = new ArrayList<Movie>();
    public AvailableDTO(){}

    public AvailableDTO(int id, int info, List<Movie> movies) {
        this.id = id;
        this.info = info;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
