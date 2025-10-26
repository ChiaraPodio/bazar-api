/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.Service;

import com.aplicacion.bazar.DTO.DetalleVentaDTO;
import com.aplicacion.bazar.Model.DetalleVenta;
import com.aplicacion.bazar.Model.Producto;
import com.aplicacion.bazar.Model.Venta;
import com.aplicacion.bazar.Repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiarapodio
 */
@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepo; 

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public Producto findProducto(Long id_producto) {
        Producto producto = productoRepo.findById(id_producto).orElse(null); 
        return producto;
    }

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = productoRepo.findAll();
        return listaProductos;
    }

    @Override
    public Producto editProducto(Long id_producto, String nuevoNombre, String nuevaMarca, Double nuevoPrecioUnitarioActual, Double nuevoStock) {
        Producto producto = this.findProducto(id_producto);
        
        if (nuevoNombre != null) {
        producto.setNombre(nuevoNombre);}
        if (nuevaMarca != null) {
        producto.setMarca(nuevaMarca);}
        if (nuevoPrecioUnitarioActual != null) {
        producto.setPrecioUnitarioActual(nuevoPrecioUnitarioActual);}
        if (nuevoStock != null) {
        producto.setStock(nuevoStock);}
        
        this.saveProducto(producto);
        
        return producto;
    }

    @Override
    public void deleteProducto(Long id_producto) {
        productoRepo.deleteById(id_producto);
    }
    
    
    @Override
    public void controlarStock (DetalleVentaDTO detalle) {
        
        Double stockProducto = this.findProducto(detalle.getIdProducto()).getStock();
        
        if (detalle.getCantidad()>stockProducto) {
            detalle.setCantidad(stockProducto);
        }
    }
    
    @Override
    public void actualizarStock (DetalleVentaDTO detalle) {
         
        Producto producto = this.findProducto(detalle.getIdProducto());
        
        producto.setStock(producto.getStock()-detalle.getCantidad());
             
             this.saveProducto(producto);
             }
    
    @Override
    public void devolverStockdeVenta (Venta venta) {
        
        List <DetalleVenta> listaDetallesAnterior = venta.getListaDetalleVenta();
        
        for (DetalleVenta pasoDetVen : listaDetallesAnterior) {
            Producto producto = pasoDetVen.getProducto();
            producto.setStock(producto.getStock()+pasoDetVen.getCantidad());
            this.saveProducto(producto);
        }
    }
    
    @Override
    public List <Producto> getProductosConStockMenorA5 () {
        
        List <Producto> listaProductos = this.getProductos();
        List <Producto> listaProductosBajoStock = new ArrayList<>();
        
        for (Producto pasoProducto : listaProductos) {
            if (pasoProducto.getStock()<5) {
                listaProductosBajoStock.add(pasoProducto);
            }
        }
        return listaProductosBajoStock;
        
    }
    
    @Override
    public void crearProducto (String nombre,String marca, Double stock, Double precioUnitarioActual) {
        Producto producto = new Producto();
        List <DetalleVenta> detallesEnLosQueEstaProducto = new ArrayList<>();
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setStock(stock);
        producto.setPrecioUnitarioActual(precioUnitarioActual);
        producto.setDetallesEnLosQueEstaProducto(detallesEnLosQueEstaProducto);
        
        this.saveProducto(producto);
    }
    
//    public void agregarDetalleAProductos (List<DetalleVenta> listaDetalle) {
//        for (DetalleVenta pasoDetalle : listaDetalle) {
//            pasoDetalle.getProducto().getDetallesEnLosQueEstaProducto().add(pasoDetalle);
//        }
//    }
        
}
