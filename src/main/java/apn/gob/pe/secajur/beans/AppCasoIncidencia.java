/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author consultor.oti3
 */
@Entity
@Table(name = "APP_CASO_INCIDENCIA", catalog = "", schema = "CASOSUAJ")
@NamedQueries({
    @NamedQuery(name = "AppCasoIncidencia.findAll", query = "SELECT a FROM AppCasoIncidencia a"),
    @NamedQuery(name = "AppCasoIncidencia.listarincidencias", query = "SELECT a FROM AppCasoIncidencia a where a.appCaso.casoCod =:codcaso")
})
public class AppCasoIncidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAB_APP_CASO_INCIDENCIA_SEQ")
    @SequenceGenerator(name = "TAB_APP_CASO_INCIDENCIA_SEQ", sequenceName = "TAB_APP_CASO_INCIDENCIA_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "INC_CODIGO", nullable = false)
    private int incCod;
    
    @Column(name = "INC_DESCRIPCION", length = 4000)
    private String incDes;
    
    @Basic(optional = false)
    @Column(name = "INC_FECHAREGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date incFec;
    
    @Column(name = "INC_FLAG")
    private int incFlag;
    
    @Column(name = "INC_ALERTA_DATA1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incAlrtDat1;
    
    @Column(name = "INC_ALERTA_DATA2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incAlrtDat2;
    
    @Column(name = "INC_TIEMPO_ALERTA")
    private int incAlrtTimer;
            
    @Column(name = "INC_TIPO")
    private double incTipo;
    
    @Column(name = "INC_CC", length = 500)
    private String inc_Copias;
    
    @Column(name = "INC_TO", length = 100)
    private String inc_Para;
    
    @JoinColumn(name = "CASO_CODIGO", referencedColumnName = "CASO_CODIGO")
    @ManyToOne
    private AppCaso appCaso;

    public AppCasoIncidencia() {
    }

    public int getIncCod() {
        return incCod;
    }

    public void setIncCod(int incCod) {
        this.incCod = incCod;
    }

    public String getIncDes() {
        return incDes;
    }

    public void setIncDes(String incDes) {
        this.incDes = incDes;
    }

    public Date getIncFec() {
        return incFec;
    }

    public void setIncFec(Date incFec) {
        this.incFec = incFec;
    }

    public int getIncFlag() {
        return incFlag;
    }

    public void setIncFlag(int incFlag) {
        this.incFlag = incFlag;
    }

    public Date getIncAlrtDat1() {
        return incAlrtDat1;
    }

    public void setIncAlrtDat1(Date incAlrtDat1) {
        this.incAlrtDat1 = incAlrtDat1;
    }

    public Date getIncAlrtDat2() {
        return incAlrtDat2;
    }

    public void setIncAlrtDat2(Date incAlrtDat2) {
        this.incAlrtDat2 = incAlrtDat2;
    }

    public int getIncAlrtTimer() {
        return incAlrtTimer;
    }

    public void setIncAlrtTimer(int incAlrtTimer) {
        this.incAlrtTimer = incAlrtTimer;
    }

    public double getIncTipo() {
        return incTipo;
    }

    public void setIncTipo(double incTipo) {
        this.incTipo = incTipo;
    }

    public String getInc_Copias() {
        return inc_Copias;
    }

    public void setInc_Copias(String inc_Copias) {
        this.inc_Copias = inc_Copias;
    }

    public String getInc_Para() {
        return inc_Para;
    }

    public void setInc_Para(String inc_Para) {
        this.inc_Para = inc_Para;
    }

    public AppCaso getAppCaso() {
        return appCaso;
    }

    public void setAppCaso(AppCaso appCaso) {
        this.appCaso = appCaso;
    }
    
    @Override
    public String toString() {
        return "javaapplication1.AppCasoIncidencia[ incCod=" + incCod + " ]";
    }

}
