/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.service;

import apn.gob.pe.secajur.beans.AppCaso;
import apn.gob.pe.secajur.beans.AppCasoIncidencia;
import apn.gob.pe.secajur.dao.*;
import java.util.List;

/**
 *
 * @author Desarrollo
 */
public class CasoServiceImpl implements CasoService {

    private final CasoDAO dao = new CasoDAOImpl();

    @Override
    public List<AppCaso> listarCasos() {
        return dao.listarCasos();
    }

    @Override
    public String registrarIncidencia(int idcaso, AppCasoIncidencia incidencia, String opcion) {
        return dao.registrarIncidencia(idcaso, incidencia, opcion);
    }

    @Override
    public List<AppCasoIncidencia> listarIncidencias(int idcaso) {
        return dao.listarIncidencias(idcaso);
    }

    @Override
    public String desactivarIncidencia(int idIncidencia) {
        return dao.desactivarIncidencia(idIncidencia);
    }

    @Override
    public AppCaso obtenerCaso(int code) {
        AppCaso caso=dao.obtenerCaso(code);
        return caso;
    }

    @Override
    public String grabarCaso(AppCaso obj, String opcion) {
        return dao.grabarCaso(obj, opcion);
    }

    @Override
    public AppCasoIncidencia obtenerIncidencia(int idIncidencia) {
        return dao.obtenerIncidencia(idIncidencia);
    }

    @Override
    public int obtenerIdCaso() {
        return Integer.parseInt(dao.callFunction("CASOSUAJ.TAB_APP_CASO_SEQ"));
    }
}
