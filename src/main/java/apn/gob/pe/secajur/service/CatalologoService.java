/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.service;

import apn.gob.pe.secajur.beans.AppCatcabe;
import apn.gob.pe.secajur.beans.AppCatdata;
import java.util.List;

/**
 *
 * @author Desarrollo
 */
public interface CatalologoService {

    public List<AppCatdata> listarestadosdeCaso();

    public List<AppCatdata> listarTipodeprocesoDemanda();
    
    public List<AppCatdata> listarTipoMoneda();

    public List<AppCatdata> listarTipoDepend();
    
    public List<AppCatdata> listarTipoEstado();
    
    public List<AppCatdata> listarTipoArea();
    
    public List<AppCatdata> listarTipodeMateria();

    public AppCatdata obtenerSubCatalogo(int codcat);

    public List<AppCatcabe> listarCabeceraCatalogo();

    public String grabarCatalogo(AppCatdata obj, String opcion);

}
