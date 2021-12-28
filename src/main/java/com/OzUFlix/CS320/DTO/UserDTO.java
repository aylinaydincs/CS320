package com.OzUFlix.CS320.DTO;

import com.OzUFlix.CS320.Model.Penalty;
import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Model.Return_Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private int id;
    private String name;
    private String password;
    private int userType;
    private List<Rent> rents = new ArrayList<Rent>();
    private List<Penalty> penalties = new ArrayList<Penalty>();
    public UserDTO(){}

    public UserDTO(int id, String name, String password, int userType, List<Rent> rents,  List<Penalty> penalties) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userType = userType;
        this.rents = rents;
        this.penalties = penalties;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public List<Penalty> getPenalties() {
        return penalties;
    }

    public void setPenalties(List<Penalty> penalties) {
        this.penalties = penalties;
    }
}
