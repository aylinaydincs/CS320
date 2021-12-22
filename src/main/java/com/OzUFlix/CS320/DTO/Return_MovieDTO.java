package com.OzUFlix.CS320.DTO;

import com.OzUFlix.CS320.Model.Penalty;
import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

public class Return_MovieDTO {
    private int id;
    private User user;
    private Date date;
    private Rent rent;
    private Penalty penalty;

    public Return_MovieDTO(int id, User user, Date date, Rent rent, Penalty penalty) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.rent = rent;
        this.penalty = penalty;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }
}
