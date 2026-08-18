package com.mycompany.biblioteca;

public class Cliente extends Persona {

    private String email;

    public Cliente(String id, String nombre, String cel, String email) {
        super(id, nombre, cel);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "----------------------------------------\n" +
                "ID       : " + getId() + "\n" +
                "Nombre   : " + getNombre() + "\n" +
                "Teléfono : " + getTelefono() + "\n" +
                "Email    : " + email + "\n" +
                "----------------------------------------";
    }
}
