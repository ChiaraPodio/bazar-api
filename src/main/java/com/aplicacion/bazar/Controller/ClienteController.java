/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.Controller;

import com.aplicacion.bazar.Model.Cliente;
import com.aplicacion.bazar.Service.IClienteService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author chiarapodio
 */
@Controller
public class ClienteController {
    
    private IClienteService clienteServ;
    
    @PostMapping("/clientes/crear")
    public String saveCliente (@RequestParam String nuevoNombre,
                               @RequestParam String nuevoApellido,
                               @RequestParam String nuevoDni) {
        clienteServ.generarCliente(nuevoNombre, nuevoApellido, nuevoDni);
        
        return "Cliente creado correctamente";
    }
    
    @GetMapping("/cliente/{id_cliente}")
    public Cliente findCliente (@PathVariable Long id_cliente) {
        return clienteServ.findCliente(id_cliente);
    }
    
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteServ.getClientes();
    }
    
     @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editProducto(@PathVariable Long id_cliente,
                                    @RequestParam (required = false) String nuevoNombre,
                                    @RequestParam (required = false) String nuevoApellido,
                                    @RequestParam (required = false) String nuevoDni) {
        return clienteServ.editCliente(id_cliente, nuevoNombre, nuevoApellido, nuevoDni);
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {
        clienteServ.deleteCliente(id_cliente);
        return "Cliente eliminado exitosamente";
    }
    
}
