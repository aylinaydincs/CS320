package com.OzUFlix.CS320.Model;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "T_TOPIC")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @NotNull
    @Column(name = "NAME")
    private String name;

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
}
