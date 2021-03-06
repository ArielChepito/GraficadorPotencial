/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desafio1.Form;

import Desafio1.Entidades.Cargas;
import Desafio1.Entidades.Punto;
import Desafio1.Entidades.Vector;
import Desafio1.PlanoCartesiano;
import Desafio1.Utils.Physics;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 *
 * @author chepito
 */
public class form extends javax.swing.JFrame {

    JPanel planoCartesiano; 
    List<Cargas> listaCarga = new ArrayList<>();
    List<Punto> listaPunto = new ArrayList<>();
    
    public form() {
        initComponents();      
        
        Vector dim = new Vector(Contenedor.getWidth(),Contenedor.getHeight()); 
        planoCartesiano = new PlanoCartesiano(dim);              
        JScrollPane scrollPanel = new JScrollPane(planoCartesiano);       
        Contenedor.setLayout(new BorderLayout());
        Contenedor.add(scrollPanel, BorderLayout.CENTER); 
        Contenedor.setPreferredSize( new Dimension(dim.X,dim.Y));
    }    
    void insertarPunto(){  
        try {
            String[] strDatos = txtPunto.getText().split(",");
            Punto punto = new Punto(
                    Integer.parseInt(strDatos[0]),
                    Integer.parseInt(strDatos[1])    
            );
            listaPunto.add(punto);
            txtPunto.setText("");
            PlanoCartesiano.listaPunto = listaPunto;
            planoCartesiano.repaint();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: "+e.getMessage());
            txtPunto.setText("");
        }
                
       
    }
    void insertarCarga(){        
        try {
            String[] strDatos = txtCarga.getText().split(",");      
            BigDecimal cargarel = new BigDecimal("0.000");
            if(cmbUnidad.getSelectedIndex() != 0){
                cargarel = Physics.internationalSystemUnits(cmbUnidad.getSelectedIndex(),BigDecimal.valueOf(Double.parseDouble(strDatos[0])));       
            }
            else{
                 cargarel =  BigDecimal.valueOf(Double.parseDouble(strDatos[0]));
            }  
            Cargas carga = new Cargas(
                    cargarel,
                    Integer.parseInt(strDatos[1]),
                    Integer.parseInt(strDatos[2])       
            );              
            listaCarga.add(carga);
            txtCarga.setText("");
            PlanoCartesiano.listaCarga = listaCarga;
            planoCartesiano.repaint();
        } catch (Exception e) {
            txtCarga.setText("");
        }
    }
    void calcularPotencial(){    
        
       BigDecimal resultado= new BigDecimal ("0.000");
       for(Punto punto : listaPunto){
           for(Cargas carga : listaCarga){              
                resultado= resultado.add( Physics.calcularpotencial(punto, carga));                
                punto.setPotencial(resultado);
           }
           resultado= new BigDecimal ("0.000");
           this.cmbResultado.addItem(punto+"");
       }       
       planoCartesiano.repaint();
    }
    void limpiar()
    {
        listaCarga = new ArrayList<>();    
        listaPunto = new ArrayList<>();     
        PlanoCartesiano.listaCarga = listaCarga;
        PlanoCartesiano.listaPunto = listaPunto;
        this.cmbResultado.removeAllItems();
        this.txtCarga.setText("");
        this.txtPunto.setText("");
        this.planoCartesiano.repaint();
        Cargas.contador = 1;
        Punto.contador = 1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCarga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPunto = new javax.swing.JTextField();
        btnPunto = new javax.swing.JButton();
        cmbUnidad = new javax.swing.JComboBox<>();
        cmbResultado = new javax.swing.JComboBox<>();
        btnSettings = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CALCULAR POTENCIAL");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Contenedor.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(Contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 500));

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 570, -1, -1));

        jLabel1.setText("Ingresa las cargas (Carga, x,y) :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, -1, 27));

        txtCarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCargaKeyPressed(evt);
            }
        });
        getContentPane().add(txtCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 110, 30));

        jLabel2.setText("Resultado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 630, -1, -1));

        btnCalcular.setText("Calcular");
        btnCalcular.setFocusable(false);
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 620, 94, -1));

        jLabel3.setText("Ingrese Punto (x, y ):");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, -1, -1));

        txtPunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPuntoKeyPressed(evt);
            }
        });
        getContentPane().add(txtPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 220, 30));

        btnPunto.setText("Ingresar");
        btnPunto.setFocusable(false);
        btnPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, -1, -1));

        cmbUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguna", "YOTTA", "ZETTA", "EXA", "PETA", "TERA", "GIGA", "MEGA", "KILO", "MILI", "MICRO", "NANO", "PICO", "FEMTO", "ATTO", "ZAPTO", "YOCTO" }));
        getContentPane().add(cmbUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 570, 90, 30));

        getContentPane().add(cmbResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 620, 220, -1));

        btnSettings.setText("SETTINGS");
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 620, -1, -1));

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 570, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        insertarCarga();
    }//GEN-LAST:event_btnIngresarActionPerformed
    
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        calcularPotencial();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtCargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            insertarCarga();
         }
    }//GEN-LAST:event_txtCargaKeyPressed

    private void btnPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuntoActionPerformed
       insertarPunto();
    }//GEN-LAST:event_btnPuntoActionPerformed

    private void txtPuntoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuntoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
             insertarPunto();
         }
    }//GEN-LAST:event_txtPuntoKeyPressed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        Conf conf = new Conf(this, true);       
        conf.setLocation(100,100);
        conf.setVisible(true);
        planoCartesiano.repaint();
    }//GEN-LAST:event_btnSettingsActionPerformed
   
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       limpiar();
    }//GEN-LAST:event_btnResetActionPerformed
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {            
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"  );                  
                
        } catch (Exception ex) {
            
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                new form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnPunto;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSettings;
    private javax.swing.JComboBox<String> cmbResultado;
    private javax.swing.JComboBox<String> cmbUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCarga;
    private javax.swing.JTextField txtPunto;
    // End of variables declaration//GEN-END:variables
}
