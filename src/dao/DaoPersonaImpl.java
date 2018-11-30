/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ClasesSinImportancia.Persona;
import Interfaces.Dao.DaoPersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juang
 */
public class DaoPersonaImpl extends Conexion implements DaoPersona{

    @Override
    public void Registrar(Persona per) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("INSERT INTO PERSONA(NOMBRE) VALUES(?)");
            st.setString(1, per.getNombre());
            st.execute();
        }catch(Exception e){
           throw e; 
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public void Modificar(Persona per) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("UPDATE PERSONA SET NOMBRE = ? WHERE ID = ?");
            st.setString(1, per.getNombre());
            st.setInt(2, per.getId());
            st.execute();
        }catch(Exception e){
           throw e; 
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public void Eliminar(Persona per) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("delete from PERSONA WHERE ID = ?");
            st.setInt(1, per.getId());
            st.execute();
        }catch(Exception e){
           throw e; 
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public List<Persona> Listar() throws Exception {
        List<Persona> lista = null;
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("SELECT * FROM PERSONA");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Persona per = new Persona();
                per.setId(rs.getInt("ID"));
                per.setNombre(rs.getString("NOMBRE"));
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
    
}
