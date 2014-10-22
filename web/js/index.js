$(function() {
    var dateToday = new Date();

    $("#datepicker").datepicker({
        dateFormat: 'dd-mm-yy',
        minDate: dateToday
    }
    );

    $("#scheduleSelect").button();
});


    
