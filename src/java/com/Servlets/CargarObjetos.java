/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servlets;

import com.Managers.ObjectImpl;
import com.Models.TiposHabitacion;
import com.Models.TiposInmuebles;
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
 * @author Edward
 */
@WebServlet(name = "CargarObjetos", urlPatterns = {"/CargarObjetos"})
public class CargarObjetos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String tipo = request.getParameter("object");
            JSONObject obj = new JSONObject();
            if (tipo.equals("habitacion")) {
                ObjectImpl<TiposHabitacion> oi = new ObjectImpl<>();
                List<TiposHabitacion> ths = oi.verTodos(TiposHabitacion.class);
                List<Map> mh = new LinkedList<>();
                for (TiposHabitacion th : ths) {
                    Map temp = new HashMap();
                    temp.put("id", th.getId());
                    temp.put("nombre", th.getNombre());
                    temp.put("des", th.getDescripcion());
                    temp.put("icon", th.getIcono());
                    mh.add(temp);
                }
                obj.put("resp", mh);
            }else if(tipo.equals("inmueble")){
                ObjectImpl<TiposInmuebles> oi = new ObjectImpl<>();
                List<TiposInmuebles> ths = oi.verTodos(TiposInmuebles.class);
                List<Map> mh = new LinkedList<>();
                for (TiposInmuebles th : ths) {
                    Map temp = new HashMap();
                    temp.put("id", th.getId());
                    temp.put("nombre", th.getNombre());
                    temp.put("des", th.getCaracteristicas());
                    temp.put("icon", th.getIcono());
                    mh.add(temp);
                }
                obj.put("resp", mh);
            }else{
                obj.put("resp", null);
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
