/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.beans;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author consultor.oti3
 */
@Entity
@Table(name = "APP_CASO_DEMANDANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppCasoDemandante.findAll", query = "SELECT a FROM AppCasoDemandante a")})

public class AppCasoDemandante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppCasoDemandantePK appCasoDemandantePK;
    
    @JoinColumn(name = "CASO_CODIGO", referencedColumnName = "CASO_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AppCaso appCasoDemandante;

    public AppCasoDemandantePK getAppCasoDemandantePK() {
        return appCasoDemandantePK;
    }

    public void setAppCasoDemandantePK(AppCasoDemandantePK appCasoDemandantePK) {
        this.appCasoDemandantePK = appCasoDemandantePK;
    }   
    
    public AppCasoDemandante() {
    }

    public AppCaso getAppCasoDemandante() {
        return appCasoDemandante;
    }

    public void setAppCasoDemandante(AppCaso appCasoDemandante) {
        this.appCasoDemandante = appCasoDemandante;
    }
}
