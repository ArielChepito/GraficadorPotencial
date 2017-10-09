/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desafio1.Entidades;

import java.math.BigDecimal;

/**
 *
 * @author chepito
 */
public class Cargas {
    private BigDecimal  carga;
    private int  X;
    private int  Y;
    private double distancia;
    private double potencial;
    private String name;
    public  static int contador = 1;

    public Cargas() {
        name = "Q"+contador;
         contador++;
    }

    public Cargas(BigDecimal carga, int X, int Y, int distancia) {
        this.carga = carga;
        this.X = X;
        this.Y = Y;
        this.distancia = distancia;
        name = "Q"+contador;
        contador++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public Cargas(BigDecimal carga, int X, int Y) {
        this.carga = carga;
        this.X = X;
        this.Y = Y;
        name = "Q"+contador;
        contador++;
    }

    public Cargas(BigDecimal carga, int X, int Y, int distancia, double potencial) {
        this.carga = carga;
        this.X = X;
        this.Y = Y;
        this.distancia = distancia;
        this.potencial = potencial;
        name = "Q"+contador;
        contador++;
    }

    public double getPotencial() {
        return potencial;
    }

    public void setPotencial(double potencial) {
        this.potencial = potencial;
    }
    

    public BigDecimal  getCarga() {
        return carga;
    }

    public void setCarga(BigDecimal carga) {
        this.carga = carga;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
            
}
