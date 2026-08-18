package com.mycompany.biblioteca;

public class Libro extends Material {

    private String author;
    private boolean disponible;

    public Libro(String code, String title, String aniopublication, String author, boolean disponible) {
        super(code, title, aniopublication);
        this.author = author;
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "libro{"+
                "codigo="+ getCode() + '\'' +
                ", titulo='" + getTitle() + '\'' +
                ", aniopublicacion='" + getAniopublication() + '\'' +
                ", autor='" + author + '\'' +
                ", disponible=" + disponible +
                '}';

    }
}
