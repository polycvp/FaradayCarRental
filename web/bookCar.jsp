
 <%@ include file="header.jsp" %>
        <h1>Book a car</h1>
        <div id="availableCars">
            <table id="availableCarsTable" border="1" cellspacing="0">
                <tr>
                    <td>License Plate No.</td>
                    <td>Type</td>
                </tr>
                <c:forEach var="car" items="${cars}" varStatus="counter">
                    <td>${cars.licencePlateNo}</td>
                    <td>${cars.type}</td>
                </c:forEach>
            </table>
        </div>
        <form action="FaradayCarRental/BookingServlet">
             <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th class="scheduleTableSides">License Plate Number: </th>
            <td><input type="text" name="license_no" id="license_no" /></td>
        </tr>
        <tr>
            <th class="scheduleTableSides">Pickup Place: </th>
            <td><input type="text" id="pickupPlaceBooking"/></td>
        </tr>
        <tr>
            <th class="scheduleTableSides">Delivery Place </th>
            <td><input type="text" id="deliveryPlaceBooking"/></td>
        </tr>
          <tr>
            <th class="scheduleTableSides">Pickup Date: </th>
            <td><input type="text" name="date" id="datepicker" /></td>
        </tr>
        <tr>
            <th class="scheduleTableSides">Delivery Date: </th>
            <td><input type="text" name="date" id="datepicker" /></td>
        </tr>
    </table>
        <a href="/FaradayCarRental/BookingServlet?command=confirm" class="anchorButtons">Submit booking</a>
        </form>
<%@ include file="footer.jsp" %>

