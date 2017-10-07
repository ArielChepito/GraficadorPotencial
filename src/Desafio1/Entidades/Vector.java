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
public class Vector {
    public  int X;
    public  int Y;    
     
    public Vector(){
    }
    public Vector(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
    
    public void set(int x, int y)
    {
        this.X = x;
        this.Y = y;
    }
    public void set(int n)
    {
        this.X = n;
        this.Y = n;
    }
    public void set(Vector v)
    {
        this.X = v.X;
        this.Y = v.Y;
    }
    public void add(int n){
        X+=n;
        Y+=n;
    }
    public void add(Vector v){
        X+=v.X;
        Y+=v.Y;
    }
    public Vector plus(int n){
        return (new Vector(X+n,Y+n));
    }
    public Vector plus(Vector v){
        return (new Vector(X+v.X,Y+v.Y));
    }    
    public Vector subtr(int n){
        return (new Vector(X-n,Y-n));
    }
    public Vector subtr(Vector v){
        return (new Vector(X-v.X,Y-v.Y));
    }
    public Vector subtr(int x, int y){
        return (new Vector(X-x,Y-y));
    }
     public Vector inSubtr(int n){
        return (new Vector(n-X,n-Y));
    }
    public Vector inSubtr(Vector v){
        return (new Vector(v.X-X,v.Y-Y));
    }
    public Vector inSubtr(int x, int y){
        return (new Vector(x-X,y-Y));
    }
    public Vector divide(int n){
        return (new Vector(X/n,Y/n));
    }
}
