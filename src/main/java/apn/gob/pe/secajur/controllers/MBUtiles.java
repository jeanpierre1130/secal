/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import apn.gob.pe.secajur.utiles.Constantes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Desarrollo
 */
@ManagedBean(name = "mbutiles")
public class MBUtiles {
    private static final Logger console = Logger.getLogger(MBUtiles.class.getName());

    public String getanio() {
        return Constantes.DATE_ANIO.substring(0, 3);
    }

    public String getaniocompleto() {
        return Constantes.DATE_ANIO;
    }
}
