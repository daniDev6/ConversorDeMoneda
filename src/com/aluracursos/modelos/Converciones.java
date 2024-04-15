package com.aluracursos.modelos;

import java.time.LocalDate;

public class Converciones {
    private String monedaBase;
    private String monedaFinal;
    private double cantidadBase;
    private double cantidadFinal;
    private String tiempo;

    public Converciones(String monedaBase, String monedaFinal, double cantidadBase, double cantidadFinal,String tiempo) {
        this.monedaBase = monedaBase;
        this.monedaFinal = monedaFinal;
        this.cantidadBase = cantidadBase;
        this.cantidadFinal = cantidadFinal;
        this.tiempo = tiempo;
    }



    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public void setMonedaFinal(String monedaFinal) {
        this.monedaFinal = monedaFinal;
    }

    public double getCantidadBase() {
        return cantidadBase;
    }

    public void setCantidadBase(double cantidadBase) {
        this.cantidadBase = cantidadBase;
    }

    public double getCantidadFinal() {
        return cantidadFinal;
    }

    public void setCantidadFinal(double cantidadFinal) {
        this.cantidadFinal = cantidadFinal;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "\n Conversion: " +
                " monedaBase=" +cantidadBase + " " + monedaBase +
                ", monedaFinal=" + cantidadFinal + " " + monedaFinal +
                ", fechaRealizada=" + tiempo;
    }
}
