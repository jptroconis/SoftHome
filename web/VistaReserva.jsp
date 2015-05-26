<%-- 
    Document   : VistaReserva
    Created on : 25/05/2015, 01:46:56 PM
    Author     : Edward
--%>

<%@page import="com.Managers.ReservaImpl"%>
<%@page import="com.Models.Reserva"%>
<%@page import="com.Models.Usuarios"%>
<%@page import="com.Models.Personas"%>
<%@page import="com.Managers.PersonaImpl"%>
?<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>.:RESERVA SOFT HOME.:</title>

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
                display: block;
                max-width: 100%;
            }
            .auto-style3 {
                padding-left: 0;
                margin-bottom: 20px;
                margin-right: 0px;
            }
            .auto-style4 {
                min-height: 20px;
                padding: 19px;
                margin-bottom: 20px;
                background-color: #f5f5f5;
                border: 1px solid #e3e3e3;
                border-radius: 4px;
                -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
                box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
                margin-top: 0px;
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
                        <li>
                            <a href="#"></a>
                        </li>
                    </ul>
                </div>

            </div>

        </nav>
        <div class="container">

            <div class="row">

                <div class="col-md-3" style="left: 0px; top: 0px; height: 335px">
                    <p class="lead">Formulario de reservas</p>
                    <div class="auto-style3" style="width: 258px; height: 142px">

                        <span lang="es-co">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </span>
                        <img class="auto-style1" src="reservarInmueble.jpg" alt="" height="253" width="222"></div>
                </div>

                <div class="col-md-9" style="left: 0px; top: 126px; height: 389px">
                     <%
                        Reserva r = null;
                        ReservaImpl ri = new ReservaImpl();
                        Object s = request.getSession().getAttribute("cliente");
                        if (s == null) {
                            Long id = new Long(request.getParameter("id"));
                            r = (Reserva) ri.buscar(Reserva.class, id);
                        
                        
                    %>
                    <form method="POST">
                        <div class="auto-style4">
                            <input name="id" type="hidden">
                            <input name="fechaInicio" class="form-control" type="date" placeholder="Fecha Inicio"  ><br></br>
                            <input name="fechaFin" class="form-control" type="date" placeholder="Fecha fin" <br></br>
                            <input name="precio" class="form-control"  type="text" placeholder="Precio" <br></br>
                            <input name="estado" class="form-control" type="text" placeholder="Estado" <br></br>
                            <input name="inmuebles" class="form-control" type="text" placeholder="Inmueble" <br>
                            <input name="personas" class="form-control" type="text" placeholder="Persona" <br></br>
                            
                            <%}%>
                            
                            &nbsp;



                        </div>
                        <button type="submit" class="btn btn-primary btn-sm">Enviar Datos</button>  
                        
                    </form>

                      <button type="button" class="btn btn-primary btn-sm" onclick="location.href = 'index.html'" >Salir</button>
 


                </div>

            </div>

        </div>
        <!-- /.container -->

        <div class="container">

            <hr>

            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p><span lang="es-co">Home Soft Service</span>&nbsp; 201<span lang="es-co">5</span></p>
                    </div>
                </div>
            </footer>

        </div>



        <script src="js/jquery.js"></script>


        <script src="js/bootstrap.min.js"></script>

    </body>

</html>

