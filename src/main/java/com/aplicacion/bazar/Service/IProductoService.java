/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aplicacion.bazar.Service;

import com.aplicacion.bazar.DTO.DetalleVentaDTO;
import com.aplicacion.bazar.Model.Producto;
import com.aplicacion.bazar.Model.Venta;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiarapodio
 */
@Service
public interface IProductoService {
    
    public void saveProducto (Producto producto);
    
     public Producto findProducto (Long id_producto);
     
     public List<Producto> getProductos();
     
     public Producto editProducto (Long id_producto, String nuevoNombre, String nuevaMarca, Double nuevoPrecioUnitario, Double NuevaCantidad_disponible);
     
     public void deleteProducto (Long id_producto);
     
     public void controlarStock (DetalleVentaDTO detalle);
     
     public void actualizarStock (DetalleVentaDTO detalle);
     
     public void devolverStockdeVenta (Venta venta);
     
     public List <Producto> getProductosConStockMenorA5();
     
     public void crearProducto (String nombre,String marca, Double stock, Double precioUnitarioActual);
     
    
    
    
    
    
    
    
}
