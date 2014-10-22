<%-- 
    Document   : header
    Created on : Oct 15, 2014, 2:25:53 AM
    Author     : rvhaley
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Faraday: Car Rental</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/smoothness/jquery-ui.css"/>
        <script src="js/jquery.csv-0.71.js" type="text/javascript"></script>
        <link rel="stylesheet" href="fonts/fonts.css" />
        <link rel="stylesheet" href="css/main.css" />
        <script src="js/main.js" type="text/javascript"></script>
    </head>
    <body>

        <br />
        <div id="headerDiv">
            <br />
            <h1 id="headerTitle">Faraday</h1>
            <br />
        </div>
        <br />
        <div id="navDiv">
            <a href="#" class="anchorButtons">View Cars</a>
            <a href="/FaradayCarRental/BookingServlet?command=select" class="anchorButtons">Make Booking</a>
            <a href="#" class="anchorButtons">View Booking</a>
            <a href="#" class="anchorButtons">Cancel Booking</a>
        </div>
        <br />
        <br />
        <br />

