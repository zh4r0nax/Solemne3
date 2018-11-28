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
public class Venta {
    private int DBID_VENTA;
    private int ID_PRODUCTO;
    private int ID_CAJA;
    private int CANTIDAD;
    private int PRECIO_FINAL;
    private String NombreProducto;

    public Venta() {
    }

    public Venta(int ID_PRODUCTO, int ID_CAJA, int CANTIDAD, int PRECIO_FINAL) {
        this.ID_PRODUCTO = ID_PRODUCTO;
        this.ID_CAJA = ID_CAJA;
        this.CANTIDAD = CANTIDAD;
        this.PRECIO_FINAL = PRECIO_FINAL;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    
    public int getDBID_VENTA() {
        return DBID_VENTA;
    }

    public void setDBID_VENTA(int DBID_VENTA) {
        this.DBID_VENTA = DBID_VENTA;
    }

    public int getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(int ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

    public int getID_CAJA() {
        return ID_CAJA;
    }

    public void setID_CAJA(int ID_CAJA) {
        this.ID_CAJA = ID_CAJA;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public int getPRECIO_FINAL() {
        return PRECIO_FINAL;
    }

    public void setPRECIO_FINAL(int PRECIO_FINAL) {
        this.PRECIO_FINAL = PRECIO_FINAL;
    }

    @Override
    public String toString() {
        return "Venta{" + "DBID_VENTA=" + DBID_VENTA + ", ID_PRODUCTO=" + ID_PRODUCTO + ", ID_CAJA=" + ID_CAJA + ", CANTIDAD=" + CANTIDAD + ", PRECIO_FINAL=" + PRECIO_FINAL + '}';
    }
    
    
}
