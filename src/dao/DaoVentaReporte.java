/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Clases.Reporte;
import Interfaces.Dao.IDaoReporte;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juang
 */
public class DaoVentaReporte extends Conexion implements IDaoReporte {

    @Override
    public List<Reporte> Listar() throws Exception {
         List<Reporte> lista ;
         try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("select\n" +
                " venta.ID_PRODUCTO as 'Prod'\n"+
                " ,sum(venta.CANTIDAD) as 'Cantidad'\n"+
                " ,sum(venta.PRECIO_FINAL) as 'Total'\n"+
                " from\n" +
                " venta\n" +
                " group by venta.ID_PRODUCTO order by sum(venta.CANTIDAD) desc");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Reporte Reporte = new Reporte();
                Reporte.setProd(rs.getString("Prod"));
                Reporte.setCantidad(rs.getInt("Cantidad"));
                Reporte.setTotal(rs.getInt("Total"));
                lista.add(Reporte);
            }
            rs.close();
            st.close();
        }catch(Exception e){
           throw e; 
        }finally{
            this.Desconectar();
        }
        return lista;
    }

    
}
