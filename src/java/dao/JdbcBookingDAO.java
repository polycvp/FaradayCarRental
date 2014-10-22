
package dao;

import data.Booking;
import data.Car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Concrete implementation of a BookingDAO for use with a Derby database
 */
public class JdbcBookingDAO implements BookingDAO {
    
    private Connection conn = null;
    private static String dbURL = "jdbc://localhost:1521/cph-vc";
    private List<Car> cars;
    private List<Booking> bookings = new ArrayList<Booking>();

    public JdbcBookingDAO() {
        
    }
    
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
            Logger.getLogger(JdbcBookingDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            bookings.add(booking);
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void deleteBooking(Booking booking) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<Car> getAvailableCars(String place,String type,Date pickupDate) 
    {
        //assume all this cars are avaliable
        cars = new ArrayList<Car>();
        cars.add(new Car("FG78GF2312","A"));
        cars.add(new Car("GH56BV4876","A"));
        cars.add(new Car("XC34FG8906","B"));
        cars.add(new Car("QW10ER3456","C"));
        cars.add(new Car("JH67RT4123","C"));
        cars.add(new Car("UB53DF7980","C"));
        cars.add(new Car("ZX34TY0945","D"));
        cars.add(new Car("KL34DQ9764","D"));
        cars.add(new Car("CV76ER2345","E"));
        cars.add(new Car("RT72HG1045","F"));
        for (Car c: cars) {
            c.setType(type);
        }
        return cars;
    }
    
}
