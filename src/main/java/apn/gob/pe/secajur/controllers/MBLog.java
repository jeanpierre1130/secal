/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import apn.gob.pe.secajur.beans.AppUserLog;
import apn.gob.pe.secajur.service.LogService;
import apn.gob.pe.secajur.service.LogServiceImpl;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jean Pierre
 */
@ManagedBean(name = "mblog")
public class MBLog implements Serializable {

    private LogService logService = new LogServiceImpl();

    /**
     * Creates a new instance of MBLog
     */
    public MBLog() {
    }

    public List<AppUserLog> listaLogUsuario(int usuario) {
        return logService.obtenrLogUser_User(usuario);
    }

    public List<AppUserLog> listaLogUsuariosub(int usuario, Date fecha) {
        return logService.obtenrLogUser_User_sub(usuario, fecha);
    }

    public List<AppUserLog> listaLogUsuariosub2(int usuario, String fecha) {
        return logService.listaLogUsuariosub2(usuario, fecha);
    }

    public List<String> listaLogUsuariobydata(int usuario) {
        return logService.obtenrLogUser_UserString(usuario);
    }

    public List<Date> listaLogUsuarioFecha(int usuario) {
        return logService.obtenrLogUser_UserDate(usuario);
    }

    public List<AppUserLog> listaLogUsuarioFechafull(String fecha) {
        return logService.obtenrFullLogUser(fecha);
    }

}
