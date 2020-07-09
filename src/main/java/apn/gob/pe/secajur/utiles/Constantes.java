/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.utiles;

import apn.gob.pe.secajur.beans.AppUser;
import java.util.Date;
import javax.faces.context.FacesContext;

/**
 *
 * @author Desarrollo
 */
public class Constantes {

    public static final String USUARIO_USR_INCORRECTO = "Usuario Incorrecto";
    public static final String USUARIO_USR_NOEXISTE = "Usuario Incorrecto";
    public static final String USUARIO_PWD_INCORRECTO = "Contraseña Incorrecta";

    //Utiles date:
    public static final String DATE_ANIO = DateUtil.getAnio() + "";
    public static final String DATE_FECHA_FORMATO_TEXTO = DateUtil.getFecha();
    public static final Date DATE_FECHA_FORMATO_DATE = DateUtil.getFechasinformato();
    public static final Date DATE_FECHA_FORMATO_DATE1 = DateUtil.getFechaHora();

}
