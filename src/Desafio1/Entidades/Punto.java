/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desafio1.Entidades;

/**
 *
 * @author chepito
 */
public class Punto {

    public int X;
    public int Y;
    public double potencial;
    public Punto(int X, int Y, double potencial) {
        this.X = X;
        this.Y = Y;
        this.potencial = potencial;
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

    public double getPotencial() {
        return potencial;
    }

    public void setPotencial(double potencial) {
        this.potencial = potencial;
    }

    
    
}
