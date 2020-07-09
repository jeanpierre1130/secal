/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.beans;

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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author consultor.oti3
 */
@Entity
@Table(name = "APP_CATCABE", catalog = "", schema = "CASOSUAJ")
@NamedQueries({
    @NamedQuery(name = "AppCatcabe.findAll", query = "SELECT a FROM AppCatcabe a"),
    @NamedQuery(name = "AppCatcabe.catalogoMantener", query = "SELECT a FROM AppCatcabe a where a.catCabe not in ('A','F') ")
})
public class AppCatcabe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CAT_CABECERA", nullable = false, length = 1)
    private String catCabe;
    @Size(max = 200)
    @Column(name = "CAT_CABEDESCRIPCION", length = 200)
    private String catCabedesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catCabe")
    private List<AppCatdata> appCatdataList;

    public AppCatcabe() {
    }

    public AppCatcabe(String catCabe) {
        this.catCabe = catCabe;
    }

    public String getCatCabe() {
        return catCabe;
    }

    public void setCatCabe(String catCabe) {
        this.catCabe = catCabe;
    }

    public String getCatCabedesc() {
        return catCabedesc;
    }

    public void setCatCabedesc(String catCabedesc) {
        this.catCabedesc = catCabedesc;
    }

    @XmlTransient
    public List<AppCatdata> getAppCatdataList() {
        return appCatdataList;
    }

    public void setAppCatdataList(List<AppCatdata> appCatdataList) {
        this.appCatdataList = appCatdataList;
    }

    @Override
    public String toString() {
        return "apn.gob.pe.secajur.beans.AppCatcabe[ catCabe=" + catCabe + " ]";
    }
}
