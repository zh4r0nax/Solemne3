/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Clases.Producto;
import Interfaces.IDaoProductos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juang
 */
public class DaoProductoImpl extends Conexion implements IDaoProductos {

    @Override
    public List<Producto> Listar() throws Exception {
        List<Producto> lista = null;
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("SELECT * FROM productos");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Producto per = new Producto();
                per.setDBID_Producto(rs.getInt("DBID_PRODUCTO"));
                per.setNombre(rs.getString("NOMBRE"));
                per.setID_Tipo(rs.getInt("ID_TIPO"));
                per.setCantidad(rs.getInt("CANTIDAD"));
                per.setCantidadMinima(rs.getInt("CANTIDAD_MINIMA"));
                per.setPrecioBruto(rs.getInt("PRECIO_BRUTO"));
                per.setPrecioNeto(rs.getInt("PRECIO_NETO"));
                
                lista.add(per);
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
    public boolean Modificar(Producto Producto) throws Exception {
        boolean respuesta = false;
        String Query="";
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("UPDATE productos "
                    + "SET NOMBRE = ?, "
                    + "ID_TIPO = ?, "
                    + "CANTIDAD = ?,"
                    + "CANTIDAD_MINIMA= ?, "
                    + "PRECIO_BRUTO = ?,"
                    + "PRECIO_NETO = ? "
                    + "WHERE DBID_PRODUCTO = ?");
            st.setString(1, Producto.getNombre());
            st.setInt(2, Producto.getID_Tipo());
            st.setInt(3, Producto.getCantidad());
            st.setInt(4, Producto.getCantidadMinima());
            st.setInt(5, Producto.getPrecioBruto());
            st.setInt(6, Producto.getPrecioNeto());
            st.setInt(7, Producto.getDBID_Producto());
            
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
    public boolean Eliminar(Producto Producto) throws Exception {
        boolean resultado = false;
         try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("delete from productos WHERE DBID_PRODUCTO = ?");
            st.setInt(1, Producto.getDBID_Producto());
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
    public boolean Registrar(Producto Producto) throws Exception {
        boolean respuesta = false;
        String Query="";
         try{
            this.Conectar();
            Query="INSERT INTO productos("+ 
                    "NOMBRE ," +
                    "ID_TIPO ," +
                    "CANTIDAD , " +
                    "CANTIDAD_MINIMA , " +
                    "PRECIO_BRUTO, " +
                    "PRECIO_NETO) VALUES(?,?,?,?,?,?);";

            PreparedStatement st = this.conextion.prepareStatement(Query);
            st.setString(1, Producto.getNombre());
            st.setInt(2, Producto.getID_Tipo());
            st.setInt(3, Producto.getCantidad());
            st.setInt(4, Producto.getCantidadMinima());
            st.setInt(5, Producto.getPrecioBruto());
            st.setInt(6, Producto.getPrecioNeto());

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
