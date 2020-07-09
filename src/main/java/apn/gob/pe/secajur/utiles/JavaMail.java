/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.utiles;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Desarrollo
 */
public class JavaMail {

    public boolean SendMail(String para, String titulo, String cuerpo) throws UnsupportedEncodingException {
        boolean stateMail = false;
        GestSesion sesionusuario = new GestSesion();
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "10.0.0.84");
        props.put("mail.smtp.user", "sistemas@apn.gob.pe");
        props.put("mail.smtp.port", 25);
        props.put("mail.smtp.auth", "false");
        Authenticator auth = new SMTPAuthenticator("redenaves2@apn.gob.pe", "@rr1b0C0nd!c!on@l");
        Session session = Session.getInstance(props, auth);
        try{
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(props.getProperty("mail.smtp.user"));
        msg.setSubject(titulo, "UTF-8");
        msg.setContent(cuerpo, "text/html; charset=utf-8");
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
        try {
                Transport.send(msg);
                stateMail = true;
            } catch (Exception e) {
                stateMail = false;
                e.printStackTrace();
            }
        }
        catch(MessagingException e){
            e.printStackTrace();
            stateMail = false;
            throw new RuntimeException(e);
        }finally {
            return stateMail;
        } 
        
    }
}
