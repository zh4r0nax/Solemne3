/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author juang
 */
public class Producto {
    private int DBID_Producto;
    private String Nombre;
    private int ID_Tipo;
    private int Cantidad;
    private int CantidadMinima;
    private int PrecioBruto;
    private int PrecioNeto;

    public Producto() {
    }

    
    
    public Producto(String Nombre, int ID_Tipo, int Cantidad, int CantidadMinima, int PrecioBruto, int PrecioNeto) {
        this.Nombre = Nombre;
        this.ID_Tipo = ID_Tipo;
        this.Cantidad = Cantidad;
        this.CantidadMinima = CantidadMinima;
        this.PrecioBruto = PrecioBruto;
        this.PrecioNeto = PrecioNeto;
    }

    
    
    public int getID_Tipo() {
        return ID_Tipo;
    }

    public void setID_Tipo(int ID_Tipo) {
        this.ID_Tipo = ID_Tipo;
    }

    
    public int getDBID_Producto() {
        return DBID_Producto;
    }

    public void setDBID_Producto(int DBID_Producto) {
        this.DBID_Producto = DBID_Producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getCantidadMinima() {
        return CantidadMinima;
    }

    public void setCantidadMinima(int CantidadMinima) {
        this.CantidadMinima = CantidadMinima;
    }

    public int getPrecioBruto() {
        return PrecioBruto;
    }

    public void setPrecioBruto(int PrecioBruto) {
        this.PrecioBruto = PrecioBruto;
    }

    public int getPrecioNeto() {
        return PrecioNeto;
    }

    public void setPrecioNeto(int PrecioNeto) {
        this.PrecioNeto = PrecioNeto;
    }

    @Override
    public String toString(){
        return "Producto ID: "+this.DBID_Producto+", Nombre: "+this.Nombre+ ", Cantidad: "+this.Cantidad+", cantidad Mimina: "+this.CantidadMinima+", PrecioNeto"+this.PrecioNeto;
    }
}
