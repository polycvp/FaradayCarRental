/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "FARADAY_PLACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaradayPlace.findAll", query = "SELECT f FROM FaradayPlace f")})
public class FaradayPlace implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @OneToMany(mappedBy = "parkingPlaceId")
    private List<FaradayCar> faradayCarList;
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "ID")
    @ManyToOne
    private FaradayHotel hotelId;
    @JoinColumn(name = "AIRPORT_ID", referencedColumnName = "ID")
    @ManyToOne
    private FaradayAirport airportId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pickupPlaceId")
    private List<FaradayBooking> faradayBookingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPlaceId")
    private List<FaradayBooking> faradayBookingList1;

    public FaradayPlace() {
    }

    public FaradayPlace(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlTransient
    public List<FaradayCar> getFaradayCarList() {
        return faradayCarList;
    }

    public void setFaradayCarList(List<FaradayCar> faradayCarList) {
        this.faradayCarList = faradayCarList;
    }

    public FaradayHotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(FaradayHotel hotelId) {
        this.hotelId = hotelId;
    }

    public FaradayAirport getAirportId() {
        return airportId;
    }

    public void setAirportId(FaradayAirport airportId) {
        this.airportId = airportId;
    }

    @XmlTransient
    public List<FaradayBooking> getFaradayBookingList() {
        return faradayBookingList;
    }

    public void setFaradayBookingList(List<FaradayBooking> faradayBookingList) {
        this.faradayBookingList = faradayBookingList;
    }

    @XmlTransient
    public List<FaradayBooking> getFaradayBookingList1() {
        return faradayBookingList1;
    }

    public void setFaradayBookingList1(List<FaradayBooking> faradayBookingList1) {
        this.faradayBookingList1 = faradayBookingList1;
    }

    @Override
    public String toString() {
        return "data.FaradayPlace[ id=" + id + " ]";
    }
    
}
