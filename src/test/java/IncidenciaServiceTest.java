/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import apn.gob.pe.secajur.beans.AppCasoIncidencia;
import apn.gob.pe.secajur.service.CasoService;
import apn.gob.pe.secajur.service.CasoServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class IncidenciaServiceTest {
    
    private CasoService casoService = new CasoServiceImpl();
    
    public IncidenciaServiceTest() {
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
    public void registrarIncidencia() {
        try {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String stringdate = dt.format(new Date());
            Date fecha = dt.parse(stringdate);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String std = sdf.format(new Date());
            Date fecha2 = sdf.parse(std);
            AppCasoIncidencia incidencia = new AppCasoIncidencia();
            incidencia.setIncDes("Incidencia de prueba");
            incidencia.setIncFec(fecha);
            incidencia.setIncFlag(1);
            incidencia.setIncAlrtDat1(fecha);
            incidencia.setIncAlrtDat2(fecha);
            incidencia.setIncAlrtTimer(4);
            incidencia.setIncTipo(0);
            incidencia.setInc_Copias("rmarca@apn.gob.pe");
            incidencia.setInc_Para("atencion.redenaves@apn.gob.pe");
            casoService.registrarIncidencia(367, incidencia, "I");
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail("Error fatal al grabar: "+ e.getMessage());
        }
    }
}
