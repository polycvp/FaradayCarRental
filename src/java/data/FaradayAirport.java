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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "FARADAY_AIRPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaradayAirport.findAll", query = "SELECT f FROM FaradayAirport f"),
    @NamedQuery(name = "FaradayAirport.findById", query = "SELECT f FROM FaradayAirport f WHERE f.id = :id"),
    @NamedQuery(name = "FaradayAirport.findByAirportCode", query = "SELECT f FROM FaradayAirport f WHERE f.airportCode = :airportCode")})
public class FaradayAirport implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AIRPORT_CODE")
    private BigInteger airportCode;
    @OneToMany(mappedBy = "airportId")
    private List<FaradayPlace> faradayPlaceList;

    public FaradayAirport() {
    }

    public FaradayAirport(BigDecimal id) {
        this.id = id;
    }

    public FaradayAirport(BigDecimal id, BigInteger airportCode) {
        this.id = id;
        this.airportCode = airportCode;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(BigInteger airportCode) {
        this.airportCode = airportCode;
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
        if (!(object instanceof FaradayAirport)) {
            return false;
        }
        FaradayAirport other = (FaradayAirport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.FaradayAirport[ id=" + id + " ]";
    }
    
}
