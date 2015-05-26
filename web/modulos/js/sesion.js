angular.module("softhome").controller("sesion", function($rootScope, $scope, $http){ // controlador de session
    
    // servicios a utilizar
    $scope.majax = false;
    $scope.cliente;
    reset();
    
    
    // servicio de inicio de admin 
    $scope.iniciar = function () {
        $('#formS').submit(function (e){
           e.preventDefault(); 
        });
        $scope.majax = true;
        if($scope.cliente.user === "admin" && $scope.cliente.pass==="admin" ){
            location.href = "admin.jsp"; // si la contraseña es conrrecta enviar a esta pagina
            return;
        }
        // inicio de sesion  usarios 
        $http.get('IniciarSesion?'+datos($scope.cliente)).success(function (data){
            if(data.resp === null)  // si en la base de datos no hay nada
                alert("Usuario o Contraseña Incorrecta");  //  es por que digito los  datos mal
            else{  // si no  entra y existe una session por un tiempo
                $('#sesion').modal('hide');
                reset();
                $rootScope.servicio = "public/servicio.html"; // inicia session usuario
                $rootScope.cliente = data.resp;
            }
            $scope.majax = false;
        });
    };
    
    function reset(){ // cierre  de modal  usuario y pass
        $scope.cliente = {user:"",pass:""};
    };
    
});


