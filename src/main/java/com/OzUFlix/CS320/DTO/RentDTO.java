package com.OzUFlix.CS320.DTO;

import com.OzUFlix.CS320.Model.Movie;
import com.OzUFlix.CS320.Model.Penalty;
import com.OzUFlix.CS320.Model.Return_Movie;
import com.OzUFlix.CS320.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

public class RentDTO {
    private int id;
    private User user;
    private Movie movie;
    private Date date;
    private Penalty penalty;
    private Return_Movie return_movie;

    public RentDTO(int id, User user, Movie movie, Date date, Penalty penalty, Return_Movie return_movie) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.date = date;
        this.penalty = penalty;
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
