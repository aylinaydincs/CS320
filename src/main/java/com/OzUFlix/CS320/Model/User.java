package com.OzUFlix.CS320.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @NotNull
    @Column(name = "NAME", length = 80)
    private String name;

    @NotNull
    @Column(name = "PASSWORD", length = 80)
    private String password;

    @NotNull
    @Column(name = "USER_TYPE") //0 is manager, 1 is customer
    private int userType;

    @OneToMany(mappedBy = "user")
    @NotNull
    @Column(name = "RENT")
    private List<Rent> rents = new ArrayList<Rent>();

    @OneToMany(mappedBy = "user")
    @NotNull
    @Column(name = "RETURN_MOVIE")
    private List<Return_Movie> return_movies = new ArrayList<Return_Movie>();

    @OneToMany(mappedBy = "user")
    @NotNull
    @Column(name = "PENALTY")
    private List<Penalty> penalties = new ArrayList<Penalty>();

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

    public List<Return_Movie> getReturn_movies() {
        return return_movies;
    }

    public void setReturn_movies(List<Return_Movie> return_movies) {
        this.return_movies = return_movies;
    }

    public List<Penalty> getPenalties() {
        return penalties;
    }

    public void setPenalties(List<Penalty> penalties) {
        this.penalties = penalties;
    }
}
