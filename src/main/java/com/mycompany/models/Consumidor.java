/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */

@Entity
@Table(name="consumidor")
public class Consumidor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @OneToMany(mappedBy="consumidor")
    private ArrayList<Servicio> ListaServicios;
 

    public Consumidor() {
    }

    public Consumidor(int id, String nombre, String apellido, ArrayList<Servicio> ListaServicios) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ListaServicios = ListaServicios;
    }

    public ArrayList<Servicio> getListaServicios() {
        return ListaServicios;
    }

    public void setListaServicios(ArrayList<Servicio> ListaServicios) {
        this.ListaServicios = ListaServicios;
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

    public Consumidor(int id, String nombre, String apellido) {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
   
    
}
