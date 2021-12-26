package com.OzUFlix.CS320.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @JsonIgnore
    @ManyToOne
    @NotNull
    private Director director;

    @JsonIgnore
    @ManyToOne
    @NotNull
    private Topic topic;

    @JsonIgnore
    @ManyToOne
    @NotNull
    private Available available;

    @JsonIgnore
    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    @NotNull
    private List<Rent> rents = new ArrayList<Rent>();

    public Movie(){}

    public Movie(String name) {
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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Available getAvailable() {
        return available;
    }

    public void setAvailable(Available available) {
        this.available = available;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rent) {
        this.rents = rent;
    }
}
