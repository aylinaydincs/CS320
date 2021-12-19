package com.OzUFlix.CS320.Model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_RENT")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @ManyToOne
    @NotNull
    @Column(name = "USER")
    private User user;

    @ManyToOne
    @NotNull
    @Column(name = "MOVIE")
    private Movie movie;

    @NotNull
    @Column(name = "DATE")
    private Date date;

    @OneToOne
    @Column(name = "PENALTY")
    private Penalty penalty;

    @OneToOne
    @Column(name = "RETURN_MOVIE")
    private Return_Movie return_movie;

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
}
