package com.mycompany.biblioteca;

public class Material {

    private String codigo;
    private String titulo;
    private String aniopublicacion;

    public Material(String codigo, String titulo, String aniopublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.aniopublicacion = aniopublicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAniopublicacion() {
        return aniopublicacion;
    }

    public void setAniopublicacion(String aniopublicacion) {
        this.aniopublicacion = aniopublicacion;
    }
}
