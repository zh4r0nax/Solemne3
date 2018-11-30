/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Clases.Venta;
import Interfaces.Dao.IDaoVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juang
 */
public class DaoVentaImpl  extends Conexion implements IDaoVenta{

    @Override
    public List<Venta> Listar() throws Exception {
        List<Venta> lista ;
         try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("SELECT * FROM venta");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Venta Venta = new Venta();
                Venta.setDBID_VENTA(rs.getInt("DBID_VENTA"));
                Venta.setID_PRODUCTO(rs.getInt("ID_PRODUCTO"));
                Venta.setID_CAJA(rs.getInt("ID_CAJA"));
                Venta.setCANTIDAD(rs.getInt("CANTIDAD"));
                Venta.setPRECIO_FINAL(rs.getInt("PRECIO_FINAL"));
                lista.add(Venta);
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

    @Override
    public boolean Modificar(Venta Venta) throws Exception {
         boolean respuesta = false;
        String Query="";
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("UPDATE venta "
                    + "SET ID_PRODUCTO = ?, "
                    + "ID_CAJA = ?, "
                    + "CANTIDAD = ?, "
                    + "PRECIO_FINAL = ? "
                    
                    + " WHERE DBID_VENTA = ?");
            st.setInt(1, Venta.getID_PRODUCTO());
            st.setInt(2, Venta.getID_CAJA());
            st.setInt(3, Venta.getCANTIDAD());
            st.setInt(4, Venta.getPRECIO_FINAL());
            st.setInt(5, Venta.getDBID_VENTA());
            
            
            
            st.execute();
            
            respuesta = true;
        }catch(Exception e){
            System.out.println(e);
            
        }finally{
            this.Desconectar();
            System.out.println(respuesta);
            System.out.println(Query);
            return respuesta;
        }
    }

    @Override
    public boolean Eliminar(Venta Venta) throws Exception {
        boolean resultado = false;
         try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("delete from venta WHERE DBID_VENTA = ?");
            st.setInt(1, Venta.getDBID_VENTA());
            st.execute();
            resultado = true;
        }catch(Exception e){
           System.out.println(e);
        }finally{
            this.Desconectar();
            return resultado;
        }
    }

    @Override
    public boolean Registrar(Venta Venta) throws Exception {
        boolean respuesta = false;
        String Query="";
         try{
            this.Conectar();
            Query="INSERT INTO venta("+ 
                    "ID_PRODUCTO ," +
                    "ID_CAJA ," +
                    "CANTIDAD ," +
                    "PRECIO_FINAL " +
                    ") VALUES(?,?,?,?);";
            
            PreparedStatement st = this.conextion.prepareStatement(Query);
            st.setInt(1, Venta.getID_PRODUCTO());
            st.setInt(2, Venta.getID_CAJA());
            st.setInt(3, Venta.getCANTIDAD());
            st.setInt(4, Venta.getPRECIO_FINAL());
            st.execute();
            respuesta =true;
        }catch(Exception e){
           System.out.println(e);
           
        }finally{
            this.Desconectar();
            return respuesta;
        }
    }
    
}
