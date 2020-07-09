/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.service;

import apn.gob.pe.secajur.beans.AppUser;
import java.util.List;

/**
 *
 * @author Desarrollo
 */
public interface AccesoService {

    public AppUser comprobarUsuario(String usr, String pwd);
    
    public AppUser comprobarUsuarioActivo(String usr, String pwd);

    public List<AppUser> listarUsuario();
   
}
