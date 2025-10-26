/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author chiarapodio
 */
@Getter @Setter
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double stock;
    private Double precioUnitarioActual;
    
    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detallesEnLosQueEstaProducto;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double stock, Double precioUnitarioActual, List<DetalleVenta> detallesEnLosQueEstaProducto) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.stock = stock;
        this.precioUnitarioActual = precioUnitarioActual;
        this.detallesEnLosQueEstaProducto = detallesEnLosQueEstaProducto;
    }
    
    
}
