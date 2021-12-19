package com.OzUFlix.CS320.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_RETURN_MOVIE")
public class Return_Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @NotNull
    @Column(name = "DATE")
    private Date date;

    @NotNull
    @Column(name = "RENT")
    @OneToOne
    private Rent rent;

    @OneToOne
    @Column(name = "PENALTY")
    private Penalty penalty;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
