/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.dao;

import apn.gob.pe.secajur.beans.*;
import java.util.List;

public interface PersonaDAO {

    public AppPersona obtenerPersona(int code);

    public String grabarPersona(AppPersona obj, String opcion);

    public String grabarUsuario(AppPersona persona, AppUser user, String opcion);

    public List<AppUser> listarUsuarios();

    public AppUser obtenerUsuario(int id);
    
    public String callFunctionU(String namefuntion);
}
