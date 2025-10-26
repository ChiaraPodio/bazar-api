/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.DTO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author chiarapodio
 */
@Getter @Setter
public class VentaDTO {
    
    private Long idCliente;
    private List<DetalleVentaDTO> detalleVenta;

    public VentaDTO() {
    }

    public VentaDTO(Long idCliente, List<DetalleVentaDTO> detalleVenta) {
        this.idCliente = idCliente;
        this.detalleVenta = detalleVenta;
    }
    
    
    
}
