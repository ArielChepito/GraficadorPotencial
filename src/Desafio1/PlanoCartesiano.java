
package Desafio1;

import Desafio1.Utils.Assets;
import Desafio1.Entidades.Cargas;
import Desafio1.Entidades.Punto;
import Desafio1.Entidades.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;


    public class PlanoCartesiano extends JPanel  implements MouseListener, MouseMotionListener, MouseWheelListener
    {
        public int prueba;
        Vector dimension = new Vector();
        Vector PuntosMinimos = new Vector();
        Vector PuntosMaximos =  new Vector();
        Vector espaciado= new Vector(); 
        Vector origen = new Vector();
        Vector zoom= new Vector();   
        boolean arrastrando;    
        public static boolean cuadricula= true;
        public static boolean numeros = true;
        public static boolean raya = true;
       
        ImageIcon imageIcon;      
        int escala;  
        int aumento;         
        public static List<Cargas> listaCarga;         
        public static List<Punto> listaPunto;         
        
        public PlanoCartesiano(Vector dim) 
        {
            dimension.set(dim);   
            imageIcon = new ImageIcon(getClass().getResource(Assets.rutaImagen));  
            espaciado.set(origen);
            escala =1;
            zoom.set(30);
            origen.set(dimension.divide(2));        
            aumento=7;
            addMouseListener(this);
            addMouseMotionListener(this);
            addMouseWheelListener(this);
        }


        public void mousePressed(MouseEvent evt)
        {
            if (arrastrando)
                return;            
            espaciado.set(origen.inSubtr(evt.getX(), evt.getY()));            
            arrastrando = true;
        }

        public void mouseReleased(MouseEvent evt)
        {
            arrastrando = false;
            repaint();
        }

        public void mouseDragged(MouseEvent evt)
        {
            if (arrastrando == false)
                return;
           
            origen.set(espaciado.inSubtr(evt.getX(), evt.getY()));                          
            repaint();            
        }

        public void mouseWheelMoved(MouseWheelEvent evt) {
            int Zoom = evt.getWheelRotation();            
            zoom.add(-Zoom);
            repaint();
        }

               //el resto hace nada 
        public void mouseMoved(MouseEvent evt) {}
        public void mouseClicked(MouseEvent evt) { }
        public void mouseEntered(MouseEvent evt) { }
        public void mouseExited(MouseEvent evt) { }

        public  void paintComponent(Graphics g)
        {
             super.paintComponent(g);
             Graficar(g);  
             
             
             if(listaCarga != null)
            {
                if(listaCarga.size() > 0)
                {
                    InsertarCargas(g);
                }
            }
             if(listaPunto != null)
            {
                if(listaPunto.size() > 0)
                {
                    InsertarPuntos(g);
                }
            }
             
        } 
        
        void Graficar(Graphics ap)
        {
            ap.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), null);      
            
            Graphics2D g = (Graphics2D) ap;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setFont(Assets.fuenteNumeros);            

            //PINTAMOS EL EJE X Y EL EJE Y
            g.setPaint(Assets.colorLinea); 
            g.draw(new Line2D.Double(origen.X, 10, origen.X, dimension.Y-10)); //EJE Y
            g.draw(new Line2D.Double(10, origen.Y, dimension.X-10, origen.Y));//EJE X
            
            PuntosMinimos.X=(int)Math.round(-1.0*origen.X/zoom.X); //pantalla
            PuntosMaximos.X=(int)Math.round(1.0*(dimension.X-origen.X)/zoom.X);
            
            PuntosMinimos.Y=(int)Math.round(1.0*(origen.Y-dimension.Y)/zoom.Y);
            PuntosMaximos.Y=(int)Math.round(1.0*origen.Y/zoom.Y);
            
            g.setPaint(Assets.colorCuadricula); 
            g.setFont(Assets.fuenteNumeros);
                    
              
            for(int i=PuntosMinimos.X;i<=PuntosMaximos.X;i++)
            {   
                if(raya)
                {
                    g.setPaint(Assets.colorCuadricula); 
                    g.draw(new Line2D.Double(origen.X+i*zoom.X, origen.Y-2, origen.X+i*zoom.X , origen.Y+2));
                }
                if(cuadricula)
                {
                    if( (origen.X+i*zoom.X) != origen.X ){
                    g.draw(new Line2D.Double(origen.X+i*zoom.X, 10, origen.X+i*zoom.X, dimension.Y-10));
                    }
                }
                if(numeros)
                {   
                    if(i<0){
                        g.setPaint(Assets.colorNumero);
                        g.drawString(""+i*escala, origen.X+i*zoom.X-8, origen.Y+12);
                    }
                    if(i>0){
                        g.setPaint(Assets.colorNumero);
                        g.drawString(""+i*escala, origen.X+i*zoom.X-aumento, origen.Y+12);
                    }
                }
            }
            for(int i=PuntosMinimos.Y+1;i<PuntosMaximos.Y;i++)
            {  
                if(raya)
                {   
                    g.setPaint(Assets.colorCuadricula); 
                    g.draw(new Line2D.Double(origen.X-2, origen.Y-i*zoom.Y, origen.X+2 , origen.Y-i*zoom.Y));
                }
                if(cuadricula)
                {
                    if( (origen.Y-i*zoom.Y) != origen.Y ){
                        g.draw(new Line2D.Double(10, origen.Y-i*zoom.Y, dimension.X-10, origen.Y-i*zoom.Y));
                    }

                }
                if(numeros)
                { 
                    if(i<0){
                        g.setPaint(Assets.colorNumero);
                        g.drawString(""+i*escala, origen.X-14,origen.Y-i*zoom.Y+8 );
                    }
                    if(i>0){
                        g.setPaint(Assets.colorNumero);
                        g.drawString(""+i*escala, origen.X-12,origen.Y-i*zoom.Y+8 );
                    } 
                }

            }
                
                            
        }
        public void InsertarCargas(Graphics ap)
        {
                Graphics2D g = (Graphics2D) ap;
                int contador = 1;
                for(int c = 0; c < listaCarga.size(); c++){
                
                    for(int y=PuntosMinimos.Y+1;y<PuntosMaximos.Y;y++)
                    {   
                        for(int x=PuntosMinimos.X;x<=PuntosMaximos.X;x++)
                        {
                            if(listaCarga.get(c).getY() == y/escala && listaCarga.get(c).getX() == x/escala)
                            {       
                                int r = 20;                                
                                g.setColor(Assets.colorCarga);                            
                                g.fillOval(origen.X+x*zoom.X-8,origen.Y-y*zoom.Y-8 ,r,r);
                                 g.setPaint(Assets.colorNumero);
                                g.drawString("Q"+contador,origen.X+x*zoom.X-4,origen.Y-y*zoom.Y+4);
                                contador++;
                            }
                        }
                    }                
                }   
        }
        public void InsertarPuntos(Graphics ap)
        {
                Graphics2D g = (Graphics2D) ap;
                int contador = 1;
                for(int c = 0; c < listaPunto.size(); c++){
                
                    for(int y=PuntosMinimos.Y+1;y<PuntosMaximos.Y;y++)
                    {   
                        for(int x=PuntosMinimos.X;x<=PuntosMaximos.X;x++)
                        {
                            if(listaPunto.get(c).getY() == y/escala && listaPunto.get(c).getX() == x/escala)
                            {       
                                int r = 20;                                
                                g.setColor(Assets.colorPunto);                            
                                g.fillOval(origen.X+x*zoom.X-8,origen.Y-y*zoom.Y-8 ,r,r);
                                 g.setPaint(Assets.colorNumero);
                                g.drawString("A"+contador,origen.X+x*zoom.X-4,origen.Y-y*zoom.Y+4);
                                contador++;
                            }
                        }
                    }                
                }   
        }
    } 