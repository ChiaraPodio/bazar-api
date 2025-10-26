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
public class ClienteMayorVentaDTO {
    
    private Long codigo_venta;
    private Double total;
    private Double cantProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public ClienteMayorVentaDTO() {
    }

    public ClienteMayorVentaDTO(Long codigo_venta, Double total, Double cantProductos, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantProductos = cantProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
    
    
    
}
