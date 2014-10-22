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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "FARADAY_CAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaradayCar.findAll", query = "SELECT f FROM FaradayCar f"),
    @NamedQuery(name = "FaradayCar.findByLicensePlateNo", query = "SELECT f FROM FaradayCar f WHERE f.licensePlateNo = :licensePlateNo")})
public class FaradayCar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LICENSE_PLATE_NO")
    private String licensePlateNo;
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FaradayCartype typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carLicensePlateNo")
    private List<FaradayBooking> faradayBookingList;

    public FaradayCar() {
    }

    public FaradayCar(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public FaradayCartype getTypeId() {
        return typeId;
    }

    public void setTypeId(FaradayCartype typeId) {
        this.typeId = typeId;
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
        hash += (licensePlateNo != null ? licensePlateNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaradayCar)) {
            return false;
        }
        FaradayCar other = (FaradayCar) object;
        if ((this.licensePlateNo == null && other.licensePlateNo != null) || (this.licensePlateNo != null && !this.licensePlateNo.equals(other.licensePlateNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.FaradayCar[ licensePlateNo=" + licensePlateNo + " ]";
    }
    
}
