
package dao;

import data.Booking;
/**
 * Interface for implementing access methods for booking DAO concrete classes
 */
public interface BookingDAO {
    
    /**
     * Read a booking from the database and load to into a Booking object
     * @param driverLicence     The driver licence number of the booking to read
     * @return  a booking object loaded with the record data or null if the booking was not found
     */
    public Booking loadBooking(String driverLicence);
    
    /**
     * Save booking information to the database.
     * This will overwrite existing data if the booking already exists
     * or create a new record if the booking is not currently in the database
     * @param booking   A booking object loaded with booking data
     */
    public void saveBooking(Booking booking);
    
    /**
     * Delete booking information from the database.
     * This will delete a booking from the database
     * @param booking   A booking object loaded with booking data
     */
    public void deleteBooking(Booking booking);
}
