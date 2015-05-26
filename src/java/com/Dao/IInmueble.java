/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import java.util.List;


public interface IInmueble<Inmuebles> extends ICrud<Inmuebles>{
    
    public List<Inmuebles> BuscarInmuebles(String par);
}
