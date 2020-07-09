/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author consultor.oti3
 */
@Entity
@Table(name = "APP_CATDATA", catalog = "", schema = "CASOSUAJ")
@NamedQueries({
    @NamedQuery(name = "AppCatdata.findAll", query = "SELECT a FROM AppCatdata a"),
    @NamedQuery(name = "AppCatdata.obtenerEstadosdeCaso", query = "SELECT A FROM AppCatdata A join A.catCabe B where  B.catCabe = 'B'    ")/*a.catDetaestado=1 */,
    @NamedQuery(name = "AppCatdata.obtenerTipodesrpocesodeCaso", query = "SELECT A FROM AppCatdata A join A.catCabe B where  B.catCabe = 'C'  ")/*a.catDetaestado=1 */,
    @NamedQuery(name = "AppCatdata.obtenerTipodeMateria", query = "SELECT A FROM AppCatdata A join A.catCabe B where  B.catCabe = 'E'  ")/*a.catDetaestado=1 */,
    @NamedQuery(name = "AppCatdata.obtenerTipoDepend", query = "SELECT A FROM AppCatdata A join A.catCabe B where  B.catCabe = 'P'  ")/*a.catDetaestado=1 */,
    @NamedQuery(name = "AppCatdata.obtenerTipoArea", query = "SELECT A FROM AppCatdata A join A.catCabe B where  B.catCabe = 'H'  ")/*a.catDetaestado=1 */,
    @NamedQuery(name = "AppCatdata.obtenerTipoMoneda", query = "SELECT A FROM AppCatdata A join A.catCabe B where  B.catCabe = 'M'  ")/*a.catDetaestado=1 */,
    @NamedQuery(name = "AppCatdata.obtenerTipoEstado", query = "SELECT A FROM AppCatdata A join A.catCabe B where  B.catCabe = 'A'  ")/*a.catDetaestado=1 */,
    @NamedQuery(name = "AppCatdata.obtenerSubCatalgo", query = "SELECT a FROM AppCatdata a where a.codCat =:codcat"),})
public class AppCatdata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CATALOGO", nullable = false)
    private int codCat;
    @Size(max = 6)
    @Column(name = "CAT_DETACATALOGO", length = 6)
    private String catDeta;
    @Size(max = 200)
    @Column(name = "CAT_DETADESCRIPCION", length = 200)
    private String catDetadesc;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAT_ESTADO", nullable = false)
    private int catDetaestado;
    
    @Column(name = "CAT_ESTILO", length = 30)
    private String catDetaStyle;
       
    @Column(name = "CAT_FORMATO")
    private String catDetaformato;

    @JoinColumn(name = "CAT_CABECERA", referencedColumnName = "CAT_CABECERA", nullable = false)
    @ManyToOne(optional = false)
    private AppCatcabe catCabe;
    
    @OneToMany(mappedBy = "catdata_TipoProceso")
    private List<AppCaso> appCasos_TipoProceso;
    @OneToMany(mappedBy = "catdata_Estado")
    private List<AppCaso> appCasos_estado;

    public AppCatdata() {
    }

    public AppCatdata(int codCat) {
        this.codCat = codCat;
    }
    
    public int getCodCat() {
        return codCat;
    }

    public void setCodCat(int codCat) {
        this.codCat = codCat;
    }

    public String getCatDeta() {
        return catDeta;
    }

    public void setCatDeta(String catDeta) {
        this.catDeta = catDeta;
    }

    public String getCatDetadesc() {
        return catDetadesc;
    }

    public void setCatDetadesc(String catDetadesc) {
        this.catDetadesc = catDetadesc;
    }

    public String getCatDetaformato() {
        return catDetaformato;
    }

    public void setCatDetaformato(String catDetaformato) {
        this.catDetaformato = catDetaformato;
    }
    
    public AppCatcabe getCatCabe() {
        return catCabe;
    }

    public void setCatCabe(AppCatcabe catCabe) {
        this.catCabe = catCabe;
    }

    public int getCatDetaestado() {
        return catDetaestado;
    }

    public void setCatDetaestado(int catDetaestado) {
        this.catDetaestado = catDetaestado;
    }

    public String getCatDetaStyle() {
        return catDetaStyle;
    }

    public void setCatDetaStyle(String catDetaStyle) {
        this.catDetaStyle = catDetaStyle;
    }

    public List<AppCaso> getAppCasos_TipoProceso() {
        return appCasos_TipoProceso;
    }

    public void setAppCasos_TipoProceso(List<AppCaso> appCasos_TipoProceso) {
        this.appCasos_TipoProceso = appCasos_TipoProceso;
    }

    public List<AppCaso> getAppCasos_estado() {
        return appCasos_estado;
    }

    public void setAppCasos_estado(List<AppCaso> appCasos_estado) {
        this.appCasos_estado = appCasos_estado;
    }

    @Override
    public String toString() {
        return "AppCatdata{" + "codCat=" + codCat + ", catDeta=" + catDeta + ", catDetadesc=" + catDetadesc + '}';
    }
}
