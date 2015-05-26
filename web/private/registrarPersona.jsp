<%@page import="com.Managers.ConPersona"%>
<%@page import="com.Models.Persona"%>
<%
 try{
    Persona p = new Persona();
    p.setId(request.getParameter("ide"));
    p.setNombre( request.getParameter("nombre"));
    p.setApellido(request.getParameter("apellido"));
    p.setEmail(request.getParameter("email"));
    p.setCelular(request.getParameter("celular"));
    p.setSexo(request.getParameter("sexo"));

    ConPersona cp = new ConPersona();
    cp.insertar(p);
    out.print("sucess");
   
}catch(Exception e){
   out.print(e.toString());
}
%>