function datos(variables) {
    var cont = "";
    $.map(variables, function (val, id) {
        val = val.toString().replace(/\+/g, "%2B");
        cont += id + "=" + val + "&";
    });
    return cont;
}
 // utilidades para la fecha 
function validarFecha(fecha) {
    var ex = /^((([0][1-9]|[12][\d])|[3][01])[-\/]([0][13578]|[1][02])[-\/][1-9]\d\d\d)|((([0][1-9]|[12][\d])|[3][0])[-\/]([0][13456789]|[1][012])[-\/][1-9]\d\d\d)|(([0][1-9]|[12][\d])[-\/][0][2][-\/][1-9]\d([02468][048]|[13579][26]))|(([0][1-9]|[12][0-8])[-\/][0][2][-\/][1-9]\d\d\d)$/;
    alert(fecha.replace(/\-/g, "/"));
    return ex.test(fecha.replace(/\-/g, "/"));
}

function isMovil() { // adaptabilidad para toda clase de dispositivos  navegador
    var device = navigator.userAgent;
    if (device.match(/Iphone/i) || device.match(/Ipod/i) || device.match(/Android/i) || device.match(/J2ME/i) || device.match(/BlackBerry/i) || device.match(/iPhone|iPad|iPod/i) || device.match(/Opera Mini/i) || device.match(/IEMobile/i) || device.match(/Mobile/i) || device.match(/Windows Phone/i) || device.match(/windows mobile/i) || device.match(/windows ce/i) || device.match(/webOS/i) || device.match(/palm/i) || device.match(/bada/i) || device.match(/series60/i) || device.match(/nokia/i) || device.match(/symbian/i) || device.match(/HTC/i))
    {
        return true; // si hay alguno utilicelo
    }
    else
    {
        return false; // si no  no  hacer la funcion  de navegador
    }
}

function buscarBarrios(criterio) { // Busca los barrios  por criterios 
    var barrios = new Array();
    GMaps.geocode({
        address: criterio,
        callback: function (results, status) {
            if (status === 'OK') {
                $.map(results, function (val, id) {
                    barrios.push(val);
                });
            }
        }
    });
    return barrios;
}
var mapa;
function cargarMapa() {
    GMaps.geolocate({
        success: function (position) {
            mapa = new GMaps({
                div: '#mapa',
                lat: position.coords.latitude,
                lng: position.coords.longitude,
                zoom: 15
            });
            mapa.setCenter(position.coords.latitude, position.coords.longitude);
        },
        error: function (error) {
            alert('Geolocation failed: ' + error.message);
        },
        not_supported: function () {
            alert("Your browser does not support geolocation");
        }
    });
}