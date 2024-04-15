package com.aluracursos.modelos;

public class Moneda {
    private String simbolo;
    private double cantidad;

    public Moneda(String simbolo, double cantidad) {
        this.simbolo = simbolo;
        this.cantidad = cantidad;
    }
    public Moneda(){}

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return this.cantidad + " " +  this.simbolo ;
    }
}
