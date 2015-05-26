package com.Models;
// Generated 18/05/2015 05:32:17 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TiposInmuebles generated by hbm2java
 */
@Entity
@Table(name="tipos_inmuebles"
    ,catalog="data_home"
    , uniqueConstraints = @UniqueConstraint(columnNames="nombre") 
)
public class TiposInmuebles  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String caracteristicas;
     private String icono;
     private Set inmuebleses = new HashSet(0);

    public TiposInmuebles() {
    }

    public TiposInmuebles(Integer id) {
        this.id = id;
    }
    
    
    

    public TiposInmuebles(String nombre, String caracteristicas, String icono, Set inmuebleses) {
       this.nombre = nombre;
       this.caracteristicas = caracteristicas;
       this.icono = icono;
       this.inmuebleses = inmuebleses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nombre", unique=true, length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="caracteristicas", length=250)
    public String getCaracteristicas() {
        return this.caracteristicas;
    }
    
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    
    @Column(name="icono", length=250)
    public String getIcono() {
        return this.icono;
    }
    
    public void setIcono(String icono) {
        this.icono = icono;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tiposInmuebles")
    public Set getInmuebleses() {
        return this.inmuebleses;
    }
    
    public void setInmuebleses(Set inmuebleses) {
        this.inmuebleses = inmuebleses;
    }




}


