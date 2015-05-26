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
 * Suscripciones generated by hbm2java
 */
@Entity
@Table(name="suscripciones"
    ,catalog="data_home"
)
public class Suscripciones  implements java.io.Serializable {


     private int idSuscripcion;
     private Inmuebles inmuebles;
     private Personas personas;
     private Date fechaInicio;
     private Date fechaFin;
     private Date tiempo;
     private double valor;
     private String tipoPago;
     private String detalles;
     private String estado;

    public Suscripciones() {
    }

	
    public Suscripciones(int idSuscripcion, Inmuebles inmuebles, Personas personas, Date fechaInicio, Date fechaFin, Date tiempo, double valor, String tipoPago, String estado) {
        this.idSuscripcion = idSuscripcion;
        this.inmuebles = inmuebles;
        this.personas = personas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tiempo = tiempo;
        this.valor = valor;
        this.tipoPago = tipoPago;
        this.estado = estado;
    }
    public Suscripciones(int idSuscripcion, Inmuebles inmuebles, Personas personas, Date fechaInicio, Date fechaFin, Date tiempo, double valor, String tipoPago, String detalles, String estado) {
       this.idSuscripcion = idSuscripcion;
       this.inmuebles = inmuebles;
       this.personas = personas;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.tiempo = tiempo;
       this.valor = valor;
       this.tipoPago = tipoPago;
       this.detalles = detalles;
       this.estado = estado;
    }
   
     @Id 

    
    @Column(name="idSuscripcion", unique=true, nullable=false)
    public int getIdSuscripcion() {
        return this.idSuscripcion;
    }
    
    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_inmueble", nullable=false)
    public Inmuebles getInmuebles() {
        return this.inmuebles;
    }
    
    public void setInmuebles(Inmuebles inmuebles) {
        this.inmuebles = inmuebles;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_arrendador", nullable=false)
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

    @Temporal(TemporalType.DATE)
    @Column(name="tiempo", nullable=false, length=10)
    public Date getTiempo() {
        return this.tiempo;
    }
    
    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    
    @Column(name="valor", nullable=false, precision=22, scale=0)
    public double getValor() {
        return this.valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }

    
    @Column(name="tipo_pago", nullable=false, length=1)
    public String getTipoPago() {
        return this.tipoPago;
    }
    
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    
    @Column(name="detalles", length=50)
    public String getDetalles() {
        return this.detalles;
    }
    
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    
    @Column(name="estado", nullable=false, length=1)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


