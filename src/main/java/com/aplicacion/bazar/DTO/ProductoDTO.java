/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author chiarapodio
 */
@Getter @Setter
public class ProductoDTO {
    private String nombre;
    private String marca;
    private Double stock;
    private Double precioUnitarioActual;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, String marca, Double stock, Double precioUnitarioActual) {
        this.nombre = nombre;
        this.marca = marca;
        this.stock = stock;
        this.precioUnitarioActual = precioUnitarioActual;
    }
    
    
}
