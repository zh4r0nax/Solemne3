/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Venta;
import java.util.List;

/**
 *
 * @author juang
 */
public interface IDaoVenta {
    public List<Venta> Listar() throws Exception;
    public boolean Modificar(Venta Venta) throws Exception;
    public boolean Eliminar(Venta Venta) throws Exception;
    public boolean Registrar(Venta Venta) throws Exception;
}
