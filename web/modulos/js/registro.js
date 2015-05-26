angular.module("softhome").controller("persona", function ($scope, $http) { // controlador de persona
    // declaras los servicios a utilizar
    $scope.majax = false;
    $scope.persona;
    reset();
    $scope.cancelar = reset;
    
    // Cancelar ---> cierra el modal y los datos  de la persona
    function reset(){
        $scope.persona = {ide:"", nombre:"", apellido:"", direccion:"", fijo:"", 
            celular:"", sexo:"", fecha:"", user:"", pass:""
        };
    };
    
    // guarda los datos de  el registro de persona 
    $scope.guardar = function(){
        $scope.persona.fecha = $('#date').val();
        $scope.majax = true;
        $http.get('RegistrarPersonas?'+datos($scope.persona)).success(function ( data ){
            alert(data);
            if(data.indexOf("Exitosamente")!==-1){ // registro exitoso
                $('#myModal').modal('hide');
                reset();
            }
            $scope.majax = false;
        });
    };
    
    
    
});