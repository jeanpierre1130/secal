/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.service;

import apn.gob.pe.secajur.beans.AppCatcabe;
import apn.gob.pe.secajur.beans.AppCatdata;
import apn.gob.pe.secajur.dao.CatalogoDAO;
import apn.gob.pe.secajur.dao.CatalogoDAOImpl;
import java.util.List;

/**
 *
 * @author Desarrollo
 */
public class CatalologoServiceImpl implements CatalologoService {

  
    private final CatalogoDAO dao = new CatalogoDAOImpl();

    @Override
    public List<AppCatdata> listarestadosdeCaso() {
        return dao.listarestadosdeCaso();
    }

    @Override
    public List<AppCatdata> listarTipodeprocesoDemanda() {
        return dao.listarTipodeprocesoDemanda();
    }
    
    @Override
    public List<AppCatdata> listarTipoEstado() {
        return dao.listarTipoEstado();
    }
    
    @Override
    public List<AppCatdata> listarTipoArea() {
        return dao.listarTipoArea();
    }
    
    @Override
    public List<AppCatdata> listarTipoMoneda() {
        return dao.listarTipoMoneda();
    }

    @Override
    public List<AppCatdata> listarTipoDepend() {
        return dao.listarTipoDepend();
    }
    
    @Override
    public AppCatdata obtenerSubCatalogo(int codcat) {
        return dao.obtenerSubCatalogo(codcat);
    }

    @Override
    public String grabarCatalogo(AppCatdata obj, String opcion) {
        return dao.grabarCatalogo(obj, opcion);
    }

    @Override
    public List<AppCatcabe> listarCabeceraCatalogo() {
        return dao.listarCabeceraCatalogo();
    }

    @Override
    public List<AppCatdata> listarTipodeMateria() {
        return dao.listarTipodeMateria();
    }

}
