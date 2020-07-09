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
@Table(name = "APP_CASO_ABOGADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppCasoAbogado.findAll", query = "SELECT a FROM AppCasoAbogado a")
})
public class AppCasoAbogado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppCasoAbogadoPK appCasoAbogadoPK;
    
    @JoinColumn(name = "CASO_CODIGO", referencedColumnName = "CASO_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AppCaso appCasoAbogado;

    public AppCasoAbogadoPK getAppCasoAbogadoPK() {
        return appCasoAbogadoPK;
    }

    public void setAppCasoAbogadoPK(AppCasoAbogadoPK appCasoAbogadoPK) {
        this.appCasoAbogadoPK = appCasoAbogadoPK;
    }

    public AppCasoAbogado() {
    }

    public AppCaso getAppCasoAbogado() {
        return appCasoAbogado;
    }

    public void setAppCasoAbogado(AppCaso appCasoAbogado) {
        this.appCasoAbogado = appCasoAbogado;
    }
}
