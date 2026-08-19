package com.mycompany.biblioteca;

public class Libro extends Material {

    private String autor;
    private boolean disponible;

    public Libro(String codido, String titulo, String aniopublicacion, String autor, boolean disponible) {
        super(codido, titulo, aniopublicacion);
        this.autor = autor;
        this.disponible = disponible;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "----------------------------------------\n" +
                "Código       : " + getCodigo() + "\n" +
                "Título       : " + getTitulo() + "\n" +
                "Año          : " + getAniopublicacion() + "\n" +
                "Autor        : " + autor + "\n" +
                "Disponible   : " + (disponible ? "Sí" : "No") + "\n" +
                "----------------------------------------";
    }
}
