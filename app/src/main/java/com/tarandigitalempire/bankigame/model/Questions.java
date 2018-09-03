package com.tarandigitalempire.bankigame.model;

public class Questions {
    int id, id_soustheme;
    String question, reponse, option1, option2, option3, created_at;

    public Questions(int id, int id_soustheme, String question, String reponse, String option1, String option2, String option3, String created_at) {
        this.id = id;
        this.id_soustheme = id_soustheme;
        this.question = question;
        this.reponse = reponse;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_soustheme() {
        return id_soustheme;
    }

    public void setId_soustheme(int id_soustheme) {
        this.id_soustheme = id_soustheme;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
