package com.mycompany.biblioteca;

public class Material {

    private String code;
    private String title;
    private String aniopublication;

    public Material(String code, String title, String aniopublication) {
        this.code = code;
        this.title = title;
        this.aniopublication = aniopublication;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAniopublication() {
        return aniopublication;
    }

    public void setAniopublication(String aniopublication) {
        this.aniopublication = aniopublication;
    }
}
