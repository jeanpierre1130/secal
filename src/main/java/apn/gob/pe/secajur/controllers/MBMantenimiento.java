/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import apn.gob.pe.secajur.beans.*;
import apn.gob.pe.secajur.service.*;
import apn.gob.pe.secajur.utiles.Constantes;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import static org.apache.log4j.lf5.viewer.LogTableColumn.LEVEL;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 *
 */
@ViewScoped
@SessionScoped
@ManagedBean(name = "mbmantenimiento")
public class MBMantenimiento implements Serializable {

    /**
     * Creates a new instance of MBMantenimiento
     */
    private static final Logger console = Logger.getLogger(MBMantenimiento.class.getName());
    public List<AppCatdata> appTipodeDoc_View;
    public List<AppCatdata> appviaProc_View;
    public List<AppCatdata> appTipoProceso_View;
    public List<AppCatdata> appEstadoProceo_View;

    private CatalologoService catalologoService = new CatalologoServiceImpl();
    private PersonaService personaService = new PersonaServiceImpl();
    private AppCatdata appCatdata_nuevo;
    private List<AppCatcabe> appCatcabes;
    private LogService logService = new LogServiceImpl();
    private AppUser appUserLog;

    private AppUser appUser_edit;
    private AppPersona appPersona_edit;
    private String password_edit;
    private boolean btn_edit = false;
    private boolean btn_edit_new = true;
    private String opcion_save;

