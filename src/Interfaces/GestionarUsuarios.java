/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import javax.swing.JFrame;

/**
 *
 * @author zTMike
 */
public class GestionarUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarCitas
     */
    public GestionarUsuarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Volver = new javax.swing.JLabel();
        Cerrar = new javax.swing.JLabel();
        Minimizar = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        BtnIniciarSesion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        LabelContra9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        TituloInicioSesion = new javax.swing.JLabel();
        LabelContra10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        LabelContra11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        LabelContra12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/VolverBlanco.png"))); // NOI18N
        Volver.setMaximumSize(new java.awt.Dimension(32, 33));
        Volver.setMinimumSize(new java.awt.Dimension(32, 33));
        Volver.setPreferredSize(new java.awt.Dimension(32, 33));
        Volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VolverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VolverMouseExited(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/Cerrar.png"))); // NOI18N
        Cerrar.setMaximumSize(new java.awt.Dimension(32, 33));
        Cerrar.setMinimumSize(new java.awt.Dimension(32, 33));
        Cerrar.setPreferredSize(new java.awt.Dimension(32, 33));
        Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CerrarMouseExited(evt);
            }
        });
        getContentPane().add(Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 0, -1, -1));

        Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/Minimizar.png"))); // NOI18N
        Minimizar.setMaximumSize(new java.awt.Dimension(32, 33));
        Minimizar.setMinimumSize(new java.awt.Dimension(32, 33));
        Minimizar.setPreferredSize(new java.awt.Dimension(32, 33));
        Minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizarMouseExited(evt);
            }
        });
        getContentPane().add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 0, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 230, 30));

        BtnIniciarSesion.setBackground(new java.awt.Color(153, 153, 255));
        BtnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnIniciarSesion.setText("Consultar");
        BtnIniciarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnIniciarSesion.setBorderPainted(false);
        BtnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnIniciarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnIniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnIniciarSesionMouseExited(evt);
            }
        });
        BtnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(BtnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 200, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 196, 235));
        jLabel3.setText("Documento :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        LabelContra9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra9.setForeground(new java.awt.Color(20, 44, 44));
        LabelContra9.setText("Nombre :");
        getContentPane().add(LabelContra9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 110, 30));

        jTextField2.setForeground(new java.awt.Color(20, 44, 44));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 160, 30));

        TituloInicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        TituloInicioSesion.setForeground(new java.awt.Color(203, 197, 232));
        TituloInicioSesion.setText("Perfil");
        getContentPane().add(TituloInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 170, 110));

        LabelContra10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra10.setForeground(new java.awt.Color(20, 44, 44));
        LabelContra10.setText("Contraseña :");
        getContentPane().add(LabelContra10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 150, 30));

        jTextField3.setForeground(new java.awt.Color(20, 44, 44));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 160, 30));

        LabelContra11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra11.setForeground(new java.awt.Color(20, 44, 44));
        LabelContra11.setText("Direccion :");
        getContentPane().add(LabelContra11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 130, 30));

        jTextField4.setForeground(new java.awt.Color(20, 44, 44));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, 160, 30));

        LabelContra12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra12.setForeground(new java.awt.Color(20, 44, 44));
        LabelContra12.setText("Tipo de usuario :");
        getContentPane().add(LabelContra12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 200, 30));

        jTextField5.setForeground(new java.awt.Color(20, 44, 44));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, 160, 30));

        Fondo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/FondoConsultas.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseClicked
        dispose();
        JFrame Menu = new Menu();
        Menu.setVisible(true);
    }//GEN-LAST:event_VolverMouseClicked

    private void VolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseEntered
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/VolverVerde.png"))); // NOI18N
    }//GEN-LAST:event_VolverMouseEntered

    private void VolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseExited
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/VolverBlanco.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_VolverMouseExited

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
        dispose();
    }//GEN-LAST:event_CerrarMouseClicked

    private void CerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseEntered
        Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/cerrarrosa.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_CerrarMouseEntered

    private void CerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseExited
        Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/Cerrar.png")));
    }//GEN-LAST:event_CerrarMouseExited

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinimizarMouseClicked

    private void MinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseEntered
        Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/Minimizarverde.png"))); // NOI18N
    }//GEN-LAST:event_MinimizarMouseEntered

    private void MinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseExited
        Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/Minimizar.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_MinimizarMouseExited

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void BtnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIniciarSesionMouseClicked
        dispose();
        JFrame menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_BtnIniciarSesionMouseClicked

    private void BtnIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIniciarSesionMouseEntered
        // TODO add your handling code here:
        BtnIniciarSesion.setBackground(new java.awt.Color(103, 87, 164));
        BtnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));

    }//GEN-LAST:event_BtnIniciarSesionMouseEntered

    private void BtnIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIniciarSesionMouseExited
        BtnIniciarSesion.setBackground(new java.awt.Color(153, 153, 255));
        BtnIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_BtnIniciarSesionMouseExited

    private void BtnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarSesionActionPerformed

    }//GEN-LAST:event_BtnIniciarSesionActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIniciarSesion;
    private javax.swing.JLabel Cerrar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel LabelContra10;
    private javax.swing.JLabel LabelContra11;
    private javax.swing.JLabel LabelContra12;
    private javax.swing.JLabel LabelContra9;
    private javax.swing.JLabel Minimizar;
    private javax.swing.JLabel TituloInicioSesion;
    private javax.swing.JLabel Volver;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}