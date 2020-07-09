/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.service;

import apn.gob.pe.secajur.beans.AppPersona;
import apn.gob.pe.secajur.beans.AppUser;
import java.util.List;

/**
 *
 * @author eshupingahua
 */
public interface PersonaService {

    public AppPersona obtenerPersona(int code);

    public String grabarPersona(AppPersona obj, String opcion);

    public String grabarUsuario(AppPersona persona, AppUser user, String opcion);

    public List<AppUser> listarUsuarios();

    public AppUser obtenerUsuario(int id);
    
    public int obtenerIdPersona(); 
    
}
