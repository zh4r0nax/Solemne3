/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solemne3;

import ClasesSinImportancia.Persona;
import Interfaces.DaoPersona;
import dao.DaoPersonaImpl;

/**
 *
 * @author juang
 */
public class Solemne3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona per = new Persona();
        per.setNombre("ejemplo2");
        
        try{
            DaoPersona dao = new DaoPersonaImpl();
            dao.Registrar(per);
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
