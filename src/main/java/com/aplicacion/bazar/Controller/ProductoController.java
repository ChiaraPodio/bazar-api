/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.Controller;

import com.aplicacion.bazar.DTO.ProductoDTO;
import com.aplicacion.bazar.Model.Producto;
import com.aplicacion.bazar.Service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chiarapodio
 */
@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoServ;
    
    @PostMapping("/producto/crear")
    public String saveProducto (@RequestBody ProductoDTO productoDTO) {
        productoServ.crearProducto(productoDTO); 
        
        return "Producto creado correctamente";
    }
     
    @GetMapping("/producto/{codigo_producto}")
    public Producto findProducto (@PathVariable Long codigo_producto) {
        return productoServ.findProducto(codigo_producto);
    }
    
    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoServ.getProductos();
    }
    
    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductosConStockMenorA5() {
        return productoServ.getProductosConStockMenorA5();
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,
                                    @RequestParam (required = false) String nuevoNombre,
                                    @RequestParam (required = false) String nuevaMarca,
                                    @RequestParam (required = false) Double nuevoPrecioUnitarioActual,
                                    @RequestParam (required = false) Double nuevoStock) {
        return productoServ.editProducto(codigo_producto, nuevoNombre, nuevaMarca, nuevoPrecioUnitarioActual, nuevoStock);
        
    }
    
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto) {
        productoServ.deleteProducto(codigo_producto);
        return "Producto eliminado exitosamente";
    }
    
    
}
