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
public class DaoReporte extends Conexion implements IDaoReporte {

    @Override
    public List<Reporte> Listar() throws Exception {
          List<Reporte> lista = null;
        try{
            this.Conectar();
            PreparedStatement st = this.conextion.prepareStatement("SELECT * FROM productos");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Reporte rep = new Reporte();
                
                
                lista.add(rep);
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
