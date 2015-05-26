

angular.module("softhome").controller("carousel", function ($scope) { // controlador de carrusel con el modulo SoftHome

    $scope.ruta = "imgs/main/"; //  ruta raiz de imagen
    $scope.nImg = 4; // numero de imagenes
    $scope.imgs = []; // guardar imagenes
    $scope.slides = []; // dispositivos
    $scope.main = $scope.ruta+1+".jpg"; // servicio raiz de imagen
    $scope.mainSlide = "0"; // principales dispositivos
    
    // ciclo para  que  que guardemos la imagen directamente por el numero de imagenes
    for (var i = 2; i <= $scope.nImg; i++) {
        $scope.slides.push(i-1);       
        $scope.imgs.push($scope.ruta + i + ".jpg");
    }

});