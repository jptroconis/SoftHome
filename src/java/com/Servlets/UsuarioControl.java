/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Models.Personas;
import com.Models.Usuarios;
import com.Managers.PersonaImpl;
import com.Managers.UsuarioImpl;
import com.Managers.Utilidades;

/**
 *
 * @author Edward
 */
@WebServlet(name = "UsuarioControl", urlPatterns = {"/UsuarioControl"})
public class UsuarioControl extends HttpServlet {

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
            Personas p = new Personas(id);
            Usuarios u = new Usuarios(id);
            PersonaImpl pi = new PersonaImpl();
            UsuarioImpl ui = new UsuarioImpl();
            ui.eliminar(u);
            pi.eliminar(p);
            response.sendRedirect("admin.jsp");
            return;
        }
        if (request.getParameter("id") == null || request.getParameter("opcion") == null || request.getParameter("nombre") == null || request.getParameter("apellido") == null || request.getParameter("celular") == null || request.getParameter("direccion") == null || request.getParameter("tfijo") == null || request.getParameter("sexo") == null) {
            response.sendRedirect("admin.jsp");
        } else {
            String opcion = (String) request.getParameter("opcion");
            switch (opcion) {
                case "Guardar":
                    Personas p = null;
                    PersonaImpl pi = new PersonaImpl();
                    UsuarioImpl ui = new UsuarioImpl();
                    Object s = request.getSession().getAttribute("cliente");
                    Long id = null;
                    if (s == null) {
                        id = new Long(request.getParameter("id"));
                        p = (Personas) pi.buscar(Personas.class, id);
                    } else {
                        Usuarios u = (Usuarios) s;
                        p = (Personas) pi.buscar(Personas.class, u.getIdPersona());
                    }
                    if (p == null) {
                        System.out.println("Guardo");
                        response.sendRedirect("admin.jsp");
                    } else {
                        //AQUI ACTUALIZA
                        p.setNombre((String) request.getParameter("nombre"));
                        p.setApellido((String) request.getParameter("apellido"));
                        p.setCelular((String) request.getParameter("celular"));
                        p.setDireccion((String) request.getParameter("direccion"));
                        p.setFijo((String) request.getParameter("tfijo"));
                        p.setFechaNac((Utilidades.crear_fechaA(request.getParameter("fechainicio"))));
                        p.setSexo((String) request.getParameter("sexo"));
                        pi.actualizar(p);
                        System.out.println(id);
                        Usuarios u = (Usuarios) ui.verUusuario(p.getId());
                        u.setLastname(p.getNombre() + " " + p.getApellido());
                        ui.actualizar(u);
                        System.out.println("Actualizó");
                        response.sendRedirect("admin.jsp");
                    }
                    break;
                case "Borrar":
                    p = null;
                    pi = new PersonaImpl();
                    s = request.getSession().getAttribute("cliente");
                    if (s == null) {
                        id = new Long(request.getParameter("id"));
                        p = (Personas) pi.buscar(Personas.class, id);
                    } else {
                        Usuarios u = (Usuarios) s;
                        p = (Personas) pi.buscar(Personas.class, u.getIdPersona());
                    }
                    if (p == null) {
                        response.sendRedirect("admin.jsp");
                    } else {
                        //AQUI BORRA
                        pi.eliminar(p);
                        response.sendRedirect("admin.jsp");
                    }
                    break;
                default:
                    response.sendRedirect("usuario.jsp");
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
