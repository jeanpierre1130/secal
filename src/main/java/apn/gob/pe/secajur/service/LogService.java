/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.service;

import apn.gob.pe.secajur.beans.AppUser;
import apn.gob.pe.secajur.beans.AppUserLog;
import java.util.Date;
import java.util.List;

/**
 *
 * @author eshupingahua
 */
public interface LogService {

    public String grabarLogUser(String tipo, String cnt, AppUser obj);

    public String grabarLogUser(AppUserLog obj);

    public List<AppUserLog> obtenrLogUser_User(int idcaso);

    public List<AppUserLog> obtenrLogUser_User_sub(int usuario, Date fecha);
     
    
    public List<AppUserLog> listaLogUsuariosub2(int usuario, String fecha);

    public List<Date> obtenrLogUser_UserDate(int usuario);

    public List<String> obtenrLogUser_UserString(int usuario);
    public List<AppUserLog> obtenrFullLogUser(String fecha);
}
