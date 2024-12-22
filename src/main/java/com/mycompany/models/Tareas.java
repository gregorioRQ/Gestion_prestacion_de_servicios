/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name="trabajo")
public class Tareas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    @Basic
    private String tarea1;
    @Basic
    private String tarea2;
    @Basic
    private String tarea3;
    @Basic
    private String tarea4;
    @Basic
    private double precio;
    
    @ManyToOne
    private Servicio servicio;

    public Tareas() {
    }

    public Tareas(int id, String nombre, String tarea1, String tarea2, String tarea3, String tarea4, double precio, Servicio servicio) {
        this.id = id;
        this.nombre = nombre;
        this.tarea1 = tarea1;
        this.tarea2 = tarea2;
        this.tarea3 = tarea3;
        this.tarea4 = tarea4;
        this.precio = precio;
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTarea1() {
        return tarea1;
    }

    public void setTarea1(String tarea1) {
        this.tarea1 = tarea1;
    }

    public String getTarea2() {
        return tarea2;
    }

    public void setTarea2(String tarea2) {
        this.tarea2 = tarea2;
    }

    public String getTarea3() {
        return tarea3;
    }

    public void setTarea3(String tarea3) {
        this.tarea3 = tarea3;
    }

    public String getTarea4() {
        return tarea4;
    }

    public void setTarea4(String tarea4) {
        this.tarea4 = tarea4;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }    
}
