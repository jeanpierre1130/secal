/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.service;

import apn.gob.pe.secajur.beans.AppPersona;
import apn.gob.pe.secajur.beans.AppUser;
import apn.gob.pe.secajur.dao.PersonaDAO;
import apn.gob.pe.secajur.dao.PersonaDAOImpl;
import java.util.List;

/**
 *
 * @author Desarrollo
 */
public class PersonaServiceImpl implements PersonaService {

    private final PersonaDAO dao = new PersonaDAOImpl();

    @Override
    public AppPersona obtenerPersona(int code) {
        return dao.obtenerPersona(code);
    }

    @Override
    public String grabarPersona(AppPersona obj, String opcion) {
        return dao.grabarPersona(obj, opcion);
    }

    @Override
    public String grabarUsuario(AppPersona persona, AppUser user, String opcion) {
        return dao.grabarUsuario(persona, user, opcion);
    }

    @Override
    public List<AppUser> listarUsuarios() {
        return dao.listarUsuarios();
    }

    @Override
    public AppUser obtenerUsuario(int id) {
        return dao.obtenerUsuario(id);
    }
    
    @Override
    public int obtenerIdPersona() {
        return Integer.parseInt(dao.callFunctionU("CASOSUAJ.APP_USER_SEQ"));
    }
}
