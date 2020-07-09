/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import apn.gob.pe.secajur.beans.AppCaso;
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
public class CasoServiceTest {
    
    private CasoService casoService = new CasoServiceImpl();
    
    public CasoServiceTest() {
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
    public void registrarCasoLegal(){
        try {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String stringdate = dt.format(new Date());
            Date fecha = dt.parse(stringdate);
            AppCaso caso = new AppCaso();
            caso.setCasoCod(120);
            caso.setCasoExped("201800002020");
            caso.setCasoLegajo("C-1280-2018-CDA");
            caso.setCasoUsuario("1");
            caso.setCasoFechareg(fecha);
            caso.setCasoMonto(2300.20);
            caso.setCasoEstado(3);
            caso.setCasoMateria(14);
            caso.setCasoDependencia("000001");
            caso.setCasoJuzgado("Juzgado del Callao");
            caso.setCasoCuantia(2000);
            caso.setCasoTipoproceso(8);
            caso.setCasoMoneda("000001");
            casoService.grabarCaso(caso, "I");
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail("Error fatal al grabar: "+ e.getMessage());
        }
    }
    
    public void modificarCasoLegal(){
        try {
            AppCaso caso = new AppCaso();
            caso.setCasoCod(12);
            caso.setCasoCuantia(120);
            casoService.grabarCaso(caso, "U");
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail("Error fatal al modificar: "+ e.getMessage());
        }
    }
    
}
