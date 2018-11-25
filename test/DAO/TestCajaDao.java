/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.IDaoCaja;
import Clases.Caja;
import dao.DaoCajaImpl;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juang
 */
public class TestCajaDao {
    
    private IDaoCaja Dcaja2;
        
    @Before
    public void setUp() {
        
        
        Dcaja2 = new DaoCajaImpl();
    }
    
    
    @Test
    public void Insert() throws Exception {
        Caja caja = new Caja("CajaTest1",10000);
        assertTrue(Dcaja2.Registrar(caja));
    }
    
    
    
    @Test
    public void Update() throws Exception {
        Caja caja = new Caja("CajaTest1Update",20000);
        caja.setDBID_Caja(2);
        
        assertTrue(Dcaja2.Modificar(caja));
    }
    
    
    @Test
    public void Eliminar() throws Exception {
        Caja caja = new Caja();
        caja.setDBID_Caja(3);
        
        assertTrue(Dcaja2.Eliminar(caja));
    }
    
    
    //valida si existe un registro con id=1
    @Test
    public void Listar() throws Exception{
        
        List<Caja> lstCaja = Dcaja2.Listar();
        for(int i=0; i <= lstCaja.size(); i++){
            Caja caja = lstCaja.get(i);
            System.out.println(caja);
            assertEquals(1, caja.getDBID_Caja()); 
            break;
        }
    }
    
}
