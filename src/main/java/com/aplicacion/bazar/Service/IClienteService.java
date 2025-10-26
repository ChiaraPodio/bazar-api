/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aplicacion.bazar.Service;

import com.aplicacion.bazar.Model.Cliente;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiarapodio
 */
@Service
public interface IClienteService {
    
    public void saveCliente (Cliente cliente);
    
     public Cliente findCliente (Long id_cliente);
     
     public List<Cliente> getClientes();
     
     public Cliente editCliente (Long id_cliente, String nuevoNombre, String nuevoApellido, String nuevoDni);
     
     public void deleteCliente (Long id_cliente);
     
     public void generarCliente (String nombre, String apellido, String dni);
    
}
