/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Caja;
import java.util.List;

/**
 *
 * @author juang
 */
public interface IDaoCaja {
    public void Registrar(Caja Caja) throws Exception;
    public void Modificar(Caja Caja) throws Exception;
    public void Eliminar(Caja Caja) throws Exception;
    public List<Caja> Listar() throws Exception;
}
