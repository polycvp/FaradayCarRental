<%-- 
    Document   : bookCar
    Created on : 22-Oct-2014, 16:12:11
    Author     : Jon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery_1.7.2_jquery.min.js"></script>
        <script type="text/javascript" src="js/ui_1.11.1_jquery-ui.js"></script>
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="js/bookCar.js"></script>
        <link rel="stylesheet" type="text/css" href="js/jqueryui_1.11.1_themes_smoothness_jquery-ui.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book a car</h1>
        <div id="availableCars">
            <table id="availableCarsTable" border="1" cellspacing="0">
                <tr>
                    <td>Licence Plate No.</td>
                    <td>Type</td>
                </tr>
                <c:forEach var="car" items="${cars}" varStatus="counter">
                    <td>${cars.licencePlateNo}</td>
                    <td>${cars.type}</td>
                </c:forEach>
            </table>
        </div>
        <form>
            <fieldset>
                <label for="licencePlateNoBooking">Licence Plate Number: </label>
                <input type="text" id="licencePlateNoBooking"/>
                
                <label for="pickupPlaceBooking">Pickup Place: </label>
                <input type="text" id="pickupPlaceBooking"/>
                
                <label for="deliveryPlaceBooking"></label>
                <input type="text" id="deliveryPlaceBooking"/>
                
                <label for="pickupDatePicker">Pickup Date: </label>
                <input type="text" id="pickupDatePicker"/>
                
                <label for="deliveryDatePicker">Delivery Date: </label>
                <input type="text" id="deliveryDatePicker"/>
                
                <input type="submit" id="submitBookingButton" value="Submit Booking"/>
            </fieldset>
        </form>
    </body>
</html>
