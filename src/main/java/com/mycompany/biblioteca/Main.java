package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();

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

        cliente.setNombre(nombre);
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
    public static void crearLibro() {

        System.out.print("Ingrese código del libro: ");
        String codigo = sc.nextLine();

        if (buscarLibro(codigo) != null) {
            System.out.println("Ya existe un libro con ese código.");
            return;
        }

        System.out.print("Ingrese título: ");
        String titulo = sc.nextLine();

        System.out.print("Ingrese año de publicación: ");
        String anioPublicacion = sc.nextLine();

        System.out.print("Ingrese autor: ");
        String autor = sc.nextLine();

        Libro nuevoLibro =
                new Libro(codigo, titulo, anioPublicacion, autor, true);

        libros.add(nuevoLibro);

        System.out.println("Libro creado correctamente.");
    }
    public static void listarLibros(){
        if(libros.isEmpty()){
           System.out.println("No hay libros registrados.");
           return;
        }
        System.out.println("Lista de libros:");
        for (Libro libro :libros){
            System.out.println(libro);
        }
    }
    public static Libro buscarLibro(String code) {
        for (Libro libro: libros){
            if (libro.getCodigo().equalsIgnoreCase(code)){
                return libro;
            }
        }
        return null;
    }
    public static void actualizarLibro (){

        System.out.println("Ingrese el codigo del libro a actualizar:");
        String codigo = sc.nextLine();

        Libro libro = buscarLibro(codigo);

        if (libro==null){
            System.out.println("Libro no encontrado.");
        }

        System.out.println("Nuevo titulo: ");
        String titulo = sc.nextLine();

        System.out.println("Nuevo año de publicacion: ");
        String aniopublicacion = sc.nextLine();

        System.out.println("Nuevo Autor: ");
        String autor = sc.nextLine();

        libro.setTitulo(titulo);
        libro.setAniopublicacion(aniopublicacion);
        libro.setAutor(codigo);

        System.out.println("Libro actualizado correctamente.");

    }
    public static void eliminarLibro() {

        System.out.print("Ingrese el código del libro a eliminar: ");
        String codigo = sc.nextLine();

        Libro libro = buscarLibro(codigo);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        libros.remove(libro);

        System.out.println("Libro eliminado correctamente.");
    }
    public static void crearPrestamo() {

        System.out.print("Ingrese ID del préstamo: ");
        String idPrestamo = sc.nextLine();

        System.out.print("Ingrese ID del cliente: ");
        String idCliente = sc.nextLine();

        Cliente cliente = buscarCliente(idCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese código del libro: ");
        String codigoLibro = sc.nextLine();

        Libro libro = buscarLibro(codigoLibro);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible.");
            return;
        }

        Prestamo prestamo = new Prestamo(
                idPrestamo,
                cliente,
                libro,
                LocalDate.now(),
                "ACTIVO"
        );

        prestamos.add(prestamo);
        libro.setDisponible(false);

        System.out.println("Préstamo registrado correctamente.");
    }
    public static void devolucion() {

        System.out.print("Ingrese ID del préstamo: ");
        String idPrestamo = sc.nextLine();

        for (Prestamo prestamo : prestamos) {

            if (prestamo.getIdPrestamo().equalsIgnoreCase(idPrestamo)) {

                if (prestamo.getEstado().equalsIgnoreCase("DEVUELTO")) {
                    System.out.println("Este préstamo ya fue devuelto.");
                    return;
                }

                prestamo.setEstado("DEVUELTO");
                prestamo.getLibro().setDisponible(true);

                System.out.println("Devolución registrada correctamente.");
                return;
            }
        }

        System.out.println("Préstamo no encontrado.");
    }
}