/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author consultor.oti3
 */
@Entity
@Table(name = "APP_USER", catalog = "", schema = "CASOSUAJ", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"USR_USERNAME"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUser.Listar.Todos", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUser.findbyUser", query = "SELECT a FROM AppUser a where a.usrUsername =:usr and a.usrPassword =:pwd"),
    @NamedQuery(name = "AppUser.validateUser", query = "select AA from AppUser AA WHERE AA.usrUsername=function('FU_VALIDALOGIN',:usr,:pwd)")
})
public class AppUser implements Serializable {

    @Column(name = "USR_ESTADO")
    private int usrEstado;

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USR_ID", nullable = false)
    private int usrId;
    @Column(name = "USR_USERNAME", nullable = false, length = 30)
    private String usrUsername;
    @Column(name = "USR_CONTRASENA", nullable = false, length = 500)
    private String usrPassword;
    
    @Column(name = "USR_FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechareg;
        
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne
    private AppPersona appPersona;
    
    
    @OneToMany(cascade = CascadeType.ALL, fetch = EAGER, mappedBy = "appUser") //fetch=FetchType.LAZY
    private List<AppUserLog> appUserLogs;
    
    public AppUser() {
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }
    
    public int getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(int usrEstado) {
        this.usrEstado = usrEstado;
    }

    public String getUsrUsername() {
        return usrUsername;
    }

    public void setUsrUsername(String usrUsername) {
        this.usrUsername = usrUsername;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public Date getUsrFechareg() {
        return usrFechareg;
    }

    public void setUsrFechareg(Date usrFechareg) {
        this.usrFechareg = usrFechareg;
    }

    public List<AppUserLog> getAppUserLogs() {
        return appUserLogs;
    }
    
    public void setAppUserLogs(List<AppUserLog> appUserLogs) {
        this.appUserLogs = appUserLogs;
    }

    public AppPersona getAppPersona() {
        return appPersona;
    }

    public void setAppPersona(AppPersona appPersona) {
        this.appPersona = appPersona;
    }

    @Override
    public String toString() {
        return "AppUser{" + "usrEstado=" + usrEstado + ", usrId=" + usrId + ", usrUsername=" + usrUsername + ", usrPassword=" + usrPassword + ", usrFechareg=" + usrFechareg + ", appPersona=" + appPersona + ", appUserLogs=" + appUserLogs + '}';
    }
}
