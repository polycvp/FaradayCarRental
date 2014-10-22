
package dao;

import data.Booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Concrete implementation of a BookingDAO for use with a Derby database
 */
public class DerbyBookingDAO implements BookingDAO {
    
    private Connection conn = null;
    private static String dbURL = "jdbc:derby://localhost:1527/myDB";

    @Override
    public Booking loadBooking(String driverLicence) {
        Booking booking = null;
        try {
            createConnection();
            Statement stmt = conn.createStatement();
            ResultSet resultset = stmt.executeQuery(
                    "SELECT * FROM Booking WHERE driverlicence = " + driverLicence + ";");
            if (null != resultset) {
                booking = loadBookingFromResultSet(resultset);
            }
            resultset.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(DerbyBookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return booking;
    }
    
    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
       
    /**
     * Helper method to load a booking from a result set
     * @param resultset The result set to read
     * @return  A new booking object with the values from the result set
     * @throws Exception 
     */
    private Booking loadBookingFromResultSet(ResultSet resultset) throws Exception {
        // Create a new booking and load it
        Booking booking = new Booking();
        booking.setDriverLicence(resultset.getString(1));
        booking.setLicencePlate(resultset.getString(2));
        booking.setPickUpPlace(resultset.getString(3));
        booking.setDeliveryPlace(resultset.getString(4));
        booking.setPickUpTime(resultset.getDate(5));
        booking.setDeliveryTime(resultset.getDate(6));
        
        return booking;
    }
   
    @Override
    public void saveBooking(Booking booking) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteBooking(Booking booking) {
        throw new UnsupportedOperationException("Not supported yet.");
    } 
    
}
