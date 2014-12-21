/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function start() {
    PF('statusDialog').show();
}
 
function stop() {
    PF('statusDialog').hide();
}

PrimeFaces.locales['es'] = {
    closeText: 'Cerrar',
    prevText: 'Anterior',
    nextText: 'Siguiente',
    monthNames: ['Enero','Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
    monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
    dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
    dayNamesShort: ['Dom','Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
    dayNamesMin: ['D','L','M','X','J','V','S'],
    weekHeader: 'Semana',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Sólo hora',
    timeText: 'Tiempo',
    hourText: 'Hora',
    minuteText: 'Minuto',
    secondText: 'Segundo',
    currentText: 'Fecha actual',
    ampm: false,
    month: 'Mes',
    week: 'Semana',
    day: 'Día',
    allDayText : 'Todo el día'
};

function handleLoginRequest(xhr, status, args) {
    if (args.validationFailed || !args.loggedIn) {
        PF('dlg').jq.effect("shake", {times: 5}, 100);
    }
    else {
        PF('dlg').hide();
        $('#loginLink').fadeOut();
    }
}

function manejarLogin(xhr, status, args) {
    if (!args.validationFailed && args.estaLogeado) {
        setTimeout(function() {
            window.location = args.view;
        }, 500);
    }
}

function manejarRegistro(xhr, status, args){
    if (!args.validationFailed && args.estaRegistrado) {
        setTimeout(function() {
            window.location = args.view;
        }, 500);
    }
}

function logout(xhr, status, args) {

    setTimeout(function() {
        window.location = 'user.xhtml';
    }, 500);

}