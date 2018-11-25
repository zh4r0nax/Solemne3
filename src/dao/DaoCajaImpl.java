/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Clases.Caja;
import Interfaces.IDaoCaja;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juang
 */
public class DaoCajaImpl extends Conexion implements IDaoCaja{

    @Override
    public boolean Registrar(Caja Caja) throws Exception {
         boolean respuesta = false;
        String Query="";
         try{
            this.Conectar();
            Query="INSERT INTO caja("+ 
                    "CODIGO_CAJA ," +
                    "FLUJO_INICIAL ) VALUES(?,?);";

            PreparedStatement st = this.conextion.prepareStatement(Query);
            st.setString(1, Caja.getCODIGO_CAJA());
            st.setInt(2, Caja.getFlujo_Inicial());

            st.execute();
            respuesta =true;
        }catch(Exception e){
           System.out.println(e);
           
        }finally{
            this.Desconectar();
            return respuesta;
        }
    }

    @Override
    public boolean Modificar(Caja Caja) throws Exception {
        boolean respuesta = false;
        String Query="";
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("UPDATE caja "
                    + "SET CODIGO_CAJA = ?, "
                    + "FLUJO_INICIAL = ?, "
                    + "FLUJO_INGRESO = ?,"
                    + "FLUJO_SALIDA= ? "
                    + "WHERE DBID_CAJA = ?");
            st.setString(1, Caja.getCODIGO_CAJA());
            st.setInt(2, Caja.getFlujo_Inicial());
            st.setInt(3, Caja.getFLujo_Ingreso());
            st.setInt(4, Caja.getFlujo_Salida());
            st.setInt(5, Caja.getDBID_Caja());
            
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
    public boolean Eliminar(Caja Caja) throws Exception {
        boolean resultado = false;
         try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("delete from caja WHERE DBID_CAJA = ?");
            st.setInt(1, Caja.getDBID_Caja());
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
    public List<Caja> Listar() throws Exception {
        List<Caja> lista = null;
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("SELECT * FROM caja");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Caja caja = new Caja();
                caja.setDBID_Caja(rs.getInt("DBID_CAJA"));
                caja.setCODIGO_CAJA(rs.getString("CODIGO_CAJA"));
                caja.setFlujo_Inicial(rs.getInt("FLUJO_INICIAL"));
                caja.setFLujo_Ingreso(rs.getInt("FLUJO_INGRESO"));
                caja.setFlujo_Salida(rs.getInt("FLUJO_SALIDA"));
                
                lista.add(caja);
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
