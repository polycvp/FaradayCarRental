/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "FARADAY_BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaradayBooking.findAll", query = "SELECT f FROM FaradayBooking f"),
    @NamedQuery(name = "FaradayBooking.findByBookingNo", query = "SELECT f FROM FaradayBooking f WHERE f.bookingNo = :bookingNo"),
    @NamedQuery(name = "FaradayBooking.findByPickupTime", query = "SELECT f FROM FaradayBooking f WHERE f.pickupTime = :pickupTime"),
    @NamedQuery(name = "FaradayBooking.findByDeliveryTime", query = "SELECT f FROM FaradayBooking f WHERE f.deliveryTime = :deliveryTime")})
public class FaradayBooking implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_NO")
    private BigDecimal bookingNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PICKUP_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERY_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryTime;
    @JoinColumn(name = "PICKUP_PLACE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FaradayPlace pickupPlaceId;
    @JoinColumn(name = "DELIVERY_PLACE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FaradayPlace deliveryPlaceId;
    @JoinColumn(name = "DRIVER_LICENSE_NO", referencedColumnName = "LICENCE_NO")
    @ManyToOne(optional = false)
    private FaradayDriver driverLicenseNo;
    @JoinColumn(name = "CAR_LICENSE_PLATE_NO", referencedColumnName = "LICENSE_PLATE_NO")
    @ManyToOne(optional = false)
    private FaradayCar carLicensePlateNo;

    public FaradayBooking() {
    }

    public FaradayBooking(BigDecimal bookingNo) {
        this.bookingNo = bookingNo;
    }

    public FaradayBooking(BigDecimal bookingNo, Date pickupTime, Date deliveryTime) {
        this.bookingNo = bookingNo;
        this.pickupTime = pickupTime;
        this.deliveryTime = deliveryTime;
    }

    public BigDecimal getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(BigDecimal bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public FaradayPlace getPickupPlaceId() {
        return pickupPlaceId;
    }

    public void setPickupPlaceId(FaradayPlace pickupPlaceId) {
        this.pickupPlaceId = pickupPlaceId;
    }

    public FaradayPlace getDeliveryPlaceId() {
        return deliveryPlaceId;
    }

    public void setDeliveryPlaceId(FaradayPlace deliveryPlaceId) {
        this.deliveryPlaceId = deliveryPlaceId;
    }

    public FaradayDriver getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(FaradayDriver driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public FaradayCar getCarLicensePlateNo() {
        return carLicensePlateNo;
    }

    public void setCarLicensePlateNo(FaradayCar carLicensePlateNo) {
        this.carLicensePlateNo = carLicensePlateNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingNo != null ? bookingNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaradayBooking)) {
            return false;
        }
        FaradayBooking other = (FaradayBooking) object;
        if ((this.bookingNo == null && other.bookingNo != null) || (this.bookingNo != null && !this.bookingNo.equals(other.bookingNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.FaradayBooking[ bookingNo=" + bookingNo + " ]";
    }
    
}
