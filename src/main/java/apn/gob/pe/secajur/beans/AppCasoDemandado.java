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
@Table(name = "APP_CASO_DEMANDADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppCasoDemandado.findAll", query = "SELECT a FROM AppCasoDemandado a")})
public class AppCasoDemandado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppCasoDemandadoPK appCasoDemandadoPK;
    
    @JoinColumn(name = "CASO_CODIGO", referencedColumnName = "CASO_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AppCaso appCasoDemandado;

    public AppCasoDemandado() {
    }

    public AppCaso getAppCasoDemandado() {
        return appCasoDemandado;
    }

    public void setAppCasoDemandado(AppCaso appCasoDemandado) {
        this.appCasoDemandado = appCasoDemandado;
    }

    public AppCasoDemandadoPK getAppCasoDemandadoPK() {
        return appCasoDemandadoPK;
    }

    public void setAppCasoDemandadoPK(AppCasoDemandadoPK appCasoDemandadoPK) {
        this.appCasoDemandadoPK = appCasoDemandadoPK;
    } 
}
