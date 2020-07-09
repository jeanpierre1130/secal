/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import apn.gob.pe.secajur.beans.AppUser;
import apn.gob.pe.secajur.service.AccesoService;
import apn.gob.pe.secajur.service.AccesoServiceImpl;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Desarrollo
 */
@ManagedBean(name = "mbusuario")
@SessionScoped
@RequestScoped
public class MBUsuario implements Serializable {

    private static final Logger console = Logger.getLogger(MBUsuario.class.getName());
    private final AccesoService accesoService = new AccesoServiceImpl();

    AppUser user;

    public MBUsuario() {
        user = new AppUser();
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public List<AppUser> listarUsuarios() {
        console.log(Level.INFO, "en el metodo listar");
        return accesoService.listarUsuario();
    }

}
