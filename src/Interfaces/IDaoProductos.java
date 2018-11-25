/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Producto;
import java.util.List;

/**
 *
 * @author juang
 */
public interface IDaoProductos {
    public List<Producto> Listar() throws Exception;
    public boolean Modificar(Producto Producto) throws Exception;
    public boolean Eliminar(Producto Producto) throws Exception;
    public boolean Registrar(Producto Producto) throws Exception;
}
