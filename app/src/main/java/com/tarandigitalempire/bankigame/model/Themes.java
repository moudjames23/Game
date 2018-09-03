package com.tarandigitalempire.bankigame.model;

public class Themes {
    int id;
    String name;
    String created_at;

    //Constructeurs
    public Themes(){}
    public Themes(int id, String name, String created_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
    }

    //Setteurs
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    //Getteurs
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreated_at() {
        return created_at;
    }
}
