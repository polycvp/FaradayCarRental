/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "FARADAY_HOTEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaradayHotel.findAll", query = "SELECT f FROM FaradayHotel f"),
    @NamedQuery(name = "FaradayHotel.findById", query = "SELECT f FROM FaradayHotel f WHERE f.id = :id"),
    @NamedQuery(name = "FaradayHotel.findByHotelNo", query = "SELECT f FROM FaradayHotel f WHERE f.hotelNo = :hotelNo"),
    @NamedQuery(name = "FaradayHotel.findByName", query = "SELECT f FROM FaradayHotel f WHERE f.name = :name"),
    @NamedQuery(name = "FaradayHotel.findByAddress", query = "SELECT f FROM FaradayHotel f WHERE f.address = :address"),
    @NamedQuery(name = "FaradayHotel.findByRating", query = "SELECT f FROM FaradayHotel f WHERE f.rating = :rating")})
public class FaradayHotel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOTEL_NO")
    private BigInteger hotelNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATING")
    private BigInteger rating;
    @OneToMany(mappedBy = "hotelId")
    private List<FaradayPlace> faradayPlaceList;

    public FaradayHotel() {
    }

    public FaradayHotel(BigDecimal id) {
        this.id = id;
    }

    public FaradayHotel(BigDecimal id, BigInteger hotelNo, String name, String address, BigInteger rating) {
        this.id = id;
        this.hotelNo = hotelNo;
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(BigInteger hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getRating() {
        return rating;
    }

    public void setRating(BigInteger rating) {
        this.rating = rating;
    }

    @XmlTransient
    public List<FaradayPlace> getFaradayPlaceList() {
        return faradayPlaceList;
    }

    public void setFaradayPlaceList(List<FaradayPlace> faradayPlaceList) {
        this.faradayPlaceList = faradayPlaceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaradayHotel)) {
            return false;
        }
        FaradayHotel other = (FaradayHotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.FaradayHotel[ id=" + id + " ]";
    }
    
}
