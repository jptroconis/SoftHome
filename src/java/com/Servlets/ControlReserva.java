/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlets;

import com.Managers.ReservaImpl;
import com.Managers.Utilidades;
import com.Models.Inmuebles;
import com.Models.Personas;
import com.Models.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edward
 */
@WebServlet(name = "ControlReserva", urlPatterns = {"/ControlReserva"})
public class ControlReserva extends HttpServlet {

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
        if (request.getParameter("opcion").equals("Borrar")) {
            Long id = new Long(request.getParameter("id"));
            Reserva r = new Reserva(id);

            ReservaImpl ri = new ReservaImpl();

            ri.eliminar(r);

            response.sendRedirect("admin.jsp");
            return;
        }
        if (request.getParameter("id") == null || request.getParameter("opcion") == null || request.getParameter("nombre") == null || request.getParameter("apellido") == null || request.getParameter("celular") == null || request.getParameter("direccion") == null || request.getParameter("tfijo") == null || request.getParameter("sexo") == null) {
            response.sendRedirect("admin.jsp");
        } else {
            String opcion = (String) request.getParameter("opcion");
            switch (opcion) {
                case "Guardar":
                    Reserva r = null;
                    ReservaImpl ri = new ReservaImpl();
                    Object s = request.getSession().getAttribute("cliente");
                    Long id = null;
                    if (s == null) {
                        id = new Long(request.getParameter("id"));
                        r = (Reserva) ri.buscar(Reserva.class, id);
                    } else {

                        r = (Reserva) ri.buscar(Reserva.class, r.getId());
                    }
                    if (r == null) {
                        System.out.println("reserva guardada");
                        response.sendRedirect("admin.jsp");
                    } else {
                        //AQUI ACTUALIZA
                        r.setFechaInicio((Utilidades.crear_fechaA(request.getParameter("fechaInicio"))));
                        r.setFechaFin((Utilidades.crear_fechaA(request.getParameter("fechaFin"))));
                       //castear// r.setPrecio((double) request.getParameter("precio"));
                        r.setEstado((String) request.getParameter("estado"));
                      //castear // r.setInmuebles((Inmuebles) request.getParameter("inmuebles"));
                       //castear// r.setPersonas((Personas) request.getParameter("personas"));
                        ri.actualizar(r);
                        System.out.println(id);
                        System.out.println("Actualizó");
                        response.sendRedirect("admin.jsp");

                    }
                    break;
                case "Borrar":
                    r = null;
                    ri = new ReservaImpl();
                    s = request.getSession().getAttribute("cliente");
                    if (s == null) {
                        id = new Long(request.getParameter("id"));
                        r = (Reserva) ri.buscar(Reserva.class, id);
                    }
                    if (r == null) {
                        response.sendRedirect("admin.jsp");
                    } else {
                        //AQUI BORRA
                        ri.eliminar(r);
                        response.sendRedirect("admin.jsp");
                    }
                    break;
                default:
                    response.sendRedirect("admin.jsp");
                    break;
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
