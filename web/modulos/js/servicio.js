angular.module("softhome").controller('servicio', function ($rootScope, $scope) { // controlador de servicios
 // servicios a  utilizar
    $scope.ajaxmap = false;
    $scope.complete = false;
    $scope.Bars;
    $scope.css = "borderInmu";
    $scope.tbar = "";
    $scope.direc = "";

  // busqueda de barrios por mapa genera una barra para buscar los barios
    $("#busqueda").keyup(function () {
        $scope.ajaxmap = true;
        $scope.Bars = buscarBarrios($scope.tbar);
    });
    
    //  terminar la busqueda de barrios por mapa
    $scope.terminar = function () {
        $scope.ajaxmap = false;
    };
 
 // reasignar en la tabla la direccion
    $scope.reAsignar = function () {
        $scope.tbar = $scope.direc;
        $scope.complete = false;
    };
    // Busqueda de los barrios por formato 
    $scope.asignar = function (barrio) {
        $scope.direc = barrio.formatted_address;
        $scope.complete = true;
        $scope.tbar = "";
        $rootScope.buscarServicios();
    };

     // publicar inmueble servicios para vista de publicar
    $scope.publicar = function () {
        $rootScope.ver = false;
        $rootScope.contenido = "public/servicio/publicarInmueble.html";
    };
});


