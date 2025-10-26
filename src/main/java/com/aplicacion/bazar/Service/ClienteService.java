/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.Service;

import com.aplicacion.bazar.Model.Cliente;
import com.aplicacion.bazar.Model.Venta;
import com.aplicacion.bazar.Repository.IClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiarapodio
 */
@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private IClienteRepository clienteRepo; 

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        Cliente cliente = clienteRepo.findById(id_cliente).orElse(null);
        return cliente;
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        return listaClientes;
        }

    @Override
    public Cliente editCliente(Long id_cliente, String nuevoNombre, String nuevoApellido, String nuevoDni) {
        Cliente cliente = this.findCliente(id_cliente);
        
        if (nuevoNombre != null) {
        cliente.setNombre(nuevoNombre);}
        if (nuevoApellido != null) {
        cliente.setApellido(nuevoApellido);}
        if (nuevoDni != null) {
        cliente.setDni(nuevoDni);}
        
        this.saveCliente(cliente);
        
        return cliente;
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }
    
    @Override
    public void generarCliente (String nombre, String apellido, String dni) {
        Cliente cliente = new Cliente();
        List <Venta> listaVentasCliente = new ArrayList<>();
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setListaVentasCliente(listaVentasCliente);
        
        this.saveCliente(cliente);
        
    }
    
    
}
