/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import apn.gob.pe.secajur.beans.AppCaso;
import apn.gob.pe.secajur.beans.AppCasoDemandante;
import apn.gob.pe.secajur.beans.AppCasoDemandantePK;
import apn.gob.pe.secajur.service.CasoService;
import apn.gob.pe.secajur.service.CasoServiceImpl;
import java.util.ArrayList;
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
public class CasoDemandanteTest {
    
    private CasoService casoService = new CasoServiceImpl();
    
    public CasoDemandanteTest() {
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
    public void registrarDemandantes(){
        try {
            AppCaso caso = new AppCaso();
            List<AppCasoDemandante> appCasoDemandanteList = new ArrayList<>();
            AppCasoDemandante appdemandante = new AppCasoDemandante();
            AppCasoDemandantePK appCasoDemandantePK = new AppCasoDemandantePK();
            appCasoDemandantePK.setCasoDemandante("Jorge Luis Borgues");
            appCasoDemandantePK.setCasoCod(12);
            appdemandante.setAppCasoDemandantePK(appCasoDemandantePK);
            appCasoDemandanteList.add(appdemandante);
            caso.setAppCasoDemandanteList(appCasoDemandanteList);
            casoService.grabarCaso(caso, "I");
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail("Error fatal al grabar: "+ e.getMessage());
        }  
    }
}
