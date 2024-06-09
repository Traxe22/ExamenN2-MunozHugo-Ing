/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package examen2muñozhugotesting;

import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author munoz
 */
public class CuentaTest {
    private Cuenta micuenta;
    private Cuenta c3;
    public CuentaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Fecha de transiccion "+LocalDate.of(2024, Month.JULY, 9));
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("FIN de la transaccion");
    }
    
    @Before
    public void setUp() throws Exception{
        micuenta= new Cuenta(123);
        c3= new Cuenta(456);
    }
    
    @After
    public void tearDown() throws Exception{
        System.out.println("->La cuenta queda con : "+micuenta.getSaldo());
    }
    @Test(expected = Exception.class)
    public void testRetirarFallo() throws Exception{
        micuenta.retirarDinero(9000.0);
    }
    @Test 
    public void testRetirarExito() throws Exception{
        micuenta.retirarDinero(200);
        assertEquals(1800.0, micuenta.getSaldo(), 0.0);
    }
    @Test 
    public void testDepositarDinero(){
        assertNotNull(micuenta);
        micuenta.depositarDinero(micuenta, 200.0);
        assertEquals(2200,micuenta.getSaldo(),0.2);
    }
    @Test(expected = Exception.class)
    public void testTransferirCuentaNoNula() throws Exception{
        Cuenta c2=null;
        micuenta.transferirDinero(c2, 200.0);
        assertNull(c2);      
    }
    @Test 
    public void testCuentasDiferentes(){
        assertNotSame("SON la misma Cuenta!! origen y destino. ",micuenta, micuenta);
    }
    @Test 
    public void testCuentasIguales(){
        assertSame("Las cuentas son diferentes. ",micuenta,c3);
    }
    @Test(timeout = 60)
    public void testOperacionTildada1() throws InterruptedException{
        micuenta.OperacionTildada(50);
    }
    @Test(timeout = 60)
    public void testOperacionTildada2() throws InterruptedException{
        micuenta.OperacionTildada(70);
    }
    
}
