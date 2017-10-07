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
    public static double constant = 9e9;   
    
    public static double distanciaDosPuntos(Punto punto, Cargas carga)
    {        
        return Math.hypot(punto.getX()-carga.getX(), punto.getY()-carga.getY());
    }
    
    public static double calcularpotencial(List<Punto> punto, List<Cargas> carga)
    {        
        return 0.0;
    }
}
