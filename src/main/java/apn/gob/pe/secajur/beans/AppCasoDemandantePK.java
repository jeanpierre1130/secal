/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author consultor.oti3
 */
@Embeddable
public class AppCasoDemandantePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CASO_CODIGO")
    private long casoCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CASO_DEMANDANTE")
    private String casoDemandante;

    public AppCasoDemandantePK() {
    }

    public AppCasoDemandantePK(long casoCod, String casoDemandante) {
        this.casoCod = casoCod;
        this.casoDemandante = casoDemandante;
    }

    public long getCasoCod() {
        return casoCod;
    }

    public void setCasoCod(long casoCod) {
        this.casoCod = casoCod;
    }

    public String getCasoDemandante() {
        return casoDemandante;
    }

    public void setCasoDemandante(String casoDemandante) {
        this.casoDemandante = casoDemandante;
    }

    @Override
    public String toString() {
        return "apn.gob.pe.secajur.beans.AppCasoDemandantePK[ casoCod=" + casoCod + ", casoDemandante=" + casoDemandante + " ]";
    } 
}
