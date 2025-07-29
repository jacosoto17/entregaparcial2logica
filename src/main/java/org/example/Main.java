package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String opcionMenu;

        do {
            System.out.println("===== 👋Bienvenido al Supermercado La Florida👋 =====");
            System.out.print("\n¿Qué quieres hacer?: " +
                    "\n  1. ➕ Agregar producto al sistema" +
                    "\n  2. ➖ Eliminar producto del sistema por ID" +
                    "\n  3. 💱 Editar Precio" +
                    "\n  4. 👀 Mostrar la lista de productos agregados" +
                    "\n  5. ❌ Salir del sistema" +
                    "\n🖥️ Ingrese el número de opción: ");
            opcionMenu = scanner.nextLine();

            switch (opcionMenu) {
                case "1":
                    agregarProducto(scanner, listaProductos);
                    break;

                case "2":
                    eliminarProducto(scanner, listaProductos);
                    break;

                case "3":
                    editarPrecio(scanner, listaProductos);
                    break;

                case "4":
                    mostrarProductos(listaProductos);
                    break;

                case "5":
                    System.out.println("👋 ¡Gracias por usar el sistema!");
                    break;

                default:
                    System.out.println("❌ Opción inválida. Intente de nuevo.");
            }

        } while (!opcionMenu.equals("5"));

        scanner.close();
    }

    private static void agregarProducto(Scanner scanner, ArrayList<Producto> listaProductos) {

        System.out.println("\n📋Formulario para agregar productos:");

        System.out.print("✍️ Ingresa un nombre para el producto: ");
        String nombre = scanner.nextLine();

        System.out.print("🆔 Ingresa un ID para el producto: ");
        String id = scanner.nextLine();

        System.out.print("🚚 Ingresa el nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();

        System.out.print("ℹ️ Ingresa una categoría para el producto: ");
        String categoria = scanner.nextLine();

        System.out.print("🗣️ Ingresa una descripción para el producto: ");
        String descripcion = scanner.nextLine();

        System.out.print("📷 Ingresa la primera fotografía del producto: ");
        String fotografia1 = scanner.nextLine();

        System.out.print("🖼️ Ingresa la segunda fotografía del producto: ");
        String fotografia2 = scanner.nextLine();

        LocalDate fechaIngreso = LocalDate.now();

        System.out.print("🍎 ¿El producto es perecedero? (sí/no): ");
        String respuestaPerecedero = scanner.nextLine().trim().toLowerCase();
        boolean perecedero = respuestaPerecedero.equals("sí") || respuestaPerecedero.equals("si");

        LocalDate fechaVencimiento = null;
        if (perecedero) {
            System.out.print("📅 Ingresa el año de vencimiento: ");
            int año = scanner.nextInt();
            System.out.print("📆 Ingresa el mes de vencimiento: ");
            int mes = scanner.nextInt();
            System.out.print("🗓️ Ingresa el día de vencimiento: ");
            int dia = scanner.nextInt();
            fechaVencimiento = LocalDate.of(año, mes, dia);
            scanner.nextLine();
        }

        System.out.print("💲 Ingresa el precio unitario del producto: ");
        int precioUnitario = scanner.nextInt();

        System.out.print("📦 Ingresa la cantidad en bodega: ");
        int cantidadBodega = scanner.nextInt();
        scanner.nextLine();

        Producto productoNuevo = new Producto(
                id, nombre, descripcion, categoria, nombreProveedor,
                fotografia1, fotografia2, fechaIngreso,
                fechaVencimiento, precioUnitario, cantidadBodega,
                perecedero
        );

        listaProductos.add(productoNuevo);

        System.out.println("✔️ El producto fue agregado con éxito.");
    }

    private static void eliminarProducto(Scanner scanner, ArrayList<Producto> listaProductos) {

        System.out.println("\n✖️ Vamos a eliminar un producto por ID:");

        if (listaProductos.isEmpty()) {
            System.out.println("❌ No hay productos en el sistema.");
            return;
        }

        for (Producto p : listaProductos) {
            System.out.println("- ID: " + p.id + " | Nombre: " + p.nombre);
        }

        System.out.print("🔍 Ingrese el ID del producto que desea eliminar: ");
        String idEliminar = scanner.nextLine();

        Producto productoAEliminar = null;

        for (Producto p : listaProductos) {
            if (p.id.equalsIgnoreCase(idEliminar)) {
                productoAEliminar = p;
                break;
            }
        }

        if (productoAEliminar != null) {
            listaProductos.remove(productoAEliminar);
            System.out.println("✅ El producto fue eliminado con éxito.");
        } else {
            System.out.println("❌ No se encontró un producto con ese ID.");
        }
    }

    private static void mostrarProductos(ArrayList<Producto> listaProductos) {

        System.out.println("\n📋 Lista de productos:");

        if (listaProductos.isEmpty()) {
            System.out.println("❌ No hay ningun producto registrado.");
            return;
        }

        int numeroProducto = 1;
        for (Producto p : listaProductos) {
            System.out.println("\nProducto Número " + numeroProducto++);
            System.out.println(p);
        }
    }

    private static void editarPrecio(Scanner scanner, ArrayList<Producto> listaProductos) {

        System.out.println("\n💱 Editar el valor de un producto:");

        if (listaProductos.isEmpty()) {
            System.out.println("❌ No hay productos disponibles para editar.");
            return;
        }

        for (int i = 0; i < listaProductos.size(); i++) {
            Producto p = listaProductos.get(i);
            System.out.println("Producto número " + (i + 1) + ": " + p.nombre + ", Precio actual: $" + p.precioUnitario);
        }

        System.out.print("🖥️ Ingrese el número del producto que desea cambiar su precio: ");
        int opcionEditar = scanner.nextInt();

        System.out.print("💲 Ingrese el nuevo valor: ");
        int nuevoValor = scanner.nextInt();
        scanner.nextLine();

        if (opcionEditar > 0 && opcionEditar <= listaProductos.size()) {
            listaProductos.get(opcionEditar - 1).precioUnitario = nuevoValor;
            System.out.println("✅ Se ha actualizado el precio con éxito.");
        } else {
            System.out.println("❌ Opción inválida.");
        }
    }
}

