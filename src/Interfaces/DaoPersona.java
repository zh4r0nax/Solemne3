/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ClasesSinImportancia.Persona;
import java.util.List;

/**
 *
 * @author juang
 */
public interface DaoPersona {
    public void Registrar(Persona per) throws Exception;
    public void Modificar(Persona per) throws Exception;
    public void Eliminar(Persona per) throws Exception;
    public List<Persona> Listar() throws Exception;
}
