/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aplicacion.bazar.Service;

import com.aplicacion.bazar.DTO.ClienteMayorVentaDTO;
import com.aplicacion.bazar.DTO.DetalleVentaDTO;
import com.aplicacion.bazar.DTO.VentaDTO;
import com.aplicacion.bazar.Model.DetalleVenta;
import com.aplicacion.bazar.Model.Producto;
import com.aplicacion.bazar.Model.Venta;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author chiarapodio
 */
@Service
public interface IVentaService {
    
    public void saveVenta (Venta venta);
    
     public Venta findVenta (Long codigo_venta);
     
     public List<Venta> getVentas();
     
     public Venta editVenta(Long codigo_venta, LocalDate nuevaFecha_venta, Long idClienteNuevo, List<DetalleVentaDTO> listaDetalleNueva);
     
     public void deleteVenta (Long codigo_venta);
     
     public List<DetalleVenta> crearDetalle (Venta venta, List<DetalleVentaDTO> detalleVenta);
    
    public void crearVenta (VentaDTO ventaDto);
    
     public Double calcularTotal (List <DetalleVenta> listaDetalles);
    
     public List<Producto> getProductosDeVenta(Long codigo_venta);
     
     public String getTotalMontoYVentas (LocalDate fecha_venta);
     
     public ClienteMayorVentaDTO getMayorVenta();
    
}
