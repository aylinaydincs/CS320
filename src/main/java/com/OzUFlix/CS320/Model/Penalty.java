package com.OzUFlix.CS320.Model;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "T_PENALTY")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @NotNull
    @OneToOne
    @Column(name = "RENT")
    private Rent rent;

    @NotNull
    @OneToOne
    @Column(name = "RETURN_MOVIE")
    private Return_Movie return_movie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
