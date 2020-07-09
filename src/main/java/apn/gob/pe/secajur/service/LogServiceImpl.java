/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.service;

import apn.gob.pe.secajur.beans.AppUser;
import apn.gob.pe.secajur.beans.AppUserLog;
import apn.gob.pe.secajur.dao.LogsDAO;
import apn.gob.pe.secajur.dao.LogsDAOImpl;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Desarrollo
 */
public class LogServiceImpl implements LogService {

    private final LogsDAO dao = new LogsDAOImpl();

    @Override
    public String grabarLogUser(AppUserLog obj) {
        return dao.grabarLogUser(obj);
    }

    @Override
    public String grabarLogUser(String tipo, String cnt, AppUser obj) {
        return dao.grabarLogUser(tipo, cnt, obj);
    }

    @Override
    public List<AppUserLog> obtenrLogUser_User(int idcaso) {
        return dao.obtenrLogUser_User(idcaso);
    }

    @Override
    public List<AppUserLog> obtenrLogUser_User_sub(int usuario, Date fecha) {

        return dao.obtenrLogUser_User_sub(usuario, fecha);
    }

    @Override
    public List<String> obtenrLogUser_UserString(int usuario) {
        return dao.obtenrLogUser_UserString(usuario);
    }

    @Override
    public List<Date> obtenrLogUser_UserDate(int usuario) {
        return dao.obtenrLogUser_UserDate(usuario);
    }

    @Override
    public List<AppUserLog> listaLogUsuariosub2(int usuario, String fecha) {
        return dao.obtenrLogUser_User_sub2(usuario, fecha);
    }

    @Override
    public List<AppUserLog> obtenrFullLogUser(String fecha) {
        return dao.obtenrFullLogUser(fecha);
    }

}
