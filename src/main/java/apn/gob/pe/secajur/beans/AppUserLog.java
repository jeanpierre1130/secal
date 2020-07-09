/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "APP_USER_LOG", catalog = "", schema = "CASOSUAJ")
@NamedQueries({
    @NamedQuery(name = "AppUserLog.findAll", query = "SELECT a FROM AppUserLog a"),
    @NamedQuery(name = "AppUserLog.findByLogId", query = "SELECT a FROM AppUserLog a WHERE a.logId = :logId"),
    @NamedQuery(name = "AppUserLog.findByLogData", query = "SELECT a FROM AppUserLog a WHERE a.logData = :logData"),
    @NamedQuery(name = "AppUserLog.findByLogAcion", query = "SELECT a FROM AppUserLog a WHERE a.logAcion = :logAcion"),
    @NamedQuery(name = "AppUserLog.findByLogTipo", query = "SELECT a FROM AppUserLog a WHERE a.logTipo = :logTipo"),
    @NamedQuery(name = "AppUserLog.obtenerLogUser", query = "SELECT a FROM AppUserLog a WHERE a.appUser.usrId = :user ORDER BY a.logId DESC  "),
    @NamedQuery(name = "AppUserLog.obtenerLogUserString", query = "SELECT  a FROM AppUserLog a WHERE a.appUser.usrId = :user ORDER BY a.logData DESC"),
    @NamedQuery(name = "AppUserLog.obtenerLogUserStringdate", query = "SELECT    distinct CONCAT('',a.logData)     FROM AppUserLog a WHERE a.appUser.usrId = :user  group by  a.logData ORDER BY a.logData DESC"),
    @NamedQuery(name = "AppUserLog.obtenerLogUserFecha", query = "SELECT a FROM AppUserLog a WHERE a.appUser.usrId = :user and substring(a.logData,0,8) = :dat  ORDER BY a.logData DESC  "),
    @NamedQuery(name = "AppUserLog.obtenerFullLogUserFecha", query = "SELECT a FROM AppUserLog a WHERE  substring(a.logData,0,8) = :dat  ORDER BY a.logData DESC  ")})
public class AppUserLog implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_USER_LOG_SEQ")
    @SequenceGenerator(name = "APP_USER_LOG_SEQ", sequenceName = "APP_USER_LOG_SEQ", allocationSize = 1)
    @Column(name = "LOG_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal logId;
    
    @Column(name = "LOG_FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logData;
    
    @Column(name = "LOG_ACCION", length = 1000)
    private String logAcion;
    
    @Column(name = "LOG_TIPO", length = 1000)
    private String logTipo;
    
    @JoinColumn(name = "USR_ID", referencedColumnName = "USR_ID", nullable = false)
    @ManyToOne(optional = false)
    private AppUser appUser;

    public AppUserLog() {
    }

    public AppUserLog(BigDecimal logId) {
        this.logId = logId;
    }

    public BigDecimal getLogId() {
        return logId;
    }

    public void setLogId(BigDecimal logId) {
        this.logId = logId;
    }

    public Date getLogData() {
        return logData;
    }

    public void setLogData(Date logData) {
        this.logData = logData;
    }

    public String getLogAcion() {
        return logAcion;
    }

    public void setLogAcion(String logAcion) {
        this.logAcion = logAcion;
    }

    public String getLogTipo() {
        return logTipo;
    }

    public void setLogTipo(String logTipo) {
        this.logTipo = logTipo;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public String toString() {
        return "apn.gob.pe.secajur.beans.AppUserLog[ logId=" + logId + " ]";
    }
    
}