    public MBMantenimiento() {

        appviaProc_View = catalologoService.listarTipodeMateria();
        appTipoProceso_View = catalologoService.listarTipodeprocesoDemanda();
        appEstadoProceo_View = catalologoService.listarestadosdeCaso();
        appUserLog = (AppUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("s_user");
        appUser_edit = new AppUser();
        appPersona_edit = new AppPersona();
    }

    public void grabarCatalogo(String opcion) {
        console.log(Level.WARNING, " NUEVA DATA: " + appCatdata_nuevo.getCatDetadesc());

        FacesMessage msg;
        try {
            msg = new FacesMessage(personaService.grabarUsuario(appPersona_edit, appUserLog, opcion));

        } catch (Exception e) {
            msg = new FacesMessage("Error contro: " + e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public List<AppCatcabe> obtenerCabeceras() {
        return catalologoService.listarCabeceraCatalogo();
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg;
        try {
            msg = new FacesMessage(catalologoService.grabarCatalogo(((AppCatdata) event.getObject()), "U"));
            logService.grabarLogUser("Catálogo", "Actualización de Catálogo ", appUserLog);

        } catch (Exception e) {
            msg = new FacesMessage("Error contro: " + e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public List<AppCatdata> getAppTipodeDoc_View() {
        return appTipodeDoc_View;
    }

    public void setAppTipodeDoc_View(List<AppCatdata> appTipodeDoc_View) {
        this.appTipodeDoc_View = appTipodeDoc_View;
    }

    public List<AppCatdata> getAppviaProc_View() {
        return appviaProc_View;
    }

    public void setAppviaProc_View(List<AppCatdata> appviaProc_View) {
        this.appviaProc_View = appviaProc_View;
    }

    public List<AppCatdata> getAppTipoProceso_View() {
        return appTipoProceso_View;
    }

    public void setAppTipoProceso_View(List<AppCatdata> appTipoProceso_View) {
        this.appTipoProceso_View = appTipoProceso_View;
    }

    public List<AppCatdata> getAppEstadoProceo_View() {
        return appEstadoProceo_View;
    }

    public void setAppEstadoProceo_View(List<AppCatdata> appEstadoProceo_View) {
        this.appEstadoProceo_View = appEstadoProceo_View;
    }

    public AppCatdata getAppCatdata_nuevo() {
        return appCatdata_nuevo;
    }

    public void setAppCatdata_nuevo(AppCatdata appCatdata_nuevo) {
        this.appCatdata_nuevo = appCatdata_nuevo;
    }

    public List<AppCatcabe> getAppCatcabes() {
        return appCatcabes;
    }

    public void setAppCatcabes(List<AppCatcabe> appCatcabes) {
        this.appCatcabes = appCatcabes;
    }

    public AppUser getAppUser_edit() {
        return appUser_edit;
    }

    public void setAppUser_edit(AppUser appUser_edit) {
        this.appUser_edit = appUser_edit;
    }

    public AppPersona getAppPersona_edit() {
        return appPersona_edit;
    }

    public void setAppPersona_edit(AppPersona appPersona_edit) {
        this.appPersona_edit = appPersona_edit;
    }

    public String getPassword_edit() {
        return password_edit;
    }

    public void setPassword_edit(String password_edit) {
        this.password_edit = password_edit;
    }

    //SUPER USER 
    public List<AppUser> listarUsuarios() {
        return personaService.listarUsuarios();
    }

    public String obtenerUsuario(int id) {

        appUser_edit = personaService.obtenerUsuario(id);
        appPersona_edit = appUser_edit.getAppPersona();
        

        console.log(Level.SEVERE, appUser_edit.getUsrUsername() + "----" + appPersona_edit.getPerFullname());
        btn_edit = true;
        btn_edit_new = true;

        opcion_save = "U"; //CAMBIAMOS AL ESTADO DE UPDATE
        return "superadmin_gestuser";
    }

    public String nuevoUsuario() {
        //appUser_edit = null;
        appUser_edit = new AppUser();

        // appPersona_edit = null;
        appPersona_edit = new AppPersona();
        appUser_edit = new AppUser();
        console.log(Level.SEVERE, "Registrando nuevo usuario");
        btn_edit = true;
        btn_edit_new = false;
        opcion_save = "I"; //CAMBIAMOS AL ESTADO DE INSERT
        return "superadmin_gestuser";
    }

    public String grabarUsuario() {
        String msg = null;
        appUser_edit.setUsrPassword("******");
        Date date = new Date();
        appUser_edit.setUsrFechareg(date);
        if (appPersona_edit.getPerFullname().isEmpty() || appPersona_edit.getPerFullname().length() <= 5) {
            msg = "Ingresa el nombre completo";
        } else if (appPersona_edit.getPerEmail().isEmpty()) {
            msg = "Ingresa el correo electrónico";
        } else if (appPersona_edit.getPerArea().isEmpty()) {
            msg = "Ingresa el área de trabajo del usuario";
        } else if (opcion_save.equals("I")) {
            if (appUser_edit.getUsrUsername().isEmpty()) {
                msg = "Ingresa el usuario";
            } else if (appUser_edit.getUsrPassword().isEmpty()) {
                msg = "Ingresa la contraseña";
            } else {
                int idtmp2 = personaService.obtenerIdPersona();
                appPersona_edit.setPerId(idtmp2);
                appPersona_edit.setPerDoctipo("DNI");
                appPersona_edit.setPerTipo("12345");
                appPersona_edit.setPerNumdoc("1234567");
                appPersona_edit.setPerImgURL("http://eurogestionesparedes.com/wp-content/uploads/2015/10/judge1-128x128.png");
                appUser_edit.setAppPersona(appPersona_edit);
                appUser_edit.setUsrId(idtmp2);   
              
                try {
                    msg = personaService.grabarUsuario(appPersona_edit, appUser_edit, opcion_save);
                    btn_edit = false;
                    btn_edit_new = true;
                    console.log(Level.SEVERE, "GRABAR DATA");
                } catch (Exception e) {
                    msg = "Error: " + e.getMessage();
                }

            }
        } else {
            try {
                msg = personaService.grabarUsuario(appPersona_edit, appUser_edit, opcion_save);
                btn_edit = false;
                btn_edit_new = true;
                console.log(Level.SEVERE, "GRABAR DATA");
            } catch (Exception e) {
                msg = "Error: " + e.getMessage();
            }

        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
        return "superadmin_gestuser";
    }

    public boolean isBtn_edit() {
        return btn_edit;
    }

    public void setBtn_edit(boolean btn_edit) {
        this.btn_edit = btn_edit;
    }

    public boolean isBtn_edit_new() {
        return btn_edit_new;
    }

    public void setBtn_edit_new(boolean btn_edit_new) {
        this.btn_edit_new = btn_edit_new;
    }

}
