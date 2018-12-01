/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Dao;

import Clases.Reporte;
import java.util.List;

/**
 *
 * @author juang
 */
public interface IDaoReporte{
    
    public List<Reporte> Listar() throws Exception;
}
