/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import apn.gob.pe.secajur.beans.AppUserLog;
import apn.gob.pe.secajur.service.LogService;
import apn.gob.pe.secajur.service.LogServiceImpl;
import java.text.SimpleDateFormat;
import java.util.List;
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
public class TrazabilidadServiceTest {
    
    private LogService logService = new LogServiceImpl();
    
    public TrazabilidadServiceTest() {
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
    public void consultarTrazabilidad() {
        
        int idusuario = 2;
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        List<AppUserLog> loguser = logService.obtenrLogUser_User(idusuario);
        if(loguser!=null){
            System.out.println("Tipo de trazabilidad: " + loguser.get(0).getLogTipo());
            System.out.println("Accion de la trazabilidad: " + loguser.get(0).getLogAcion());
            System.out.println("Fecha de la trazabilidad: " + formateador.format(loguser.get(0).getLogData()));
        }
        
        Assert.assertNotNull(idusuario);
        
    }
}
