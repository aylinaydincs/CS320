package com.OzUFlix.CS320.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_DIRECTOR")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    @Column(name = "NAME", length = 80)
    private String name;

    @OneToMany(mappedBy = "director", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Movie> movies = new ArrayList<Movie>();

    public Director(){}

    public Director(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
