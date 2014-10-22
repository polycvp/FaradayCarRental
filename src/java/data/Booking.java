
package data;

import java.util.Date;
/**
 * Booking object will hold the data for each booking
 */
public class Booking {
    private String bookingID;
    private String driverLicence;
    private String licencePlate;
    private String pickUpPlace;
    private String deliveryPlace;
    private Date pickUpTime;
    private Date deliveryTime;
    
    
    /**
     * ######################
     * GETTERS & SETTERS
     * Omitted for this example
     * ######################
     */
    
    public Booking() {
        
    }
    
    public String getBookingID() {
        return bookingID;
    }
    
    public String getDriverLicence() {
        return driverLicence;
    }
    
    public void setDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
    }
    
    public String getLicencePlate() {
        return licencePlate;
    }
    
    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
    
    public String getPickUpPlace() {
        return pickUpPlace;
    }
    
    public void setPickUpPlace(String pickUpPlace) {
        this.pickUpPlace = pickUpPlace;
    }
    
    public String getDeliveryPlace() {
        return deliveryPlace;
    }
    
    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }
    
    public Date getPickUpTime() {
        return pickUpTime;
    }
    
    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }
    
    public Date getDeliveryTime() {
        return deliveryTime;
    }
    
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }   
}
