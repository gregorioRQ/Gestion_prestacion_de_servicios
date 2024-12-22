/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controladores;

import com.mycompany.models.Consumidor;


/**
 *
 * @author PC
 */
public class Controladores {
    PersistenceController control = new PersistenceController();

    public void crearConsumidor(Consumidor consumidor){
        control.crearConsumidor(consumidor);
    }
    
}