/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.controllers;

import apn.gob.pe.secajur.service.LogService;
import apn.gob.pe.secajur.service.LogServiceImpl;
import apn.gob.pe.secajur.utiles.GestSesion;
import apn.gob.pe.secajur.utiles.JavaMail;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author consultor.oti3
 */
@ManagedBean(name = "mbmail")
@SessionScoped
@ViewScoped
public class MBMail implements Serializable {

    private LogService logService = new LogServiceImpl();

    private String _cabecera = "[SECAL] Copia de Caso Enviado";
    private String _cuerpo = "Estimado, se adjunta la copia del caso para su conocimiento: ";
    GestSesion sesionusuario = new GestSesion();
    private String _para = sesionusuario.obtenerUsuarioSesion().getAppPersona().getPerEmail();

    private static final Logger console = Logger.getLogger(MBMail.class.getName());

    public void enviarCorreo(String titulo, String cuerpo, String id) {

        if (_para.isEmpty() || !_para.contains("@")) {
            alertaError("Ingrese correctamete la direccion de correo electrónico");
        } else {

            try {

                cuerpo = html.replace("@CUERPO@", cuerpo).replace("@URLAVISO@", "http://10.0.0.35:8280/secal/ui/caso_imprimir_public.xhtml?printcase=" + id + UUID.randomUUID().toString().toUpperCase());
                JavaMail maile = new JavaMail();
                if (maile.SendMail(_para, titulo, cuerpo) == true) {
                    alertaOk("Correo enviado");
                    
                    logService.grabarLogUser("Correo", "El usuario " + sesionusuario.obtenerUsuarioSesion().getAppPersona().getPerFullname() + " envió una copia a la direccion " + _para, sesionusuario.obtenerUsuarioSesion());
                    _para = "";
                } else {
                    alertaError("No se pudo reaizar el envío");
                }
            } catch (Exception e) {
                alertaError("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    public String getPara() {
        return _para;
    }

    public void setPara(String _para) {
        this._para = _para;
    }

    public void alertaOk(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void alertaError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getCabecera() {
        return _cabecera;
    }

    public void setCabecera(String _cabecera) {
        this._cabecera = _cabecera;
    }

    public String getCuerpo() {
        return _cuerpo;
    }

    public void setCuerpo(String _cuerpo) {
        this._cuerpo = _cuerpo;
    }

    private String html = "<!DOCTYPE html>\n"
            + "<html>\n"
            + "<head>\n"
            + "<title></title>\n"
            + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
            + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
            + "<style type=\"text/css\">\n"
            + "    /* FONTS */\n"
            + "    @media screen {\n"
            + "        @font-face {\n"
            + "          font-family: 'Lato';\n"
            + "          font-style: normal;\n"
            + "          font-weight: 400;\n"
            + "          src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');\n"
            + "        }\n"
            + "        \n"
            + "        @font-face {\n"
            + "          font-family: 'Lato';\n"
            + "          font-style: normal;\n"
            + "          font-weight: 700;\n"
            + "          src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');\n"
            + "        }\n"
            + "        \n"
            + "        @font-face {\n"
            + "          font-family: 'Lato';\n"
            + "          font-style: italic;\n"
            + "          font-weight: 400;\n"
            + "          src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');\n"
            + "        }\n"
            + "        \n"
            + "        @font-face {\n"
            + "          font-family: 'Lato';\n"
            + "          font-style: italic;\n"
            + "          font-weight: 700;\n"
            + "          src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');\n"
            + "        }\n"
            + "    }\n"
            + "    \n"
            + "    /* CLIENT-SPECIFIC STYLES */\n"
            + "    body, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }\n"
            + "    table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; }\n"
            + "    img { -ms-interpolation-mode: bicubic; }\n"
            + "\n"
            + "    /* RESET STYLES */\n"
            + "    img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; }\n"
            + "    table { border-collapse: collapse !important; }\n"
            + "    body { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; }\n"
            + "\n"
            + "    /* iOS BLUE LINKS */\n"
            + "    a[x-apple-data-detectors] {\n"
            + "        color: inherit !important;\n"
            + "        text-decoration: none !important;\n"
            + "        font-size: inherit !important;\n"
            + "        font-family: inherit !important;\n"
            + "        font-weight: inherit !important;\n"
            + "        line-height: inherit !important;\n"
            + "    }\n"
            + "    \n"
            + "    /* MOBILE STYLES */\n"
            + "    @media screen and (max-width:600px){\n"
            + "        h1 {\n"
            + "            font-size: 32px !important;\n"
            + "            line-height: 32px !important;\n"
            + "        }\n"
            + "    }\n"
            + "\n"
            + "    /* ANDROID CENTER FIX */\n"
            + "    div[style*=\"margin: 16px 0;\"] { margin: 0 !important; }\n"
            + "</style>\n"
            + "\n"
            + "<style type=\"text/css\">\n"
            + "\n"
            + "</style>\n"
            + "</head>\n"
            + "<body style=\"background-color: #f4f4f4; margin: 0 !important; padding: 0 !important;\">\n"
            + "\n"
            + "<!-- HIDDEN PREHEADER TEXT -->\n"
            + "<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\n"
            + "    We've added a ton of features to your account. Check out the biggest changes below or log in to view them all.\n"
            + "</div>\n"
            + "\n"
            + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
            + "    <!-- LOGO -->\n"
            + "    <tr>\n"
            + "        <td bgcolor=\"#f4f4f4\" align=\"center\">\n"
            + "            <!--[if (gte mso 9)|(IE)]>\n"
            + "            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\">\n"
            + "            <tr>\n"
            + "            <td align=\"center\" valign=\"top\" width=\"600\">\n"
            + "            <![endif]-->\n"
            + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\" >\n"
            + "                <tr>\n"
            + "                    <td align=\"center\" valign=\"top\" style=\"padding: 20px 10px 20px 10px;\">\n"
            + "                      \n"
            + "                    </td>\n"
            + "                </tr>\n"
            + "            </table>\n"
            + "            <!--[if (gte mso 9)|(IE)]>\n"
            + "            </td>\n"
            + "            </tr>\n"
            + "            </table>\n"
            + "            <![endif]-->\n"
            + "        </td>\n"
            + "    </tr>\n"
            + "    <!-- HERO -->\n"
            + "    \n"
            + "    <!-- COPY BLOCK -->\n"
            + "    <tr>\n"
            + "        <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n"
            + "            <!--[if (gte mso 9)|(IE)]>\n"
            + "            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\">\n"
            + "            <tr>\n"
            + "            <td align=\"center\" valign=\"top\" width=\"600\">\n"
            + "            <![endif]-->\n"
            + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\" >\n"
            + "              <!-- COPY -->\n"
            + "             \n"
            + "             <img src=\"https://eredenaves.apn.gob.pe/imagenes/logo-apn.gif\"/>\n"
            + "             \n"
            + "             \n"
            + "             \n"
            + "              <tr>\n"
            + "                <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 20px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 25px;\" >\n"
            + "                  <p style=\"margin: 0;\">@CUERPO@ </p>\n"
            + "                </td>\n"
            + "              </tr>\n"
            + "                  <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 25px;\" >\n"
            + "                    <p style=\"margin: 0;\"><a href=\"@URLAVISO@\" target=\"_blank\" style=\"color: #539be2;\">Seleccionar aquí para ver la información del caso</a></p>\n"
            + "                  </td>\n"
            + "                </tr>\n"
            + "               \n"
            + "               <tr>\n"
            + "                <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 30px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 18px;\" >\n"
            + "                    <p style=\"margin: 0;\"> <b>Autoridad Portuaria Nacional.</b> </p>\n"
            + "                </td>\n"
            + "              </tr>\n"
            + "            </table>\n"
            + "            <!--[if (gte mso 9)|(IE)]>\n"
            + "            </td>\n"
            + "            </tr>\n"
            + "            </table>\n"
            + "            <![endif]-->\n"
            + "        </td>\n"
            + "    </tr>\n"
            + "    \n"
            + "    \n"
            + "   \n"
            + "   \n"
            + "</table>\n"
            + "\n"
            + "</body>\n"
            + "</html>";

    private void leerArchivo() {
        try {

            /**
             * Creamos un Objeto de tipo Properties
             */
            Properties propiedades = new Properties();

            /**
             * Cargamos el archivo desde la ruta especificada
             */
            propiedades.load(new FileInputStream(""));

            /**
             * Obtenemos los parametros definidos en el archivo
             */
            String nombre = propiedades.getProperty("nombre");
            String pagina = propiedades.getProperty("pagina");

            /**
             * Imprimimos los valores
             */
            System.out.println("Nombre: " + nombre + "\n" + "Pagina: " + pagina);

        } catch (FileNotFoundException e) {
            System.out.println("Error, El archivo no exite");
        } catch (IOException e) {
            System.out.println("Error, No se puede leer el archivo");
        }
    }

}
