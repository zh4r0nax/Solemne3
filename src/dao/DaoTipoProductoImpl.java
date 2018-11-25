/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Clases.Tipo_Producto;
import Interfaces.IDaoTipo_Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juang
 */
public class DaoTipoProductoImpl extends Conexion implements IDaoTipo_Producto {

    @Override
    public List<Tipo_Producto> Listar() throws Exception {
        List<Tipo_Producto> lista ;
         try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("SELECT * FROM tipo_producto");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Tipo_Producto TP = new Tipo_Producto();
                TP.setDBID_Tipo_Producto(rs.getInt("DBID_TIPO_PRODUCTO"));
                TP.setNombre(rs.getString("NOMBRE"));
                TP.setIVA(rs.getInt("IVA"));
                
                lista.add(TP);
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
    public boolean Modificar(Tipo_Producto TipoProd) throws Exception {
        boolean respuesta = false;
        String Query="";
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("UPDATE tipo_producto "
                    + "SET NOMBRE = ?, "
                    + "IVA = ? "
                    + "WHERE DBID_TIPO_PRODUCTO = ?");
            st.setString(1, TipoProd.getNombre());
            st.setInt(2, TipoProd.getIVA());
            st.setInt(3, TipoProd.getDBID_Tipo_Producto());
            
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
    public boolean Eliminar(Tipo_Producto TipoProd) throws Exception {
        boolean resultado = false;
         try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("delete from tipo_producto WHERE DBID_TIPO_PRODUCTO = ?");
            st.setInt(1, TipoProd.getDBID_Tipo_Producto());
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
    public boolean Registrar(Tipo_Producto TipoProd) throws Exception {
        boolean respuesta = false;
        String Query="";
         try{
            this.Conectar();
            Query="INSERT INTO tipo_producto("+ 
                    "NOMBRE ," +
                    "IVA ) VALUES(?,?);";
            
            PreparedStatement st = this.conextion.prepareStatement(Query);
            st.setString(1, TipoProd.getNombre());
            st.setInt(2, TipoProd.getIVA());
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
