/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name="servicio")
public class Servicio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String Nombre;
    @Basic
    private Date fecha;
    @Basic
    private boolean TrabajoFinalizado;
    @ManyToOne
    private Consumidor consumidor;
    
    @OneToMany(mappedBy="servicio")
    private ArrayList<Tareas> ListaTareas;

    public Servicio() {
    }

    public Servicio(int id, String Nombre, Date fecha, boolean TrabajoFinalizado, Consumidor consumidor, ArrayList<Tareas> ListaTareas) {
        this.id = id;
        this.Nombre = Nombre;
        this.fecha = fecha;
        this.TrabajoFinalizado = TrabajoFinalizado;
        this.consumidor = consumidor;
        this.ListaTareas = ListaTareas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isTrabajoFinalizado() {
        return TrabajoFinalizado;
    }

    public void setTrabajoFinalizado(boolean TrabajoFinalizado) {
        this.TrabajoFinalizado = TrabajoFinalizado;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public ArrayList<Tareas> getListaTareas() {
        return ListaTareas;
    }

    public void setListaTareas(ArrayList<Tareas> ListaTareas) {
        this.ListaTareas = ListaTareas;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
