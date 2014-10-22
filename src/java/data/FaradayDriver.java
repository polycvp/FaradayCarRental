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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "FARADAY_DRIVER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaradayDriver.findAll", query = "SELECT f FROM FaradayDriver f")})
public class FaradayDriver implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LICENCE_NO")
    private String licenceNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driverLicenseNo")
    private List<FaradayBooking> faradayBookingList;

    public FaradayDriver() {
    }

    public FaradayDriver(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public FaradayDriver(String licenceNo, String name) {
        this.licenceNo = licenceNo;
        this.name = name;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<FaradayBooking> getFaradayBookingList() {
        return faradayBookingList;
    }

    public void setFaradayBookingList(List<FaradayBooking> faradayBookingList) {
        this.faradayBookingList = faradayBookingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licenceNo != null ? licenceNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaradayDriver)) {
            return false;
        }
        FaradayDriver other = (FaradayDriver) object;
        if ((this.licenceNo == null && other.licenceNo != null) || (this.licenceNo != null && !this.licenceNo.equals(other.licenceNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.FaradayDriver[ licenceNo=" + licenceNo + " ]";
    }
    
}
