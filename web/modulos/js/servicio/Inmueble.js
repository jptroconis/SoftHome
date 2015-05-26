/* global angular */

angular.module("softhome").controller("inmueble", function ($scope, $http) {

    $scope.ajaxmap = false;
    $scope.complete = false;
    $scope.Alos;
    $scope.Habs;
    $scope.Bars;
    $scope.css = "borderInmu";
    $scope.tbar = "";
    objetos();
    reset();


    $("#barrio").keyup(function () {
        $scope.ajaxmap = true;
        $scope.Bars = buscarBarrios($scope.tbar);
    });

    $scope.terminar = function () {
        $scope.ajaxmap = false;
    };

    $scope.asignar = function (barrio) {
        $scope.inmueble.direc = barrio.formatted_address;
        $scope.complete = true;
        $scope.tbar = "";
        var latlng = barrio.geometry.location;
        mapa = new GMaps({
            div: '#mapa',
            lat: latlng.lat(),
            lng: latlng.lng(),
            zoom: 15
        });
        mapa.setCenter(latlng.lat(), latlng.lng());
        mapa.addMarker({
            lat: latlng.lat(),
            lng: latlng.lng()
        });
    };

    $scope.reAsignar = function () {
        $scope.tbar = $scope.inmueble.direc;
        $scope.complete = false;
    };

    function reset() {
        $scope.inmueble = {TAlo: "", THab: "", cap: "", estra: "", nHab: "", nCam: "", direc: "", des: ""};
    }

    function objetos() {
        $http.get('CargarObjetos?object=inmueble').success(function (data) {
            $scope.Alos = data.resp;
        });
        $http.get('CargarObjetos?object=habitacion').success(function (data) {
            $scope.Habs = data.resp;
        });

        if (isMovil()) {
            $scope.css = "cs";
        }
    }
    
    $("#reg").submit(function(e){
        e.preventDefault();
        var datos = new FormData($("#reg")[0]);
        $.ajax({
            url:"RegistrarInmueble",
            type: 'POST',
            data: datos,
            contentType: false,
            processData: false
        }).done(function(resp){
            alert(resp);
        });
    });
    
});
