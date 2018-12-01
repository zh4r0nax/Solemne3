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
public class Caja {
    int DBID_Caja;
    String CODIGO_CAJA;
    int Flujo_Inicial;
    int FLujo_Ingreso;
    int Flujo_Salida;

    public Caja() {
    }

    public Caja(String CODIGO_CAJA, int Flujo_Inicial) {
        this.CODIGO_CAJA = CODIGO_CAJA;
        this.Flujo_Inicial = Flujo_Inicial;
    }

    public int getDBID_Caja() {
        return DBID_Caja;
    }

    public void setDBID_Caja(int DBID_Caja) {
        this.DBID_Caja = DBID_Caja;
    }

    public String getCODIGO_CAJA() {
        return CODIGO_CAJA;
    }

    public void setCODIGO_CAJA(String CODIGO_CAJA) {
        this.CODIGO_CAJA = CODIGO_CAJA;
    }

    public int getFlujo_Inicial() {
        return Flujo_Inicial;
    }

    public void setFlujo_Inicial(int Flujo_Inicial) {
        this.Flujo_Inicial = Flujo_Inicial;
    }

    public int getFLujo_Ingreso() {
        return FLujo_Ingreso;
    }

    public void setFLujo_Ingreso(int FLujo_Ingreso) {
        this.FLujo_Ingreso = FLujo_Ingreso;
    }

    public int getFlujo_Salida() {
        return Flujo_Salida;
    }

    public void setFlujo_Salida(int Flujo_Salida) {
        this.Flujo_Salida = Flujo_Salida;
    }

    @Override
    public String toString() {
        return "Caja: " + "DBID_Caja: " + DBID_Caja + ", CODIGO_CAJA: " + CODIGO_CAJA + ", Flujo_Inicial: " + Flujo_Inicial + ", FLujo_Ingreso: " + FLujo_Ingreso + ", Flujo_Salida: " + Flujo_Salida;
    }
    
    
    
}