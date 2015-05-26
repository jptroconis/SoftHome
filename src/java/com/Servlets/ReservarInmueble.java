/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlets;

import com.Managers.InmuebleImpl;
import com.Managers.ReservaImpl;
import com.Models.Inmuebles;
import com.Models.Personas;
import com.Models.Reserva;
import com.Models.Usuarios;
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
 * @author jptro_000
 */
@WebServlet(name = "ReservarInmueble", urlPatterns = {"/ReservarInmueble"})
public class ReservarInmueble extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Object o = request.getSession().getAttribute("cliente");
            if (o != null) {
                Usuarios u = (Usuarios) o;
                Long id = new Long(request.getParameter("id"));
                Reserva r = new Reserva(new Date().getDate());
                ReservaImpl ri = new ReservaImpl();
                Inmuebles i = null;
                InmuebleImpl ii = new InmuebleImpl();
                r.setInmuebles(new Inmuebles(id));
                r.setPersonas(new Personas(u.getIdPersona()));
                r.setEstado("ACTIVA");
                ri.guardar(r);
                //i = (Inmuebles) ii.buscar(InmuebleImpl.class, id);
                //i.setEstado("OCUPADO");
                //ii.guardar(i);
                out.print("Se ha Reservado este inmueble correctamente");
            }else{
                out.print("Su sesion ha sido cerrada");
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
