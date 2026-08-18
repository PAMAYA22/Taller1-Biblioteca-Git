package com.mycompany.biblioteca;

public class Cliente extends Persona {

    private String email;

    public Cliente(String id, String name, String cel, String email) {
        super(id, name, cel);
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
        return "Cliente{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getName() + '\'' +
                ", telefono='" + getCel() + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
