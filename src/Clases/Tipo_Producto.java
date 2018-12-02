/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.ITipoProd;

/**
 *
 * @author juang
 */
public class Tipo_Producto implements ITipoProd  {
    int DBID_Tipo_Producto;
    String Nombre;
    int IVA;

    public Tipo_Producto() {
    }

    public Tipo_Producto(String Nombre, int IVA) {
        this.Nombre = Nombre;
        this.IVA = IVA;
    }

    public int getDBID_Tipo_Producto() {
        return DBID_Tipo_Producto;
    }

    public void setDBID_Tipo_Producto(int DBID_Tipo_Producto) {
        this.DBID_Tipo_Producto = DBID_Tipo_Producto;
    }

    @Override
    public String getNombre() {
        return Nombre;
    }
    @Override
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    @Override
    public int getIVA() {
        return IVA;
    }
    @Override
    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    @Override
    public String toString() {
        //return "Tipo_Producto{" + "DBID_Tipo_Producto=" + DBID_Tipo_Producto + ", Nombre=" + Nombre + ", IVA=" + IVA + '}';
        return this.Nombre;
    }
    
    
}
