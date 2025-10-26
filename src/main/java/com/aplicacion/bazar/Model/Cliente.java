/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacion.bazar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author chiarapodio
 */
@Getter @Setter
@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;

    @OneToMany(mappedBy = "unCliente")
    private List<Venta> listaVentasCliente;
    
    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String apellido, String dni, List<Venta> listaVentasCliente) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.listaVentasCliente = listaVentasCliente;
    }
    
    
    
    
}
