package com.OzUFlix.CS320.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "T_AVAILABLE")
public class Available {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @Column(name = "INFO", columnDefinition = "integer default '1'")
    @NotNull
    private int info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
}
