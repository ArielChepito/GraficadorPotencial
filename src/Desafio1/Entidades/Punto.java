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
public class Punto {

    public int X;
    public int Y;
    public BigDecimal potencial = new BigDecimal("0.000");
     private String name;
    private static int contador = 1;
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public Punto(int X, int Y, BigDecimal potencial) {
        this.X = X;
        this.Y = Y;
        this.potencial = potencial;
        name = ""+ String.valueOf(alphabet[contador-1]).toUpperCase();
         contador++;
    }

    public Punto(int X, int Y) {
        this.X = X;
        this.Y = Y;
       name = ""+ String.valueOf(alphabet[contador-1]).toUpperCase();
         contador++;
    }
    

    public Punto() {
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

    public BigDecimal getPotencial() {
        return potencial;
    }

    public void setPotencial(BigDecimal potencial) {
        this.potencial = potencial;
    }

    @Override
    public String toString() {
        return "Punto " +name+ ": "+ potencial;
    }
    
    
    
    

    
    
}
