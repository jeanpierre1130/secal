/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author consultor.oti3
 */
@Entity
@Table(name = "APP_CASO", catalog = "", schema = "CASOSUAJ")
@NamedQueries({
    @NamedQuery(name = "AppCaso.findAll", query = "SELECT a FROM AppCaso a"),
    @NamedQuery(name = "AppCaso.findByCasoCod", query = "SELECT a FROM AppCaso a WHERE a.casoCod = :casoCod"),
    @NamedQuery(name = "AppCaso.listarDescendente", query = "SELECT a FROM AppCaso a ORDER BY a.casoFechareg DESC"),
    
})
public class AppCaso implements Serializable {

    @Column(name = "CASO_MONTO")
    private double casoMonto;
    @Column(name = "CASO_ESTADO")
    private int casoEstado;
    @Column(name = "CASO_MATERIA")
    private int casoMateria;
    @Column(name = "CASO_CUANTIA")
    private double casoCuantia;
    @Column(name = "CASO_TIPOPROCESO")
    private int casoTipoproceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appCasoDemandante",fetch = FetchType.EAGER, orphanRemoval=true)
    private List<AppCasoDemandante> appCasoDemandanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appCasoAbogado",fetch = FetchType.EAGER, orphanRemoval=true)
    private List<AppCasoAbogado> appCasoAbogadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appCasoDemandado",fetch = FetchType.EAGER, orphanRemoval=true)
    private List<AppCasoDemandado> appCasoDemandadoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CASO_CODIGO")
    private int casoCod;
    
