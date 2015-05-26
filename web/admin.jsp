<%@page import="com.Models.Inmuebles"%>
<%@page import="com.Managers.InmuebleImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.Models.Usuarios"%>
<%@page import="com.Managers.UsuarioImpl"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>.:ADMINISTRADOR SOFT HOME.:</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/shop-item.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <style type="text/css">
            .auto-style1 {
                font-size: xx-large;
                font-weight: 300;
                line-height: 1.4;
                color: #FFFFFF;
                font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS", sans-serif;
                margin-bottom: 20px;
            }
        </style>

    </head>

    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"></a>
                    <p class="auto-style1"><strong>Administrador</strong></p>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#"></a>
                        </li>
                        <li>
                            <a href="#"></a>
                        </li>
                    </ul>
                </div>

            </div>

        </nav>
        <div class="container">

            <div class="row">
                <br></br>

                <div class="col-md-9" style="left: 5px; top: 19px; width: 824px">

                    <div class="well" style="width: 890px">
                        <h1 style="width: 159px">Usuarios</h1>
                        
                        <table class="table table-bordered">
                            <tr>
                                <td colspan="4"> <b>Nombre</b></td>
                                <td> <b>Apellido</b> </td>
                                <td><b> Direccion</b></td>
                                <td><b> Fijo</b></td>
                                <td> <b>Celular</b></td>
                                <td> <b>Sexo</b></td>
                                <td> <b>Fecha </b></td>
                                
                               
                                
                            </tr>
                            <%

                                UsuarioImpl ui = new UsuarioImpl();
                                for (Usuarios u : (List<Usuarios>) ui.verTodos(Usuarios.class)) {
                            %>
                            <form action="usuario.jsp" method="post">
                                <tr>
                                   
                                  <td colspan="4"> <%=u.getPersonas().getNombre()%></td>
                                    <td><%=u.getPersonas().getApellido()%></td>
                                    <td><%=u.getPersonas().getDireccion()%></td>
                                    <td><%=u.getPersonas().getFijo()%></td>
                                    <td><%=u.getPersonas().getCelular()%></td>
                                    <td><%=u.getPersonas().getSexo()%></td>
                                    <td><%=u.getPersonas().getFechaNac()%></td>
                                    <td><button type="submit" class="btn btn-primary btn-sm">Modificar</button></td>
                                   
                                    <td><button type="submit" formaction="UsuarioControl?opcion=Borrar&id=<%=u.getIdPersona()%>" class="btn btn-primary btn-sm">Eliminar</button> </td>
                                </tr>
                                <input type="text" name="id" value="<%=u.getIdPersona()%>" hidden>
            
                            </form>
                            <%}
                             ui.terminar();
                            %>

                        </table>




                      
                      
                    </div>

                </div>

                <div class="col-md-9" style="left: 2px; top: 29px; width: 812px">

                    <div class="well" style="width: 890px">
                        <h1>Inmuebles</h1>
                        

                        <table class="table table-bordered">
                            <tr>

                                <td colspan="4"> <b>Barrio</b></td>
                                <td><b> Capacidad</b></td>
                                <td><b> Numero de habitaiones</b></td>
                                <td> <b>Numero de banos</b></td>
                                <td> <b>Estrato</b></td>
                                <td> <b>Propietario</b></td>
                                <td> <b>Estado</b></td>
                                
                            </tr>
                             <%

                                InmuebleImpl ii = new InmuebleImpl();
                                for (Inmuebles i : (List<Inmuebles>) ii.verTodos(Inmuebles.class)) {
                            %>

                            <tr>
                                <td colspan="4"> <%=i.getDireccion() %></td>
                                <td><%=i.getCapacidad() %> </td>
                                <td> <%=i.getNumeroHabitaciones() %></td>
                                <td><%=i.getNumeroBanos() %> </td>
                                <td><%=i.getEstrato() %></td>
                                <td> </td>
                                <td><%=i.getEstado() %> </td>
                              
                                <td><button type="button" class="btn btn-primary btn-sm">Modificar</button></td>
                                <td> <button type="button" class="btn btn-primary btn-sm">Eliminar</button></td>
                            </tr>
                                          <%}%>
                        </table>

                       
                    </div>

                </div>

                <div class="col-md-9" style="left: 3px; top: 57px; width: 812px">

                    <div class="well" style="width: 785px">
                        <h1>Reservas</h1>
                        

                        <table class="table table-bordered">
                            <tr>
                                <td colspan="4"><b> Fecha inicio</b></td>
                                <td><b> Fecha fin</b></td>
                                <td> <b>Precio</b></td>
                                <td> <b>Estado</b></td>
                                <td> <b>Solicitante</b></td>
                                <td><b> Inmueble</b></td>
                            </tr>
                            <tr>
                                <td colspan="4"> </td>
                                <td> </td>
                                <td> </td>
                                <td> </td>
                                <td> </td>
                                <td> </td>
                                <td><button type="button" class="btn btn-primary btn-sm">Modificar</button></td>
                                <td><button type="button" class="btn btn-primary btn-sm">Eliminar</button></t>
                            </tr>

                        </table>


                        
                        
                        
                       
                    </div>

                </div>


            </div>

        </div>
        <!-- /.container -->
        <br></br>

        <button type="button" class="btn btn-primary btn-sm" onclick="location.href = 'index.html'" >Cerrar sesion</button>



        <script src="js/jquery.js"></script>


        <script src="js/bootstrap.min.js"></script>

    </body>

</html>

