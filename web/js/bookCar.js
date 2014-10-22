/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    var dateToday = new Date();
    
    $("#pickupDatePicker").datepicker({
        dateFormat: 'dd-mm-yy',
        minDate: dateToday
    });
    
    $("#deliveryDatePicker").datepicker({
        dateFormat: 'dd-mm-yy',
        minDate: dateToday
    });
});