    @Column(name = "CASO_EXPEDIENTE", length = 30)
    private String casoExped;
    @Column(name = "CASO_LEGAJO", length = 30)
    private String casoLegajo;
    @Column(name = "CASO_USUARIO", length = 30)
    private String casoUsuario;
    @Column(name = "CASO_FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date casoFechareg;
    
    @Column(name = "CASO_DEPENDENCIA")
    private String casoDependencia;
    @Column(name = "CASO_JUZGADO", length = 30)
    private String casoJuzgado;
    @Column(name = "CASO_MONEDA", length = 30)
    private String casoMoneda;
    @Lob
    @Column(name = "CASO_ARCHIVO_1")
    private byte[] casoArchivo1;
    @Lob
    @Column(name = "CASO_ARCHIVO_2")
    private byte[] casoArchivo2;
    @Lob
    @Column(name = "CASO_ARCHIVO_3")
    private byte[] casoArchivo3;

    public byte[] getCasoArchivo1() {
        return casoArchivo1;
    }

    public void setCasoArchivo1(byte[] casoArchivo1) {
        this.casoArchivo1 = casoArchivo1;
    }

    public byte[] getCasoArchivo2() {
        return casoArchivo2;
    }

    public void setCasoArchivo2(byte[] casoArchivo2) {
        this.casoArchivo2 = casoArchivo2;
    }

    public byte[] getCasoArchivo3() {
        return casoArchivo3;
    }

    public void setCasoArchivo3(byte[] casoArchivo3) {
        this.casoArchivo3 = casoArchivo3;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appCaso")
    private List<AppCasoIncidencia> appCasoIncidencias;
    
    //PARA RELACIONAR EL ESTADO DEL CASO
    @JoinColumn(name = "CASO_ESTADO", referencedColumnName = "COD_CATALOGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AppCatdata catdata_Estado;
   //PARA RELACIONAR EL TIPO DE PROCESO
    @JoinColumn(name = "CASO_TIPOPROCESO", referencedColumnName = "COD_CATALOGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AppCatdata catdata_TipoProceso;
    //PARA RELACIONAR EL TIPO DE MATERIA
    @JoinColumn(name = "CASO_MATERIA", referencedColumnName = "COD_CATALOGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AppCatdata catdata_Materia;
       
    public AppCaso() {
    }

    public AppCatdata getCatdata_Materia() {
        return catdata_Materia;
    }

    public void setCatdata_Materia(AppCatdata catdata_Materia) {
        this.catdata_Materia = catdata_Materia;
    }
    
    public int getCasoCod() {
        return casoCod;
    }

    public void setCasoCod(int casoCod) {
        this.casoCod = casoCod;
    }

    public String getCasoExped() {
        return casoExped;
    }

    public void setCasoExped(String casoExped) {
        this.casoExped = casoExped;
    }

    public String getCasoLegajo() {
        return casoLegajo;
    }

    public void setCasoLegajo(String casoLegajo) {
        this.casoLegajo = casoLegajo;
    }

    public String getCasoUsuario() {
        return casoUsuario;
    }

    public void setCasoUsuario(String casoUsuario) {
        this.casoUsuario = casoUsuario;
    }

    public String getCasoMoneda() {
        return casoMoneda;
    }

    public void setCasoMoneda(String casoMoneda) {
        this.casoMoneda = casoMoneda;
    }
    
    public Date getCasoFechareg() {
        return casoFechareg;
    }

    public void setCasoFechareg(Date casoFechareg) {
        this.casoFechareg = casoFechareg;
    }

    public double getCasoMonto() {
        return casoMonto;
    }

    public void setCasoMonto(double casoMonto) {
        this.casoMonto = casoMonto;
    }

    public int getCasoMateria() {
        return casoMateria;
    }

    public void setCasoMateria(int casoMateria) {
        this.casoMateria = casoMateria;
    }

    public String getCasoDependencia() {
        return casoDependencia;
    }

    public void setCasoDependencia(String casoDependencia) {
        this.casoDependencia = casoDependencia;
    }

    public String getCasoJuzgado() {
        return casoJuzgado;
    }

    public void setCasoJuzgado(String casoJuzgado) {
        this.casoJuzgado = casoJuzgado;
    }

    public double getCasoCuantia() {
        return casoCuantia;
    }

    public void setCasoCuantia(double casoCuantia) {
        this.casoCuantia = casoCuantia;
    }

    public int getCasoTipoproceso() {
        return casoTipoproceso;
    }

    public void setCasoTipoproceso(int casoTipoproceso) {
        this.casoTipoproceso = casoTipoproceso;
    }

     public int getCasoEstado() {
        return casoEstado;
    }

    public void setCasoEstado(int casoEstado) {
        this.casoEstado = casoEstado;
    }
    public AppCatdata getCatdata_TipoProceso() {
        return catdata_TipoProceso;
    }

    public void setCatdata_TipoProceso(AppCatdata catdata_TipoProceso) {
        this.catdata_TipoProceso = catdata_TipoProceso;
    }

    public AppCatdata getCatdata_Estado() {
        return catdata_Estado;
    }

    public void setCatdata_Estado(AppCatdata catdata_Estado) {
        this.catdata_Estado = catdata_Estado;
    }
    
    public List<AppCasoIncidencia> getAppCasoIncidencias() {
        return appCasoIncidencias;
    }

    public void setAppCasoIncidencias(List<AppCasoIncidencia> appCasoIncidencias) {
        this.appCasoIncidencias = appCasoIncidencias;
    }

    @Override
    public String toString() {
        return "AppCaso{" + "casoMonto=" + casoMonto + ", casoEstado=" + casoEstado + ", casoMateria=" + casoMateria + ", casoCuantia=" + casoCuantia + ", casoTipoproceso=" + casoTipoproceso + ", appCasoDemandanteList=" + appCasoDemandanteList + ", appCasoAbogadoList=" + appCasoAbogadoList + ", appCasoDemandadoList=" + appCasoDemandadoList + ", casoCod=" + casoCod + ", casoExped=" + casoExped + ", casoLegajo=" + casoLegajo + ", casoUsuario=" + casoUsuario + ", casoFechareg=" + casoFechareg + ", casoDependencia=" + casoDependencia + ", casoJuzgado=" + casoJuzgado + ", casoMoneda=" + casoMoneda + ", casoArchivo1=" + casoArchivo1 + ", casoArchivo2=" + casoArchivo2 + ", casoArchivo3=" + casoArchivo3 + ", appCasoIncidencias=" + appCasoIncidencias + ", catdata_Estado=" + catdata_Estado + ", catdata_TipoProceso=" + catdata_TipoProceso + ", catdata_Materia=" + catdata_Materia + '}';
    }
    
    public List<AppCasoDemandante> getAppCasoDemandanteList() {
        return appCasoDemandanteList;
    }

    public void setAppCasoDemandanteList(List<AppCasoDemandante> appCasoDemandanteList) {
        this.appCasoDemandanteList = appCasoDemandanteList;
    }
    
    public List<AppCasoAbogado> getAppCasoAbogadoList() {
        return appCasoAbogadoList;
    }

    public void setAppCasoAbogadoList(List<AppCasoAbogado> appCasoAbogadoList) {
        this.appCasoAbogadoList = appCasoAbogadoList;
    }

    public List<AppCasoDemandado> getAppCasoDemandadoList() {
        return appCasoDemandadoList;
    }

    public void setAppCasoDemandadoList(List<AppCasoDemandado> appCasoDemandadoList) {
        this.appCasoDemandadoList = appCasoDemandadoList;
    }
}
