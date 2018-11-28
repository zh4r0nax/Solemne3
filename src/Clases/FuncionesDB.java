/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IDaoProductos;
import Interfaces.IDaoVenta;

import dao.DaoProductoImpl;
import dao.DaoVentaImpl;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juang
 */
public class FuncionesDB {
    
    public DefaultTableModel MostrarVentasRealizadas() throws SQLException{
        
        DefaultTableModel modelo = new DefaultTableModel();
            try{
                
                IDaoVenta DaoVenta = new DaoVentaImpl();
                IDaoProductos DaoProd = new DaoProductoImpl();
                
                List<Venta> lstVenta =  DaoVenta.Listar();
                List<Producto> lstProd = DaoProd.Listar();
                
                for(int i=0; i<lstVenta.size();i++){
                    
                    int id = lstVenta.get(i).getID_PRODUCTO();
                    for(int j=0; j<lstProd.size();j++){
                        if(id == lstProd.get(j).getDBID_Producto()){
                            lstVenta.get(i).setNombreProducto(lstProd.get(j).getNombre());
                        }
                    }
                    
                }
                
                modelo.setColumnIdentifiers(new Object[]{"DBID_VENTA","PRODUCTO","CANTIDAD", "PRECIO_FINAL"});
                for (int i = 0; i < lstVenta.size(); i++) {    
                    modelo.addRow(new Object[]{lstVenta.get(i).getDBID_VENTA(),
                                               lstVenta.get(i).getNombreProducto(),
                                               lstVenta.get(i).getCANTIDAD(),
                                               lstVenta.get(i).getPRECIO_FINAL()
                    });
                }
            }catch(Exception ex){
                System.out.println(ex);
            }

        return modelo;
    }
    
    
    
}
