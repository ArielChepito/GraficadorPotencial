
package Desafio1;

import Desafio1.Entidades.Cargas;
import Desafio1.Entidades.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

public class Grafica extends JPanel
{  
    JPanel panelContenedor = new JPanel(); 
    JScrollPane scrollPanel;       
    JPanel panelGrafico; 
    
    public Grafica(Container Contenedor)
    {                           

        panelGrafico = new PlanoCartesiano(new Vector(890,483)); //zona grafica        
        scrollPanel = new JScrollPane(panelGrafico);///////        
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.add(scrollPanel, BorderLayout.CENTER);//panelGrafico       
        //panelContenedor.setPreferredSize( new Dimension(dimension.X,dimension.Y));     
        panelContenedor.setPreferredSize( new Dimension(890,483));     
        Contenedor.setLayout(new BorderLayout());
        Contenedor.add("North",panelContenedor);   
        	
        
    }
    public static class PlanoCartesiano extends JPanel  implements MouseListener, MouseMotionListener, MouseWheelListener
    {
        public int prueba;
        Vector dimension = new Vector();
        Vector PuntosMinimos = new Vector();
        Vector PuntosMaximos =  new Vector();
        Vector espaciado= new Vector(); 
        Vector origen = new Vector();
        Vector zoom= new Vector();   
        boolean arrastrando; 
        Font fuenteNumeros  = new Font("Arial",Font.PLAIN,10);
        Color colorCuadricula = new Color(49,173,215);
        Color colorNumero = new Color(255,255,255);
        Color colorCarga = new Color(233,30,99);
        Color colorPunto = new Color(76,175,80);
        ImageIcon imageIcon;      
        int escala;  
        int aumento; 
        
        static List<Cargas> lista;
         
        
        public PlanoCartesiano(Vector dim) 
        {
            dimension.set(dim);
            //dimension.set(890,483);   
            imageIcon = new ImageIcon(getClass().getResource("Assets/background.jpg"));  //imagen de fondo 
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
             if(lista != null)
            {
                if(lista.size() > 1)
                {
                    InsertarCargas(g);
                }
            }
             
        } 
        
        void Graficar(Graphics ap)
        {
            ap.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), null);      
            //convertimos el objeto ap en un objeto Graphics2D para usar los mŽtodos Java2D
            Graphics2D g = (Graphics2D) ap;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setFont(fuenteNumeros);            

            //PINTAMOS EL EJE X Y EL EJE Y
            g.draw(new Line2D.Double(origen.X, 10, origen.X, dimension.Y-10)); //EJE Y
            g.draw(new Line2D.Double(10, origen.Y, dimension.X-10, origen.Y));//EJE X
            
            PuntosMinimos.X=(int)Math.round(-1.0*origen.X/zoom.X); //pantalla
            PuntosMaximos.X=(int)Math.round(1.0*(dimension.X-origen.X)/zoom.X);
            
            PuntosMinimos.Y=(int)Math.round(1.0*(origen.Y-dimension.Y)/zoom.Y);
            PuntosMaximos.Y=(int)Math.round(1.0*origen.Y/zoom.Y);
            
            g.setPaint(colorCuadricula); 
            g.setFont(fuenteNumeros);

            //PINTAMOS TODOS LOS EJES PARA FORMAR LA CUADRICULA
            
                for(int i=PuntosMinimos.X;i<=PuntosMaximos.X;i++)
                {   //EJES PARALELOS AL EJE Y
                    g.setPaint(colorCuadricula); 
                    g.draw(new Line2D.Double(origen.X+i*zoom.X, origen.Y-2, origen.X+i*zoom.X , origen.Y+2));
                    if( (origen.X+i*zoom.X) != origen.X ){
                        g.draw(new Line2D.Double(origen.X+i*zoom.X, 10, origen.X+i*zoom.X, dimension.Y-10));
                    }
                    if(i<0){
                        g.setPaint(colorNumero);
                        g.drawString(""+i*escala, origen.X+i*zoom.X-8, origen.Y+12);
                    }
                    if(i>0){
                        g.setPaint(colorNumero);
                        g.drawString(""+i*escala, origen.X+i*zoom.X-aumento, origen.Y+12);
                    }
                    
                }
                for(int i=PuntosMinimos.Y+1;i<PuntosMaximos.Y;i++)
                {   //EJES PARALELOS AL EJE X
                    g.setPaint(colorCuadricula); 
                    g.draw(new Line2D.Double(origen.X-2, origen.Y-i*zoom.Y, origen.X+2 , origen.Y-i*zoom.Y));
                    if( (origen.Y-i*zoom.Y) != origen.Y ){
                        g.draw(new Line2D.Double(10, origen.Y-i*zoom.Y, dimension.X-10, origen.Y-i*zoom.Y));
                    }
                    if(i<0){
                        g.setPaint(colorNumero);
                        g.drawString(""+i*escala, origen.X-14,origen.Y-i*zoom.Y+8 );
                    }
                    if(i>0){
                        g.setPaint(colorNumero);
                        g.drawString(""+i*escala, origen.X-12,origen.Y-i*zoom.Y+8 );
                    }
                    
                }
                lista = new ArrayList<>();
                lista.add(new Cargas(30,5,10));
                lista.add(new Cargas(60,10,3));
                lista.add(new Cargas(40,7,-5));
                lista.add(new Cargas(10,-5,2));
        }
        public void InsertarCargas(Graphics ap)
        {
                Graphics2D g = (Graphics2D) ap;
                
                
                int contador = 1;
                for(int c = 0; c < lista.size(); c++){
                
                    for(int y=PuntosMinimos.Y+1;y<PuntosMaximos.Y;y++)
                    {   
                        for(int x=PuntosMinimos.X;x<=PuntosMaximos.X;x++)
                        {

                            if(lista.get(c).getY() == y/escala && lista.get(c).getX() == x/escala)
                            {       
                                int r = 20;                                
                                g.setColor(colorCarga);                            
                                g.fillOval(origen.X+x*zoom.X-8,origen.Y-y*zoom.Y-8 ,r,r);
                                 g.setPaint(colorNumero);
                                g.drawString("Q"+contador,origen.X+x*zoom.X-4,origen.Y-y*zoom.Y+4);
                                contador++;
                            }
                        }
                    }                
                }   
        }
    } 
} 





