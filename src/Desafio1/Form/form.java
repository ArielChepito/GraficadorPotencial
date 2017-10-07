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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
        
        PlanoCartesiano.cuadricula = false;
        PlanoCartesiano.numeros = true;
        PlanoCartesiano.raya = false;
        
        JScrollPane scrollPanel = new JScrollPane(planoCartesiano);       
        Contenedor.setLayout(new BorderLayout());
        Contenedor.add(scrollPanel, BorderLayout.CENTER); 
        Contenedor.setPreferredSize( new Dimension(dim.X,dim.Y));
    }    
    void insertarPunto(){        
       String[] strDatos = txtPunto.getText().split(",");
       Punto punto = new Punto(
               Integer.parseInt(strDatos[0]),
               Integer.parseInt(strDatos[1])    
       );
       listaPunto.add(punto);
       txtPunto.setText("");
       PlanoCartesiano.listaPunto = listaPunto;
       planoCartesiano.repaint();
    }
    void insertarCarga(){        
       String[] strDatos = txtCarga.getText().split(",");       
       Cargas carga = new Cargas(
               Integer.parseInt(strDatos[0]),
               Integer.parseInt(strDatos[1]),
               Integer.parseInt(strDatos[2])       
       );       
       if(this.cmbUnidad.getSelectedIndex() == 0)
       {
           System.out.println("nano");
       }
       listaCarga.add(carga);
       txtPunto.setText("");
       PlanoCartesiano.listaCarga = listaCarga;
       planoCartesiano.repaint();
    }
    void calcularPotencial(){        
       Physics.calcularpotencial(listaPunto, listaCarga);
       planoCartesiano.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCarga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPunto = new javax.swing.JTextField();
        btnPunto = new javax.swing.JButton();
        cmbUnidad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 570, -1, -1));

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
        getContentPane().add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 620, 206, 30));

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 620, 94, -1));

        jLabel3.setText("Ingrese Punto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, -1, -1));

        txtPunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPuntoKeyPressed(evt);
            }
        });
        getContentPane().add(txtPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 200, 30));

        btnPunto.setText("Ingresar");
        btnPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, -1, -1));

        cmbUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nano" }));
        getContentPane().add(cmbUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 570, 70, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        insertarCarga();
    }//GEN-LAST:event_btnIngresarActionPerformed
    
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
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
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> cmbUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCarga;
    private javax.swing.JTextField txtPunto;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
}
