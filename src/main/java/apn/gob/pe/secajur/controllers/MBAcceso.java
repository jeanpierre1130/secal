/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import apn.gob.pe.secajur.beans.*;
import apn.gob.pe.secajur.service.*;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Desarrollo
 */
@ManagedBean(name = "mbacceso")
public class MBAcceso implements Serializable {

    private static final Logger console = Logger.getLogger(MBAcceso.class.getName());
    private AccesoService accesoService = new AccesoServiceImpl();
    private PersonaService personaService = new PersonaServiceImpl();
    private LogService logService = new LogServiceImpl();
    AppUser appUser;
  
    public MBAcceso() {
        appUser = new AppUser();
    }
    
    public static String genera(String pwdtmp) {
       String encript = "";
        try {
            encript = DigestUtils.sha512Hex(pwdtmp);
        } catch (Exception e) {
        }
        return encript;
    }

    public String validarUsuario() {

        FacesContext context = FacesContext.getCurrentInstance();
        try {

            AppUser au = accesoService.comprobarUsuarioActivo(appUser.getUsrUsername(), appUser.getUsrPassword());
            if (au != null) {

                //VALIDA SI EL USUARIO ES ACTIVO:
                if (au.getUsrEstado() == 0) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario Desactivado", "Cuenta Deshabilitada"));
                    console.log(Level.SEVERE, "Estado 0 - Desactivado");

                } else {
                    if (au.getUsrEstado() == 9) {
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario admin", "Cuenta Administrador"));
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("s_super", true);
                        console.log(Level.SEVERE, "Estado 9 - Superadmin");
                    }
                    if (au.getUsrEstado() == 10) {
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario su-admin", "Cuenta Super-Administrador"));
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("s_super", true);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("s_superrrot", true);
                        console.log(Level.SEVERE, "Estado 9 - Superadmin");
                    }
                    audita(au);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("s_user", au);
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido al sistema", au.getAppPersona().getPerFullname()));
                    console.log(Level.SEVERE, "Ingresamos al sistema");

                }
                return "pagina_sesion";
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales incorrectas", ""));
                return "pagina_sesion";
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error del sistema", ""));
            return "pagina_sesion";
        }
    }

    private void audita(AppUser au) {
        try {
            logService.grabarLogUser("Acceso", "Ingreso al sistema", au);
        } catch (Exception e) {
        }
    }

    public String cerrarSesiones() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/secal";
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
