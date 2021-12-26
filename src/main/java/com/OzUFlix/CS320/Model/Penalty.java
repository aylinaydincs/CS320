package com.OzUFlix.CS320.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "T_PENALTY")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @ManyToOne
    @NotNull
    @JsonIgnore
    private User user;

    @NotNull
    @OneToOne
    @JsonIgnore
    private Rent rent;

    @NotNull
    @OneToOne
    @JsonIgnore
    private Return_Movie return_movie;

    public Penalty(){}

    public Penalty(User user, Rent rent, Return_Movie return_movie) {
        this.user = user;
        this.rent = rent;
        this.return_movie = return_movie;
    }

    public int getId() {
        return id;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Return_Movie getReturn_movie() {
        return return_movie;
    }

    public void setReturn_movie(Return_Movie return_movie) {
        this.return_movie = return_movie;
    }
}
