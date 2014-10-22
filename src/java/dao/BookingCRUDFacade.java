
package dao;

import data.Booking;
import data.Car;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * Service layer class implementing business rules for working with booking data
 */
public class BookingCRUDFacade {
    // An instance of a DAO to work with a booking
    private BookingDAO dao = new JdbcBookingDAO();
    
    /**
     * Find a booking based on the driver licence numnber
     * @param driverLicence     The driver licence number to search
     * @return  A booking object loaded with the data or null if no booking found
     * @throws Exception    The driver licence number was invalid
     */
    public Booking findBooking(String driverLicence) throws Exception {
        // Make sure the driver licence number is valid
        if (StringUtils.isEmpty(driverLicence)) {
            throw new Exception("The driver licence number is not valid");
        }
        Booking booking = null;
        booking = dao.loadBooking(driverLicence);
        return booking;
    }
    
    public void setBooking(Booking b) {
        dao.saveBooking(b);
    }
    
    public List<Car> retriveCars(String place,String type,Date pickupDate) {
        return dao.getAvailableCars(place,type,pickupDate);
    }
}

