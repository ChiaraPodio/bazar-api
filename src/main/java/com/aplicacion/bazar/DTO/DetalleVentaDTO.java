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
public class DetalleVentaDTO {
    
    private Long idProducto;
    private Double cantidad;

    public DetalleVentaDTO() {
    }

    public DetalleVentaDTO(Long idProducto, Double cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }
    
    
    
    
}
