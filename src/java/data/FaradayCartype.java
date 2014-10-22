/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "FARADAY_CARTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaradayCartype.findAll", query = "SELECT f FROM FaradayCartype f"),
    @NamedQuery(name = "FaradayCartype.findById", query = "SELECT f FROM FaradayCartype f WHERE f.id = :id"),
    @NamedQuery(name = "FaradayCartype.findByNoOfSeats", query = "SELECT f FROM FaradayCartype f WHERE f.noOfSeats = :noOfSeats"),
    @NamedQuery(name = "FaradayCartype.findByPrice", query = "SELECT f FROM FaradayCartype f WHERE f.price = :price")})
public class FaradayCartype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_OF_SEATS")
    private BigInteger noOfSeats;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigInteger price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private List<FaradayCar> faradayCarList;

    public FaradayCartype() {
    }

    public FaradayCartype(String id) {
        this.id = id;
    }

    public FaradayCartype(String id, BigInteger noOfSeats, BigInteger price) {
        this.id = id;
        this.noOfSeats = noOfSeats;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(BigInteger noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @XmlTransient
    public List<FaradayCar> getFaradayCarList() {
        return faradayCarList;
    }

    public void setFaradayCarList(List<FaradayCar> faradayCarList) {
        this.faradayCarList = faradayCarList;
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
        if (!(object instanceof FaradayCartype)) {
            return false;
        }
        FaradayCartype other = (FaradayCartype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.FaradayCartype[ id=" + id + " ]";
    }
    
}
