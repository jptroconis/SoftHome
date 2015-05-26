package com.Servlets;

import com.Managers.InmuebleImpl;
import com.Models.Inmuebles;
import com.Models.Personas;
import com.Models.TiposHabitacion;
import com.Models.TiposInmuebles;
import com.Models.Usuarios;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Edward
 */
@WebServlet(name = "RegistrarInmueble", urlPatterns = {"/RegistrarInmueble"})
public class RegistrarInmueble extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
// req es la HttpServletRequest que recibimos del formulario.
// Los items obtenidos serán cada uno de los campos del formulario,
// tanto campos normales como ficheros subidos.
            Map<String, Object> md = new HashMap<>();
            List items = upload.parseRequest(request);
// Se recorren todos los items, que son de tipo FileItem
            for (Object item : items) {
                FileItem uploaded = (FileItem) item;
                // Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el fichero
                // subido donde nos interese
                if (!uploaded.isFormField()) {
                    uploaded.setFieldName(new Date().getTime()+"");
                    // No es campo de formulario, guardamos el fichero en algún sitio
                    File fichero = new File("C:/Users/Edward/Dropbox/Proyecto Git/SoftHome/web/imgs/main", uploaded.getFieldName()+".jpg");
                    uploaded.write(fichero);
                    md.put("file",uploaded.getFieldName());

                } else {
                    // es un campo de formulario, podemos obtener clave y valor
                    String key = uploaded.getFieldName();
                    String valor = uploaded.getString();
                    md.put(key, valor);
                    //out.print(key+'='+valor+"\n");
                }
            }
            Object ob = request.getSession().getAttribute("cliente");
            Inmuebles inm = new Inmuebles();
            inm.setDireccion((String)md.get("barrio"));
            inm.setNumeroHabitaciones(new Integer((String)md.get("nhabitacion")));
            inm.setNumeroBanos(new Integer((String)md.get("nbanos")));
            inm.setCapacidad(new Integer((String)md.get("ncapacidad")));
            inm.setEstrato(new Integer((String)md.get("nestrato")));
            inm.setTiposHabitacion(new TiposHabitacion(new Integer((String)md.get("habitacion"))));
            inm.setTiposInmuebles(new TiposInmuebles(new Integer((String)md.get("alojamiento"))));
            inm.setEstado("DISPONIBLE");
            inm.setImagen((String)md.get("file"));
            inm.setId(new Long((String)md.get("file")));
            
            inm.setPersonas(new Personas(((Usuarios)ob).getIdPersona()));
            InmuebleImpl ii = new InmuebleImpl();
            ii.guardar(inm);
            
            out.print("Su Inmueble a sido publicado Correctamente");
            
            
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegistrarInmueble.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegistrarInmueble.class.getName()).log(Level.SEVERE, null, ex);
        }
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
