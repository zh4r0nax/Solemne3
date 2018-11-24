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
    public void Update(Producto Producto) throws Exception;
    public void Eliminar(Producto Producto) throws Exception;
    public void Registrar(Producto Producto) throws Exception;
}
