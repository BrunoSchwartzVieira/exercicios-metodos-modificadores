/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio5;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aluno.saolucas
 */
public class ConsultaTest {
    
    public ConsultaTest() {
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

    /**
     * Test of getMedico method, of class Consulta.
     */
    @Test
    public void testGetMedico() {
        System.out.println("getMedico");
        Consulta instance = null;
        Medico expResult = null;
        Medico result = instance.getMedico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaciente method, of class Consulta.
     */
    @Test
    public void testGetPaciente() {
        System.out.println("getPaciente");
        Consulta instance = null;
        Paciente expResult = null;
        Paciente result = instance.getPaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataHora method, of class Consulta.
     */
    @Test
    public void testGetDataHora() {
        System.out.println("getDataHora");
        Consulta instance = null;
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getDataHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
