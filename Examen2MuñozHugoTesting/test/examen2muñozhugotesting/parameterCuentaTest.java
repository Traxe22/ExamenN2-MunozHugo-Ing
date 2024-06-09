/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package examen2muñozhugotesting;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author munoz
 */
@RunWith(Parameterized.class)
public class parameterCuentaTest {
    private  double monto;
    private Cuenta cuenta;
    private double esperado;

    public parameterCuentaTest(double monto, Cuenta cuenta, double esperado) {
        this.monto = monto;
        this.cuenta = cuenta;
        this.esperado = esperado;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]>datos(){
      return Arrays.asList(new Object[][]{
          {500, new Cuenta(987),1500.0},
          {300.5, new Cuenta(654),3333},
          {99999,new Cuenta(001),2000.0}
      });
    }
    @Test
    public void testRetirarDinero() throws Exception{
        System.out.println("Intentemos..");
        assertEquals(esperado, cuenta.retirarDinero(monto),0.1);
        System.out.println("Saldo final "+cuenta.getSaldo());
    }
}
