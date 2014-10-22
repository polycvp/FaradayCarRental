
package bean;

import java.io.Serializable;
import data.Booking;
import dao.BookingCRUDFacade;
/**
 * BookingBean used to connect the booking information to the UI
 */
public class BookingBean implements Serializable {    
    private static final long serialVersionUID = 1L;
    // An instance of a booking object to be added, updated, or deleted
    private Booking booking;
    // The CRUD facade for accessing and updating the booking information
    private BookingCRUDFacade bookingCrud;
    
    public BookingBean() {
        super();
        bookingCrud = new BookingCRUDFacade();
    }
    
    public void showBooking(String driverLicence) {
        try {
            setBooking(bookingCrud.findBooking(driverLicence));
            getBooking();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Get the booking to work with
     * @return  The booking object to work with
     */
    public Booking getBooking() {
        return booking;
    }
    
    /**
     * Set the booking to work with
     * @param booking   The booking to work with
     */
    public void setBooking(Booking booking) {
        this.booking = booking;
    }   
}
