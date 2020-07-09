/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.dao;

import apn.gob.pe.secajur.beans.*;
import java.util.List;

public interface CatalogoDAO {

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
