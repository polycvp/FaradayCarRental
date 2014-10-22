/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import dao.BookingCRUDFacade;
import data.Car;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jon
 */
public class CarBean implements Serializable
{
    private BookingCRUDFacade bcf;
    
    public CarBean() {
        bcf = new BookingCRUDFacade();
    }
    
    public List<Car> retrieveCars(String place,String type,Date pickupDate) {
        return bcf.retriveCars(place, type, pickupDate);
    }
}
