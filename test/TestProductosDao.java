/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.Producto;
import Interfaces.IDaoProductos;
import dao.DaoProductoImpl;
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
public class TestProductosDao {
    
    private IDaoProductos Daopro;
        
    @Before
    public void setUp() {
        Daopro = new DaoProductoImpl();
    }
    
    
    /*
    @Test
    public void Insert() throws Exception {
        Producto pro = new Producto("ProcutoTest1",1,10,50,1000,1190);
        assertTrue(Daopro.Registrar(pro));
    }
    */
    
    /*
    
    @Test
    public void Update() throws Exception {
        Producto pro = new Producto("ProcutoTest1Update",1,10,50,1000,1190);
        pro.setDBID_Producto(2);
        
        assertTrue(Daopro.Update(pro));
    }
    */
    
    /*
    @Test
    public void Eliminar() throws Exception {
        Producto pro = new Producto();
        pro.setDBID_Producto(3);
        
        assertTrue(Daopro.Eliminar(pro));
    }
    */
    
    
    //valida si existe un registro con id=1
    @Test
    public void Listar() throws Exception{
        
        List<Producto> lstPro =Daopro.Listar();
        for(int i=0; i <= lstPro.size(); i++){
            Producto pro = lstPro.get(i);
            System.out.println(pro);
            assertEquals(1, pro.getDBID_Producto()); 
            break;
        }
    }
}
