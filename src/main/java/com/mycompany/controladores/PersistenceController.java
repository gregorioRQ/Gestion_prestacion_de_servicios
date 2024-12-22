/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controladores;



import com.mycompany.models.Consumidor;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author PC
 */
public class PersistenceController {
    ConsumidorJpaController consumidorJPA = new ConsumidorJpaController();
   
   
    
    public void crearConsumidor(Consumidor cons){
        consumidorJPA.create(cons);
    }
  
}