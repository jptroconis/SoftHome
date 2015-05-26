// define en que modulo esta Softhome  los servicios a utilizas $rootScope, $http
angular.module("softhome", []).run(function ($rootScope, $http) { 
    // declarar servicios a utilizar
    $rootScope.registro = "public/registro.html"; 
    $rootScope.sesion = "public/sesion.html";
    $rootScope.principal = "public/menu.html";
    $rootScope.carrusel = "public/carrusel.html";
    $rootScope.servicio;
    $rootScope.contenido;
    $rootScope.cliente;
    $rootScope.ver = true;
    $rootScope.res;
    $rootScope.estilo;
    $rootScope.ubicacion;
    isActivo();
    activarEstilo();
    
    $rootScope.buscarServicios = function() {  // busqueda de inmuebles 
        $rootScope.ver = false;
        $rootScope.contenido = "public/servicio/verInmueble.html";
        $http.get("VerInmuebles?direccion=" + $('#final').val()).success(
                function (data) {
                    $rootScope.res = data.res;
                    if(data.res === null){
                        alert("No se han encontrado inmuebles"); // alerta de no se a encontrado inmuebles
                        return;
                    }
                    alert("Usted esta buscando Inmuebles en "+data.var); // usted esta buscando inmuebles en tal barrio
                }
        ).error(function(){
            alert("El servicio no esta disponible por el momento"); //si ocurre un error
        });
    };
 
 // servicio para cerrar sesion  ir a pagina inicial cerrar contenido de cliente 
    $rootScope.cerrar = function () {
        $http.get("CerrarSesion").success(function (data) {
            alert(data);
            $rootScope.servicio = "public/invitado.html";
            $rootScope.cliente = null;
            $rootScope.contenido = null;
            $rootScope.ver = true;
        }).error(function () {
            alert("No se ha podido Cerrar la Session"); // si ocurre un error de que no se pueda cerrar la session
        });
    };
 
   // servicio activo de inicio de session 
    function isActivo() {
        $http.get('IniciarSesion?guardian=1').success(function (data) {
            if (data.resp !== null) {
                $rootScope.servicio = "public/servicio.html";  // si entra manda a servicios inicio sesion
                $rootScope.cliente = data.resp; // envia respuesta 
            }else{ // si no   envia a esta pagina html
                $rootScope.servicio = "public/invitado.html";
            }
        });
    }
    
    $rootScope.envioSeguro = function (){ // envios de datos seguros
        $rootScope.buscarServicios();
    };
    
    function activarEstilo(){ // activar estulo de los inmuebles publicados para que se vean parejos
        var x =( parseFloat(screen.width)/3)+"px";
        var y = (parseFloat(screen.height)/2)+"px";
        $rootScope.estilo = "width:"+x+";"+"height:"+y;
    }

});

            