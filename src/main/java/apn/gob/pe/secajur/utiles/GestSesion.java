/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.utiles;

import apn.gob.pe.secajur.beans.AppUser;
import javax.faces.context.FacesContext;

/**
 *
 * @author eshupingahua
 */
public class GestSesion {

    public AppUser obtenerUsuarioSesion() {
        return (AppUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("s_user");
    }

}
