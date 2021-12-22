package com.OzUFlix.CS320.DTO;

import com.OzUFlix.CS320.Model.Available;
import com.OzUFlix.CS320.Model.Director;
import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Model.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDTO {
    private int id;
    private String name;
    private Director director;
    private Topic topic;
    private Available available;
    private List<Rent> rents = new ArrayList<Rent>();

    public MovieDTO(int id, String name, Director director, Topic topic, Available available, List<Rent> rents) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.topic = topic;
        this.available = available;
        this.rents = rents;
    }

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

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}
