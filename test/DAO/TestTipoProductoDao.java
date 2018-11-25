/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Tipo_Producto;
import Interfaces.IDaoTipo_Producto;
import dao.DaoTipoProductoImpl;

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
public class TestTipoProductoDao {
    private IDaoTipo_Producto DTipoProd;
    
    @Before
    public void setUp(){
        DTipoProd = new DaoTipoProductoImpl();
    }
  
    @Test
    public void Insert() throws Exception{
        Tipo_Producto tp = new Tipo_Producto("Test",19);
        assertTrue(DTipoProd.Registrar(tp));
        
    }
    
    @Test
    public void Update()throws Exception{
        Tipo_Producto tp = new Tipo_Producto("Test3Update",15);
        tp.setDBID_Tipo_Producto(2);
        assertTrue(DTipoProd.Modificar(tp));
    }
    
    @Test
    public void Eliminar()throws Exception{
        Tipo_Producto tp = new Tipo_Producto();
        tp.setDBID_Tipo_Producto(3);
        assertTrue(DTipoProd.Eliminar(tp));
    }
    
    @Test
    public void Listar()throws Exception{
          List<Tipo_Producto> lstTipPro =DTipoProd.Listar();
        for(int i=0; i <= lstTipPro.size(); i++){
            Tipo_Producto tp = lstTipPro.get(i);
            System.out.println(tp);
            assertEquals(1, tp.getDBID_Tipo_Producto()); 
            break;
        }
    }
    
    
}
