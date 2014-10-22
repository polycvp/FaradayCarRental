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
                
                <label for="pickupDateBooking"></label>
                <input typ
            </fieldset>
        </form>
    </body>
</html>
