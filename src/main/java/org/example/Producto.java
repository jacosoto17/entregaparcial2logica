package org.example;

import java.time.LocalDate;

public class Producto {

    String id;
    String nombre;
    String descripcion;
    String categoria;
    String nombreProveedor;
    String fotografia1;
    String fotografia2;
    LocalDate fechaIngreso;
    LocalDate fechaVencimiento; // puede ser null si no perecedero
    int precioUnitario;
    int cantidadBodega;
    boolean perecedero;
    boolean vencido;

    public Producto(String id, String nombre, String descripcion, String categoria, String nombreProveedor,
                    String fotografia1, String fotografia2, LocalDate fechaIngreso,
                    LocalDate fechaVencimiento, int precioUnitario, int cantidadBodega,
                    boolean perecedero) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.nombreProveedor = nombreProveedor;
        this.fotografia1 = fotografia1;
        this.fotografia2 = fotografia2;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
        this.precioUnitario = precioUnitario;
        this.cantidadBodega = cantidadBodega;
        this.perecedero = perecedero;

        // Verifica si el producto ya está vencido (si aplica)
        if (perecedero && fechaVencimiento != null) {
            this.vencido = fechaVencimiento.isBefore(LocalDate.now());
        } else {
            this.vencido = false;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNombre: " + nombre +
                "\nDescripción: " + descripcion +
                "\nCategoría: " + categoria +
                "\nProveedor: " + nombreProveedor +
                "\nFotografía 1: " + fotografia1 +
                "\nFotografía 2: " + fotografia2 +
                "\nFecha de ingreso: " + fechaIngreso +
                "\nPerecedero: " + (perecedero ? "Sí" : "No") +
                "\nFecha de vencimiento: " + (perecedero ? fechaVencimiento : "No aplica") +
                "\nEstado: " + (vencido ? "⚠️ VENCIDO" : "✔️ Vigente") +
                "\nPrecio: $" + precioUnitario +
                "\nCantidad en bodega: " + cantidadBodega;
    }
}

