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
                    <td>${cars.}</td>
                    <td></td>
                </c:forEach>
            </table>
        </div>
        <form>
            
        </form>
    </body>
</html>
