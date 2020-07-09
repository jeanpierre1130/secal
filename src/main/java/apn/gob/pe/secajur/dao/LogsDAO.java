/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.dao;

import apn.gob.pe.secajur.beans.*;
import java.util.Date;
import java.util.List;

public interface LogsDAO {

    public String grabarLogUser(AppUserLog obj);

    public String grabarLogUser(String tipo, String cnt, AppUser obj);

    public List<AppUserLog> obtenrLogUser_User(int idcaso);

    public List<String> obtenrLogUser_UserString(int usuario);

    public List<Date> obtenrLogUser_UserDate(int usuario);

    public List<AppUserLog> obtenrLogUser_User_sub(int usuario, Date fecha);

    public List<AppUserLog> obtenrLogUser_User_sub2(int usuario, String fecha);

    public List<AppUserLog> obtenrFullLogUser(String fecha);

   

}
