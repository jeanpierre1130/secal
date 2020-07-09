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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author consultor.oti3
 */
@Entity
@Table(name = "APP_PERSONA", catalog = "", schema = "CASOSUAJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppPersona.findAll", query = "SELECT a FROM AppPersona a")
})
public class AppPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID", nullable = false)
    private int perId;
    @Size(max = 15)
    @Column(name = "PER_NUMDOCUMENTO", length = 15)
    private String perNumdoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PER_NOMBRES", nullable = false, length = 100)
    private String perFullname;
    @Size(max = 5)
    @Column(name = "PER_TIPO", length = 5)
    private String perTipo;
    @Size(max = 50)
    @Column(name = "PER_CORREO", length = 50)
    private String perEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PER_TIPO_DOCUMENTO", nullable = false, length = 5)
    private String perDoctipo;
    
    @Column(name = "PER_IMAGEN_URL")
    private String perImgURL;
    
    @Column(name = "PER_AREA")
    private String perArea;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appPersona")
    private List<AppUser> appUserList;

    public String getPerImgURL() {
        return perImgURL;
    }

    public void setPerImgURL(String perImgURL) {
        this.perImgURL = perImgURL;
    }
    
    public AppPersona() {
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getPerNumdoc() {
        return perNumdoc;
    }

    public void setPerNumdoc(String perNumdoc) {
        this.perNumdoc = perNumdoc;
    }

    public String getPerFullname() {
        return perFullname;
    }

    public void setPerFullname(String perFullname) {
        this.perFullname = perFullname;
    }

    public String getPerTipo() {
        return perTipo;
    }

    public void setPerTipo(String perTipo) {
        this.perTipo = perTipo;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerDoctipo() {
        return perDoctipo;
    }

    public void setPerDoctipo(String perDoctipo) {
        this.perDoctipo = perDoctipo;
    }

    public String getPerArea() {
        return perArea;
    }

    public void setPerArea(String perArea) {
        this.perArea = perArea;
    }  

    public List<AppUser> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }

    @Override
    public String toString() {
        return "AppPersona{" + "perId=" + perId + ", perNumdoc=" + perNumdoc + ", perFullname=" + perFullname + ", perTipo=" + perTipo + ", perEmail=" + perEmail + ", perDoctipo=" + perDoctipo + ", perImgURL=" + perImgURL + ", perArea=" + perArea + ", appUserList=" + appUserList + '}';
    }    
}
