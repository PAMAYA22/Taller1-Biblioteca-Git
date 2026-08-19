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

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("   SISTEMA DE BIBLIOTECA");
            System.out.println("==============================");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de libros");
            System.out.println("3. Gestión de préstamos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {

                case 1:
                    menuClientes();
                    break;

                case 2:
                    menuLibros();
                    break;

                case 3:
                    menuPrestamos();
                    break;

                case 0:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
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
            System.out.println("\nNo hay clientes registrados.");
            return;
        }

        System.out.println("\n========== LISTA DE CLIENTES ==========");

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
        cliente.setTelefono(telefono);
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
    public static void listarLibros() {

        if (libros.isEmpty()) {
            System.out.println("\nNo hay libros registrados.");
            return;
        }

        System.out.println("\n========== LISTA DE LIBROS ==========");

        for (Libro libro : libros) {
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
    public static void listarPrestamos() {

        if (prestamos.isEmpty()) {
            System.out.println("\nNo hay préstamos registrados.");
            return;
        }

        System.out.println("\n========== LISTA DE PRÉSTAMOS ==========");

        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }
    public static void menuClientes() {

        int opcion;

        do {

            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {

                case 1:
                    crearCliente();
                    break;

                case 2:
                    listarClientes();
                    break;

                case 3:
                    System.out.print("Ingrese ID del cliente: ");
                    String id = sc.nextLine();

                    Cliente cliente = buscarCliente(id);

                    if (cliente != null) {
                        System.out.println(cliente);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 4:
                    actualizarCliente();
                    break;

                case 5:
                    elimiminarCliente();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
    public static void menuLibros() {

        int opcion;

        do {

            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1. Crear libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {

                case 1:
                    crearLibro();
                    break;

                case 2:
                    listarLibros();
                    break;

                case 3:
                    System.out.print("Ingrese código del libro: ");
                    String codigo = sc.nextLine();

                    Libro libro = buscarLibro(codigo);

                    if (libro != null) {
                        System.out.println(libro);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 4:
                    actualizarLibro();
                    break;

                case 5:
                    eliminarLibro();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
    public static void menuPrestamos() {

        int opcion;

        do {

            System.out.println("\n--- GESTIÓN DE PRÉSTAMOS ---");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Registrar devolución");
            System.out.println("3. Listar préstamos");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {

                case 1:
                    crearPrestamo();
                    break;

                case 2:
                    devolucion();
                    break;

                case 3:
                    listarPrestamos();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}