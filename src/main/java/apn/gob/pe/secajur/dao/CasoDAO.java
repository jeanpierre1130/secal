/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.dao;

import apn.gob.pe.secajur.beans.AppCaso;
import apn.gob.pe.secajur.beans.AppCasoAbogado;
import apn.gob.pe.secajur.beans.AppCasoIncidencia;
import java.util.List;

public interface CasoDAO {

    public List<AppCaso> listarCasos();

    public String grabarCaso(AppCaso obj, String opcion);

    public String actualizarCaso(AppCaso obj);

    public String registrarIncidencia(int idcaso, AppCasoIncidencia incidencia, String opcion);

    public List<AppCasoIncidencia> listarIncidencias(int idcaso);

    public String desactivarIncidencia(int idIncidencia);

    public AppCasoIncidencia obtenerIncidencia(int idIncidencia);

    public AppCaso obtenerCaso(int code);
    
    public List<AppCasoAbogado> obtenerDetalleCasoI(int code);
    
    public String callFunction(String namefuntion);

}
