/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.Service;

import com.aplicacion.bazar.DTO.ClienteMayorVentaDTO;
import com.aplicacion.bazar.DTO.DetalleVentaDTO;
import com.aplicacion.bazar.DTO.VentaDTO;
import com.aplicacion.bazar.Model.Cliente;
import com.aplicacion.bazar.Model.DetalleVenta;
import com.aplicacion.bazar.Model.Producto;
import com.aplicacion.bazar.Model.Venta;
import com.aplicacion.bazar.Repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiarapodio
 */
@Service
public class VentaService implements IVentaService{
    
    @Autowired
    private IVentaRepository ventaRepo; 
    
     @Autowired
    private IProductoService productoServ;
     
     @Autowired
    private IClienteService clienteServ;

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        Venta venta = ventaRepo.findById(codigo_venta).orElse(null);
        return venta;
    }

    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

@Override
public Venta editVenta(Long codigo_venta, LocalDate nuevaFecha_venta, Long idClienteNuevo, List<DetalleVentaDTO> listaDetalleNueva) {
    Venta venta = this.findVenta(codigo_venta);
    

    if (nuevaFecha_venta != null) {
    venta.setFecha_venta(nuevaFecha_venta);}
    if (idClienteNuevo != null) {
    Cliente clienteNuevo = clienteServ.findCliente(idClienteNuevo); 
    venta.setUnCliente(clienteNuevo);}
    
    if (listaDetalleNueva != null) {
     productoServ.devolverStockdeVenta(venta);
     
     venta.setListaDetalleVenta(this.crearDetalle(venta, listaDetalleNueva));
    
    }  
    
    this.saveVenta(venta);
    return venta;
}

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }
    
    @Override
     public List<DetalleVenta> crearDetalle (Venta venta, List<DetalleVentaDTO> detalleVenta) {
         
         List<DetalleVenta> detalle = new ArrayList<>();
         
         for (int i=0; i < detalleVenta.size(); i++) {          
             DetalleVentaDTO detVen = detalleVenta.get(i); 
             Producto producto = productoServ.findProducto(detVen.getIdProducto());
             
             detalle.get(i).setVenta(venta);
             productoServ.controlarStock(detVen);
             detalle.get(i).setProducto(producto);
             detalle.get(i).setCantidad(detVen.getCantidad());
             detalle.get(i).setPrecioUnitarioVenta(producto.getPrecioUnitarioActual());
             productoServ.actualizarStock(detVen);
         }
         
         
         return detalle;

     }
     
     @Override
     public void crearVenta (VentaDTO ventaDto) {
         
         Venta venta = new Venta();
         Cliente cliente = clienteServ.findCliente(ventaDto.getIdCliente());
         
         venta.setFecha_venta(LocalDate.now());
         venta.setListaDetalleVenta(this.crearDetalle(venta, ventaDto.getDetalleVenta()));
         venta.setUnCliente(cliente);
         venta.setTotal(this.calcularTotal(venta.getListaDetalleVenta()));
         
         cliente.getListaVentasCliente().add(venta);
         
         this.saveVenta(venta);
     }
    
    
    @Override
    public Double calcularTotal (List <DetalleVenta> listaDetalles) {
        Double total = 0.0;
        
        for (DetalleVenta pasoDetalle : listaDetalles) {
            total+= pasoDetalle.getSubtotal();
        }
        return total;
    }
    
    @Override
    public List<Producto> getProductosDeVenta(Long codigo_venta) {
        Venta venta = this.findVenta(codigo_venta);
        List<Producto> listaProductos = new ArrayList<>();
        
        for (DetalleVenta detalle : venta.getListaDetalleVenta()) {
            listaProductos.add(detalle.getProducto());
        }
        return listaProductos;
    }
    
    @Override
    public String getTotalMontoYVentas (LocalDate fecha_venta) {
        List<Venta> listaVentas = this.getVentas();
        
        Double montoTotal=0.0;
        Integer cantTotal=0;
        
        for (Venta pasoVenta : listaVentas) {
            if (pasoVenta.getFecha_venta()==fecha_venta) {
                montoTotal+=pasoVenta.getTotal();
                cantTotal+=1;
            }
        }
        return String.format("En el dia hubo %d ventas. El monto total fue de %f.", cantTotal, montoTotal);
    }
    
    @Override
    public ClienteMayorVentaDTO getMayorVenta() {
        ClienteMayorVentaDTO clienteMayVenta = new ClienteMayorVentaDTO();
        Venta venta = this.getVentas().get(0);
        for (Venta pasoVenta : this.getVentas()) {
            if (pasoVenta.getTotal()>venta.getTotal()) {
                venta=pasoVenta;
            }
        }
        Double cantidad = 0.0;
        for (DetalleVenta pasoDetalle : venta.getListaDetalleVenta()) {
            cantidad += pasoDetalle.getCantidad();
        }
        
        clienteMayVenta.setCodigo_venta(venta.getCodigo_venta());
        clienteMayVenta.setTotal(venta.getTotal());
        clienteMayVenta.setCantProductos(cantidad);
        clienteMayVenta.setNombreCliente(venta.getUnCliente().getNombre());
        clienteMayVenta.setNombreCliente(venta.getUnCliente().getApellido());
        
        return clienteMayVenta;
        
    }
}
