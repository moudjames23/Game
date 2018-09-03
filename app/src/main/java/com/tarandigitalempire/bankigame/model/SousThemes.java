package com.tarandigitalempire.bankigame.model;

public class SousThemes {
    int id, id_theme;
    String name;
    String created_at;

    //Constructeur
    public SousThemes(int id, int id_theme, String name, String created_at) {
        this.id = id;
        this.id_theme = id_theme;
        this.name = name;
        this.created_at = created_at;
    }

    //Setteurs
    public void setId(int id) {
        this.id = id;
    }

    public void setId_theme(int id_theme) {
        this.id_theme = id_theme;
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

    public int getId_theme() {
        return id_theme;
    }

    public String getName() {
        return name;
    }

    public String getCreated_at() {
        return created_at;
    }
}
