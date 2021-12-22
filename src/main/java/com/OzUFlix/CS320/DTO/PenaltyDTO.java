package com.OzUFlix.CS320.DTO;

import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Model.Return_Movie;
import com.OzUFlix.CS320.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

public class PenaltyDTO {
    private int id;
    private User user;
    private Rent rent;
    private Return_Movie return_movie;

    public PenaltyDTO(int id, User user, Rent rent, Return_Movie return_movie) {
        this.id = id;
        this.user = user;
        this.rent = rent;
        this.return_movie = return_movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Return_Movie getReturn_movie() {
        return return_movie;
    }

    public void setReturn_movie(Return_Movie return_movie) {
        this.return_movie = return_movie;
    }
}
