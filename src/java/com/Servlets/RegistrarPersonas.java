/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlets;

import com.Managers.PersonaImpl;
import com.Managers.UsuarioImpl;
import com.Models.Personas;
import com.Models.Roles;
import com.Models.Usuarios;
import com.Managers.Utilidades;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edward
 */
@WebServlet(name = "RegistrarPersonas", urlPatterns = {"/RegistrarPersonas"})
public class RegistrarPersonas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            PersonaImpl pi = new PersonaImpl();
            UsuarioImpl ui = new UsuarioImpl();

            boolean uniq = pi.isUnique(Personas.class, new Long(request.getParameter("ide")));

            if (uniq) {
                Personas p = new Personas();
                p.setId(new Long(request.getParameter("ide")));
                p.setNombre(request.getParameter("nombre"));
                p.setApellido(request.getParameter("apellido"));
                p.setDireccion(request.getParameter("direccion"));
                p.setFijo(request.getParameter("fijo"));
                p.setCelular(request.getParameter("celular"));
                p.setSexo(request.getParameter("sexo"));
                p.setFechaNac(Utilidades.crear_fecha(request.getParameter("fecha")));

                uniq = ui.isUnique(Usuarios.class, request.getParameter("user"));
                if (uniq) {
                    pi.guardar(p);

                    Usuarios u = new Usuarios();
                    u.setNombre(request.getParameter("user"));
                    u.setClave(request.getParameter("pass"));
                    u.setLastname(p.getNombre()+ " " + p.getApellido());
                    u.setPersonas(p);
                    u.setEstado("ACTIVO");
                    u.setRoles(new Roles(1));
                    
                    ui.guardar(u);
                    out.print("Se Han Registrado Los Datos Exitosamente");
                }else{
                    out.print("Este nombre de Usuario Ya Existe");
                }

            } else {
                out.print("Este Usuario Ya Existe");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
