/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import apn.gob.pe.secajur.beans.AppUser;
import apn.gob.pe.secajur.service.AccesoService;
import apn.gob.pe.secajur.service.AccesoServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author consultor.oti3
 */
public class AuthenticationServiceTest {
    
    private AccesoService accesoService = new AccesoServiceImpl();
    
    public AuthenticationServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    @Ignore
    public void comprobarUsuarioActivo() {
        String user = "adminrd";
        String pwd = "Linkin22";
        AppUser usuario = accesoService.comprobarUsuarioActivo(user, pwd);
        if(usuario!=null){
            System.out.println("Nombre del usuario comprobado: " + usuario.getUsrUsername());
        }
        Assert.assertNotNull(usuario);
        
    }
    
}
