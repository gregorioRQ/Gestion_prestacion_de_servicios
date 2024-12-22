/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "prestador")
public class Prestador implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private long NumDocumento;
    @Basic
    private String TipoDocumento;
    @Basic
    private long Cuit_Cuil;
    @Basic
    private String Nombre;
    @Basic
    private String Apellido;
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic
    private long Telefono;
    @Basic
    private String Email;
    @Basic
    private int Calificacion;
    @Basic
    private int DiasDisponibles;
    @Basic
    private int RadioCobertura;
    @Basic
    private String DiasDisponible;
    @Basic
    private String Experiencia;
    @OneToOne
    private Servicio servicio;

    public Prestador() {
    }

    public Prestador(int id, long NumDocumento, String TipoDocumento, long Cuit_Cuil, String Nombre, String Apellido, Date fechaNac, long Telefono, String Email, int Calificacion, int DiasDisponibles, int RadioCobertura, String DiasDisponible, String Experiencia, Servicio servicio) {
        this.id = id;
        this.NumDocumento = NumDocumento;
        this.TipoDocumento = TipoDocumento;
        this.Cuit_Cuil = Cuit_Cuil;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.fechaNac = fechaNac;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Calificacion = Calificacion;
        this.DiasDisponibles = DiasDisponibles;
        this.RadioCobertura = RadioCobertura;
        this.DiasDisponible = DiasDisponible;
        this.Experiencia = Experiencia;
        this.servicio = servicio;
    }

    public long getNumDocumento() {
        return NumDocumento;
    }

    public void setNumDocumento(long NumDocumento) {
        this.NumDocumento = NumDocumento;
    }

    public long getCuit_Cuil() {
        return Cuit_Cuil;
    }

    public void setCuit_Cuil(long Cuit_Cuil) {
        this.Cuit_Cuil = Cuit_Cuil;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
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


    public void setNumDocumento(int NumDocumento) {
        this.NumDocumento = NumDocumento;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

  
    public void setCuit_Cuil(int Cuit_Cuil) {
        this.Cuit_Cuil = Cuit_Cuil;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int Calificacion) {
        this.Calificacion = Calificacion;
    }

    public int getDiasDisponibles() {
        return DiasDisponibles;
    }

    public void setDiasDisponibles(int DiasDisponibles) {
        this.DiasDisponibles = DiasDisponibles;
    }

    public int getRadioCobertura() {
        return RadioCobertura;
    }

    public void setRadioCobertura(int RadioCobertura) {
        this.RadioCobertura = RadioCobertura;
    }

    public String getDiasDisponible() {
        return DiasDisponible;
    }

    public void setDiasDisponible(String DiasDisponible) {
        this.DiasDisponible = DiasDisponible;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String Experiencia) {
        this.Experiencia = Experiencia;
    }

}
