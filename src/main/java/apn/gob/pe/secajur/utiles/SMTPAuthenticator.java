/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.utiles;

import javax.mail.PasswordAuthentication;

/**
 *
 * @author consultor.oti3
 */
public class SMTPAuthenticator extends javax.mail.Authenticator{
    
    private String username;
    private String password;

    public SMTPAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(username, password);
    } 
}
