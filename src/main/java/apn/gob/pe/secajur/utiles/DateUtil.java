/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.utiles;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author eshupingahua
 */
public class DateUtil {

    public static final String getAnio() {

        return new SimpleDateFormat("yyyy").format(new Date());
    }

    public static final String getFecha() {

        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }
    
    public static final Date getFechaHora() {

        try {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String stringdate = dt.format(new Date());
            Date date = dt.parse(stringdate);
            return date;
        } catch (Exception e) {
            return null;
        }
        
    }

    public static final Date getFechasinformato() {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(getFecha());
        } catch (Exception e) {
            return null;
        }

    }

    public static final Date getFechaFormatodate(String f1) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(getFecha());
        } catch (Exception e) {
            return null;
        }

    }

    public static int diferenciaEnDias2(Date fechaMayor, Date fechaMenor) {
        long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
        long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
        return (int) dias;
    }

    public static int diferenciaendiasdefechasTexto(Date fechaMayor, Date fechaMenor) {
        long diferenciaEn_ms = (fechaMayor).getTime() - (fechaMenor).getTime();
        long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
        return (int) dias;
    }

    public static final String getFechaTexto(Date d) {
        return new SimpleDateFormat("dd/MM/yyyy").format(d);
    }
}
