/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Venta;
import Interfaces.IDaoVenta;
import dao.DaoVentaImpl;
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
public class TestVentaDao {
    
    private IDaoVenta DVenta;
     
    public TestVentaDao() {
    }
    
    @Before
    public void setUp() {
        DVenta = new DaoVentaImpl();
    }
    
    @Test
    public void Insert() throws Exception{
        Venta venta = new Venta(1,1,18,5000);
        assertTrue(DVenta.Registrar(venta));
        
    }
    
    @Test
    public void Update()throws Exception{
        Venta venta = new Venta(1,1,19,6500);
        venta.setDBID_VENTA(2);
        assertTrue(DVenta.Modificar(venta));
    }
    
    @Test
    public void Eliminar()throws Exception{
        Venta venta = new Venta();
        venta.setDBID_VENTA(3);
        assertTrue(DVenta.Eliminar(venta));
    }
    
    @Test
    public void Listar()throws Exception{
          List<Venta> lstVenta =DVenta.Listar();
        for(int i=0; i <= lstVenta.size(); i++){
            Venta venta = lstVenta.get(i);
            System.out.println(venta);
            assertEquals(1, venta.getDBID_VENTA()); 
            break;
        }
    }
    
    
}
