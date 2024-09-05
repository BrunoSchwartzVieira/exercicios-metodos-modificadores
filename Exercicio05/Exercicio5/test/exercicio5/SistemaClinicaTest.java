/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio5;

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
public class SistemaClinicaTest {
    
    public SistemaClinicaTest() {
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
     * Test of adicionarMedico method, of class SistemaClinica.
     */
    @Test
    public void testAdicionarMedico() {
        System.out.println("adicionarMedico");
        String nome = "";
        String especialidade = "";
        SistemaClinica instance = new SistemaClinica();
        instance.adicionarMedico(nome, especialidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarPaciente method, of class SistemaClinica.
     */
    @Test
    public void testAdicionarPaciente() {
        System.out.println("adicionarPaciente");
        String nome = "";
        String dataNascimento = "";
        SistemaClinica instance = new SistemaClinica();
        instance.adicionarPaciente(nome, dataNascimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agendarConsulta method, of class SistemaClinica.
     */
    @Test
    public void testAgendarConsulta() {
        System.out.println("agendarConsulta");
        String nomeMedico = "";
        String nomePaciente = "";
        String data = "";
        String hora = "";
        SistemaClinica instance = new SistemaClinica();
        instance.agendarConsulta(nomeMedico, nomePaciente, data, hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarPacientesMedico method, of class SistemaClinica.
     */
    @Test
    public void testListarPacientesMedico() {
        System.out.println("listarPacientesMedico");
        String nomeMedico = "";
        SistemaClinica instance = new SistemaClinica();
        instance.listarPacientesMedico(nomeMedico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exibirProximasConsultas method, of class SistemaClinica.
     */
    @Test
    public void testExibirProximasConsultas() {
        System.out.println("exibirProximasConsultas");
        SistemaClinica instance = new SistemaClinica();
        instance.exibirProximasConsultas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class SistemaClinica.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SistemaClinica.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
