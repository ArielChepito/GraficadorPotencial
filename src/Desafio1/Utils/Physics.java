/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desafio1.Utils;

import Desafio1.Entidades.Cargas;
import Desafio1.Entidades.Punto;
import java.util.List;

/**
 *
 * @author chepito
 */
public class Physics {
    
    
    
    public static final double YOTTA = 1e24; //Y
    public static final double ZETTA = 1e21; //Z
    public static final double EXA = 1e18; //E
    public static final double PETA = 1e15; //P
    public static final double TERA = 1e12; //T
    public static final double GIGA = 1e9; //G
    public static final double MEGA = 1e6; //M
    public static final double KILO = 1e3; //k
    public static final double MILI = 1E-3; //m
    public static final double MICRO = 1e-6; //mi
    public static final double NANO = 1e-9; //n
    public static final double PICO = 1e-12; //p
    public static final double FEMTO = 1e-15; //f
    public static final double ATTO = 1e-18; //a
    public static final double ZAPTO = 1e-21; //z
    public static final double YOCTO = 1e-24; //y
    
    
    public static double constant = 9e9;   
    public static boolean cm = true;    
    public static double distanciaDosPuntos(Punto punto, Cargas carga)
    {   
        if(cm) return (Math.hypot(punto.getX()-carga.getX(), punto.getY()-carga.getY()))/100;
        return Math.hypot(punto.getX()-carga.getX(), punto.getY()-carga.getY());
    }
    /*
    public static double roundCantidad(Double cantidad)
    {
        System.out.println("roundCantidad cantidad: "+(double)Math.round(cantidad * 100d) / 100d);
        return (double)Math.round(cantidad * 1000d) / 1000d ;
        return cantidad;
        
    }*/    
    public static double calcularpotencial(Punto punto, Cargas carga)
    {   
      
        return (( (Physics.constant)*( carga.getCarga()) )/(distanciaDosPuntos(punto,carga)));
    }
    public static double internationalSystemUnits(int index, double num)
    {
        double resultado = 0.00;
        switch(index)
        {            
            case 1: resultado =  num * YOTTA; break;
            case 2: resultado=  num * ZETTA;  break;
            case 3: resultado =  num * EXA; break;
            case 4: resultado=  num * PETA;  break;
            case 5: resultado =  num * TERA; break;
            case 6: resultado=  num * GIGA;  break;
            case 7: resultado =  num * MEGA; break;
            case 8: resultado=  num * KILO;  break;
            case 9: resultado =  num * MILI; break;
            case 10: resultado=  num * MICRO;  break;
            case 11: resultado =  num * NANO; break;
            case 12: resultado=  num * PICO;  break;
            case 13: resultado=  num * FEMTO;  break;
            case 14: resultado =  num * ATTO; break;
            case 15: resultado=  num * ZAPTO;  break;
            case 16: resultado=  num * YOCTO;  break;
        }
    
        return resultado;
    }
}
