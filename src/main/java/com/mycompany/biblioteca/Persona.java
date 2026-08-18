package com.mycompany.biblioteca;

public class Persona {

   private String id;
   private String name;
   private String cel;

    public Persona(String id, String name, String cel) {
        this.id = id;
        this.name = name;
        this.cel = cel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
}
