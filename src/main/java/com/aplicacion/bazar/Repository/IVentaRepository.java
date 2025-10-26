/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aplicacion.bazar.Repository;

import com.aplicacion.bazar.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chiarapodio
 */
@Repository
public interface IVentaRepository extends JpaRepository <Venta, Long> {
    
}
