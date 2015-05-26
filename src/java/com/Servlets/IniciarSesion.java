/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlets;

import com.Managers.UsuarioImpl;
import com.Models.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author Edward
 */
@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

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
            JSONObject obj = new JSONObject();
            Object ses = request.getSession().getAttribute("cliente");
            String pri = request.getParameter("guardian");
            if (ses == null && pri == null) {
                Usuarios u = new Usuarios();
                u.setNombre(request.getParameter("user"));
                u.setClave(request.getParameter("pass"));

                UsuarioImpl ui = new UsuarioImpl();
                Object o = ui.buscar(Usuarios.class, u);

                if (o != null) {
                    Usuarios client = (Usuarios) o;
                    client.setClave(null);
                    Map dc = new HashMap();
                    dc.put("id", client.getIdPersona());
                    dc.put("nombre", client.getLastname());
                    request.getSession().setAttribute("cliente", client);
                    obj.put("resp", dc);
                } else {
                    obj.put("resp", null);
                }
            } else {
                if (ses != null) {
                    Map dc = new HashMap();
                    dc.put("id", ((Usuarios) ses).getIdPersona());
                    dc.put("nombre", ((Usuarios) ses).getLastname());
                    obj.put("resp", dc);
                }else obj.put("resp", null);
            }
            out.print(obj);
            out.flush();

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
