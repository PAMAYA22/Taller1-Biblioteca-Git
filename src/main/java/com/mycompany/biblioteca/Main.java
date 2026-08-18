package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void crearCliente() {

        System.out.print("Ingrese ID: ");
        String id = sc.nextLine();

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Ingrese email: ");
        String email = sc.nextLine();

        Cliente nuevoCliente = new Cliente(id, nombre, telefono, email);

        clientes.add(nuevoCliente);

        System.out.println("Cliente creado correctamente.");
    }
    public static void listarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Lista de clientes:");

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
    public static Cliente buscarCliente(String id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId().equalsIgnoreCase(id)) {
                return cliente;
            }
        }

        return null;
    }
    public static void actualizarCliente() {

        System.out.print("Ingrese el ID del cliente a actualizar: ");
        String id = sc.nextLine();

        Cliente cliente = buscarCliente(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nuevo teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Nuevo email: ");
        String email = sc.nextLine();

        cliente.setName(nombre);
        cliente.setCel(telefono);
        cliente.setEmail(email);

        System.out.println("Cliente actualizado correctamente.");
    }
    public static void elimiminarCliente(){

        System.out.println("Ingrese el ID del cliente a eliminar:");
        String id = sc.nextLine();

        Cliente cliente = buscarCliente(id);

        if(cliente == null){
            System.out.println("Cliente no encontrado.");
            return;
        }
        clientes.remove(cliente);
        System.out.println("Cliente eliminado correctamente.");

    }
}