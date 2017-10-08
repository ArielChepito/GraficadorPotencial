/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desafio1.Utils;

import Desafio1.Entidades.Cargas;
import Desafio1.Entidades.Punto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author chepito
 */
public class Physics {
    
    
    private static final BigDecimal YOTTA = new BigDecimal("1e24");
    private static final BigDecimal ZETTA = new BigDecimal("1e21");
    private static final BigDecimal EXA = new BigDecimal("1e18");
    private static final BigDecimal PETA = new BigDecimal("1e15");
    private static final BigDecimal TERA = new BigDecimal("1e12");
    private static final BigDecimal GIGA = new BigDecimal("1e9");
    private static final BigDecimal MEGA = new BigDecimal("1e6");
    private static final BigDecimal KILO = new BigDecimal("1e3");
    private static final BigDecimal MILI = new BigDecimal("1E-3");
    private static final BigDecimal MICRO = new BigDecimal("1e-6");
    private static final BigDecimal NANO = new BigDecimal("1e-9");
    private static final BigDecimal PICO = new BigDecimal("1e-12");
    private static final BigDecimal FEMTO = new BigDecimal("1e-15");
    private static final BigDecimal ATTO = new BigDecimal("1e-18");
    private static final BigDecimal ZAPTO = new BigDecimal("1e-21");
    private static final BigDecimal YOCTO = new BigDecimal("1e-24");
    public static  final BigDecimal constant = new BigDecimal("9e9") ;       
    public static boolean cm = true;    
    
    public static BigDecimal distanciaDosPuntos(Punto punto, Cargas carga)
    {   
        BigDecimal resultado = BigDecimal.valueOf(Math.hypot(punto.getX()-carga.getX(), punto.getY()-carga.getY()));        
        if(cm) resultado = resultado.divide(BigDecimal.valueOf(100)); 
        return resultado.setScale(2, RoundingMode.FLOOR);
    }   
    public static BigDecimal calcularpotencial(Punto punto, Cargas carga)
    {   
        BigDecimal Arriba = Physics.constant.multiply(carga.getCarga());
        BigDecimal abajo = Arriba.divide(distanciaDosPuntos(punto,carga), 2, RoundingMode.HALF_UP);       
        return abajo;
    }
    public static BigDecimal internationalSystemUnits(int index, BigDecimal num)
    {
        BigDecimal resultado = new BigDecimal("0.000");
        switch(index)
        {            
            case 1: resultado =  num.multiply(YOTTA) ; break;
            case 2: resultado=  num.multiply(ZETTA);  break;
            case 3: resultado =  num.multiply(EXA); break;
            case 4: resultado=  num.multiply(PETA);  break;
            case 5: resultado =  num.multiply(TERA); break;
            case 6: resultado=  num.multiply(GIGA);  break;
            case 7: resultado =  num.multiply(MEGA); break;
            case 8: resultado=  num.multiply(KILO);  break;
            case 9: resultado =  num.multiply(MILI); break;
            case 10: resultado=  num.multiply(MICRO);  break;
            case 11: resultado =  num.multiply(NANO); break;
            case 12: resultado=  num.multiply(PICO);  break;
            case 13: resultado=  num.multiply(FEMTO);  break;
            case 14: resultado =  num.multiply(ATTO); break;
            case 15: resultado=  num.multiply(ZAPTO);  break;
            case 16: resultado=  num.multiply(YOCTO);  break;
        }
    
        return resultado;
    }
}
