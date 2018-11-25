/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Tipo_Producto;
import java.util.List;

/**
 *
 * @author juang
 */
public interface IDaoTipo_Producto {
    public List<Tipo_Producto> Listar() throws Exception;
    public boolean Modificar(Tipo_Producto TipoProd) throws Exception;
    public boolean Eliminar(Tipo_Producto TipoProd) throws Exception;
    public boolean Registrar(Tipo_Producto TipoProd) throws Exception;
}
