/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author chiarapodio
 */
@Entity
@Getter @Setter
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_DetalleVenta;
    
    @ManyToOne
    @JoinColumn(name = "codigoVenta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "codigoProducto")
    private Producto producto;

    private Double cantidad;
    private Double precioUnitarioVenta;
    private Double subtotal;

    public DetalleVenta() {
    }

    public DetalleVenta(Long id_DetalleVenta, Venta venta, Producto producto, Double cantidad, Double precioUnitarioVenta, Double subtotal) {
        this.id_DetalleVenta = id_DetalleVenta;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.subtotal = cantidad * precioUnitarioVenta;
    }
    
    
}
