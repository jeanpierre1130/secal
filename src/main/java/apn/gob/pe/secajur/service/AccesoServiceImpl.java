/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.service;

import apn.gob.pe.secajur.dao.AccesoDAO;
import apn.gob.pe.secajur.dao.AccesoDAOImpl;
import apn.gob.pe.secajur.beans.AppUser;
import java.util.List;

/**
 *
 * @author Desarrollo
 */
public class AccesoServiceImpl implements AccesoService {

    private final AccesoDAO dao = new AccesoDAOImpl();

    @Override
    public AppUser comprobarUsuario(String usr, String pwd) {
        return dao.comprobarUsuario(usr, pwd);
    }

    @Override
    public AppUser comprobarUsuarioActivo(String usr, String pwd) { 
        return dao.comprobarUsuarioActivo(usr, pwd);
    }

    @Override
    public List<AppUser> listarUsuario() {
        return dao.listarUsuario();
    }

}
