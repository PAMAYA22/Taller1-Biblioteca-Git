package com.mycompany.biblioteca;

public class Persona {

   private String id;
   private String nombre;
   private String cel;

    public Persona(String id, String nombre, String cel) {
        this.id = id;
        this.nombre = nombre;
        this.cel = cel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
}
