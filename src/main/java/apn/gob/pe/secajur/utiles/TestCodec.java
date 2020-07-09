/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.utiles;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author eshupingahua
 */
public class TestCodec {

    public static void main(String[] args) throws NoSuchAlgorithmException {
      String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha512Hex("demo"); 
       
        System.out.println(sha256hex);
    }

}
