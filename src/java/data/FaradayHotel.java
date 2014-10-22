/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
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
    @NamedQuery(name = "FaradayHotel.findAll", query = "SELECT f FROM FaradayHotel f")})
public class FaradayHotel implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOTEL_NO")
    private int hotelNo;
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
    private int rating;
    @OneToMany(mappedBy = "hotelId")
    private List<FaradayPlace> faradayPlaceList;

    public FaradayHotel() {
    }

    public FaradayHotel(int id) {
        this.id = id;
    }

    public FaradayHotel(int id, int hotelNo, String name, String address, int rating) {
        this.id = id;
        this.hotelNo = hotelNo;
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(int hotelNo) {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
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
    public String toString() {
        return "data.FaradayHotel[ id=" + id + " ]";
    }
    
}
