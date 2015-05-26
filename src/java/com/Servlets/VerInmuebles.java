/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlets;

import com.Managers.InmuebleImpl;
import com.Models.Inmuebles;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author jptroconis
 */
@WebServlet(name = "VerInmuebles", urlPatterns = {"/VerInmuebles"})
public class VerInmuebles extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JSONObject json = new JSONObject();
            InmuebleImpl ii = new InmuebleImpl();
            String criterio = request.getParameter("direccion");
            List<Inmuebles> li = ii.BuscarInmuebles(criterio);
            if (li.isEmpty()) {
                json.put("res", null);
                out.print(json);
                out.flush();
                ii.terminar();
            } else {
                List<Map> lm = new LinkedList<>();
                for (Inmuebles i : li) {
                    Map temp = new HashMap();
                    temp.put("id", i.getId());
                    temp.put("imagen", i.getImagen());
                    temp.put("nombre", i.getPersonas().getNombre() + " " + i.getPersonas().getApellido());
                    temp.put("estrato", i.getEstrato());
                    temp.put("tinmueble", i.getTiposInmuebles().getNombre());
                    temp.put("capacidad", i.getCapacidad());
                    temp.put("estado", i.getEstado());
                    lm.add(temp);
                }
                json.put("res", lm);
                json.put("var", criterio);
                out.print(json);
                out.flush();
                ii.terminar();
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
