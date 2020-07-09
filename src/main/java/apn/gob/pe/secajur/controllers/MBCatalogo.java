/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import apn.gob.pe.secajur.beans.AppCatdata;
import apn.gob.pe.secajur.service.*;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Desarrollo
 */
@ManagedBean(name = "mbcatalogo")
@ViewScoped
public class MBCatalogo implements Serializable {

    private static final Logger console = Logger.getLogger(MBCatalogo.class.getName());
    private CatalologoService catalologoService = new CatalologoServiceImpl();

    private AppCatdata appCatdata;
    List<AppCatdata> selectDistrtitos;
    List<AppCatdata> SelectProvincias;
    String codDepto;
    String codProvc;
    String codDistrito;

    /**
     * Creates a new instance of MBCatalogo
     */
    public MBCatalogo() {
    }

    public AppCatdata getAppCatdata() {
        return appCatdata;
    }

    public void setAppCatdata(AppCatdata appCatdata) {
        this.appCatdata = appCatdata;
    }

    public List<AppCatdata> listarestadosdeCaso() {
        return catalologoService.listarestadosdeCaso();
    }

    public List<AppCatdata> listartipoprocesodeCaso() {
        return catalologoService.listarTipodeprocesoDemanda();
    }

    public List<AppCatdata> listartipoMoneda() {
        return catalologoService.listarTipoMoneda();
    }
    
    public List<AppCatdata> listartipoDepend() {
        return catalologoService.listarTipoDepend();
    }
    
    public List<AppCatdata> listartipoEstado() {
        return catalologoService.listarTipoEstado();
    }
    
    public List<AppCatdata> listartipoArea() {
        return catalologoService.listarTipoArea();
    }
    
    public List<AppCatdata> listarTipodeMateria() {
        return catalologoService.listarTipodeMateria();
    }
}