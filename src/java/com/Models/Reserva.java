package com.Models;
// Generated 18/05/2015 05:32:17 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reserva generated by hbm2java
 */
@Entity
@Table(name="reserva"
    ,catalog="data_home"
)
public class Reserva  implements java.io.Serializable {


     private int id;
     private Inmuebles inmuebles;
     private Personas personas;
     private Date fechaInicio;
     private Date fechaFin;
     private double precio;
     private String estado;

    public Reserva() {
    }
     public Reserva(long id) {
        this.id = (int) id;
    }
    public Reserva(int id, Inmuebles inmuebles, Personas personas, Date fechaInicio, Date fechaFin, double precio, String estado) {
       this.id = id;
       this.inmuebles = inmuebles;
       this.personas = personas;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.precio = precio;
       this.estado = estado;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_inmuebles", nullable=false)
    public Inmuebles getInmuebles() {
        return this.inmuebles;
    }
    
    public void setInmuebles(Inmuebles inmuebles) {
        this.inmuebles = inmuebles;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_personas", nullable=false)
    public Personas getPersonas() {
        return this.personas;
    }
    
    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_inicio", nullable=false, length=10)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_fin", nullable=false, length=10)
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    @Column(name="precio", nullable=false, precision=22, scale=0)
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    @Column(name="estado", nullable=false, length=1)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


