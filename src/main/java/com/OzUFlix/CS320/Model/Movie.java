package com.OzUFlix.CS320.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @NotNull
    @Column(name = "DIRECTOR")
    private Director director;

    @ManyToOne
    @NotNull
    @Column(name = "TOPIC")
    private Topic topic;

    @ManyToOne
    @NotNull
    @Column(name = "AVAILABLE")
    private Available available;

    @OneToMany(mappedBy = "movie")
    @NotNull
    @Column(name = "RENT")
    private List<Rent> rents = new ArrayList<Rent>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
