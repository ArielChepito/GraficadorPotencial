package Desafio1.Form;

import Desafio1.Grafica;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

    public class Formulario extends JFrame
    {        
        Formulario(){
            setSize(900,690);//500,350
            setTitle("interfaz grafica");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false); 
            Container Contenedor = getContentPane();
            Grafica mipanel = new Grafica(Contenedor);    
            this.add(mipanel);              
            setVisible(true);
            //setLocationRelativeTo(null);
        }
    }
