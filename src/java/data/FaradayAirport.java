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
    @NamedQuery(name = "FaradayAirport.findAll", query = "SELECT f FROM FaradayAirport f")})
public class FaradayAirport implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AIRPORT_CODE")
    private int airportCode;
    @OneToMany(mappedBy = "airportId")
    private List<FaradayPlace> faradayPlaceList;

    public FaradayAirport() {
    }

    public FaradayAirport(int id) {
        this.id = id;
    }

    public FaradayAirport(int id, int airportCode) {
        this.id = id;
        this.airportCode = airportCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(int airportCode) {
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
    public String toString() {
        return "data.FaradayAirport[ id=" + id + " ]";
    }
    
}
