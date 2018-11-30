/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juang
 */
public class Conexion {
    protected Connection conextion;
    //private static final String driver = "com.mysql.jdbc.Driver";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_Host = "jdbc:mysql://localhost:3308/solemne3?verifyServerCertificate=false&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_User = "poo";
    private static final String DB_Pass = "poo2018";
    
    //ambiente Universidad
    //private static final String DB_Host = "jdbc:mysql://localhost/solemne2java";
    //private static final String DB_User = "root";
    //private static final String DB_Pass = "";
    
    public void Conectar() throws Exception{
        try{
            Class.forName(driver);
            conextion = DriverManager.getConnection(DB_Host,DB_User,DB_Pass);
            //System.out.println("Conexión exitosa");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void Desconectar() throws SQLException{
        if (conextion != null){
            if(!conextion.isClosed()){
                conextion.close();
            }
        }
    }
    
}
