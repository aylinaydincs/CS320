package com.OzUFlix.CS320.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_RENT")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @ManyToOne
    @NotNull
    @JsonIgnore
    private User user;

    @ManyToOne
    @NotNull
    @JsonIgnore
    private Movie movie;

    @NotNull
    @Column(name = "DATE")
    private Date date;

    @OneToOne
    @JsonIgnore
    private Penalty penalty;

    @OneToOne
    @JsonIgnore
    private Return_Movie return_movie;

    public Rent(){}

    public Rent(User user, Movie movie, Date date) {
        this.user = user;
        this.movie = movie;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public Return_Movie getReturn_movie() {
        return return_movie;
    }

    public void setReturn_movie(Return_Movie return_movie) {
        this.return_movie = return_movie;
    }
}
