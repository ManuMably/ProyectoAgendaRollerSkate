/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author zTMike
 */
public class Perfil extends javax.swing.JFrame {

    /**
     * Creates new form Perfil
     */
    public Perfil() {
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

        LabelIconoPersonal = new javax.swing.JLabel();
        Volver = new javax.swing.JLabel();
        Cerrar = new javax.swing.JLabel();
        Minimizar = new javax.swing.JLabel();
        LabelContra = new javax.swing.JLabel();
        LabelContra1 = new javax.swing.JLabel();
        LabelContra2 = new javax.swing.JLabel();
        LabelContra3 = new javax.swing.JLabel();
        LabelContra4 = new javax.swing.JLabel();
        LabelContra5 = new javax.swing.JLabel();
        LineaBajoOlvideContra = new javax.swing.JLabel();
        LineaBajoOlvideContra1 = new javax.swing.JLabel();
        LineaBajoOlvideContra2 = new javax.swing.JLabel();
        LabelContra6 = new javax.swing.JLabel();
        TituloInicioSesion = new javax.swing.JLabel();
        LabelContra7 = new javax.swing.JLabel();
        LabelContra8 = new javax.swing.JLabel();
        LabelContra9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelIconoPersonal.setIcon(null);
        getContentPane().add(LabelIconoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 290, 260));
        Random random = new Random();

        // Generar un número aleatorio entre 1 y 10
        int aleatorio = random.nextInt(5) + 1;
        switch (aleatorio) {
            case 1:
            LabelIconoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/perroGrande.png")));
            break;
            case 2:
            LabelIconoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/abejaGrande.png")));
            break;
            case 3:
            LabelIconoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/polloGrande.png")));
            break;
            case 4:
            LabelIconoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/buhoGrande.png")));
            break;
            case 5:
            LabelIconoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/vacaGrande.png")));

            break;
        }

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

        LabelContra.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra.setForeground(new java.awt.Color(20, 44, 44));
        LabelContra.setText("Documento :");
        getContentPane().add(LabelContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 160, 30));

        LabelContra1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelContra1.setForeground(new java.awt.Color(255, 255, 255));
        LabelContra1.setText("Hector Fabio Garcia Isaza");
        getContentPane().add(LabelContra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 660, 260, 30));

        LabelContra2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra2.setForeground(new java.awt.Color(203, 197, 232));
        LabelContra2.setText("Perfil");
        getContentPane().add(LabelContra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 720, 80, 30));

        LabelContra3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra3.setForeground(new java.awt.Color(203, 197, 232));
        LabelContra3.setText("Correo");
        getContentPane().add(LabelContra3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 80, 30));

        LabelContra4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelContra4.setForeground(new java.awt.Color(255, 255, 255));
        LabelContra4.setText("Instructor");
        getContentPane().add(LabelContra4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 750, 260, 30));

        LabelContra5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelContra5.setForeground(new java.awt.Color(255, 255, 255));
        LabelContra5.setText("He.fa.g.i@hotmail.com");
        getContentPane().add(LabelContra5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 260, 30));

        LineaBajoOlvideContra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LineaBajoOlvideContra.setForeground(new java.awt.Color(204, 196, 235));
        LineaBajoOlvideContra.setText("_____________________________");
        getContentPane().add(LineaBajoOlvideContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 660, 220, 30));

        LineaBajoOlvideContra1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LineaBajoOlvideContra1.setForeground(new java.awt.Color(204, 196, 235));
        LineaBajoOlvideContra1.setText("_____________________________");
        getContentPane().add(LineaBajoOlvideContra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 750, 220, 30));

        LineaBajoOlvideContra2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LineaBajoOlvideContra2.setForeground(new java.awt.Color(204, 196, 235));
        LineaBajoOlvideContra2.setText("_____________________________");
        getContentPane().add(LineaBajoOlvideContra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 220, 30));

        LabelContra6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra6.setForeground(new java.awt.Color(203, 197, 232));
        LabelContra6.setText("Nombre");
        getContentPane().add(LabelContra6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 110, 30));

        TituloInicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        TituloInicioSesion.setForeground(new java.awt.Color(203, 197, 232));
        TituloInicioSesion.setText("Perfil");
        getContentPane().add(TituloInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 170, 110));

        LabelContra7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra7.setForeground(new java.awt.Color(20, 44, 44));
        LabelContra7.setText("Edad :");
        getContentPane().add(LabelContra7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 80, 30));

        LabelContra8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra8.setForeground(new java.awt.Color(20, 44, 44));
        LabelContra8.setText("Direccion :");
        getContentPane().add(LabelContra8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 160, 30));

        LabelContra9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LabelContra9.setForeground(new java.awt.Color(20, 44, 44));
        LabelContra9.setText("Nombre :");
        getContentPane().add(LabelContra9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 110, 30));

        jTextField1.setForeground(new java.awt.Color(20, 44, 44));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 160, 30));

        jTextField2.setForeground(new java.awt.Color(20, 44, 44));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 160, 30));

        jTextField3.setForeground(new java.awt.Color(20, 44, 44));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 160, 30));

        jTextField4.setForeground(new java.awt.Color(20, 44, 44));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 160, 30));

        Fondo.setForeground(new java.awt.Color(20, 44, 44));
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/Imagenes/FondoPerfil.png"))); // NOI18N
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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel LabelContra;
    private javax.swing.JLabel LabelContra1;
    private javax.swing.JLabel LabelContra2;
    private javax.swing.JLabel LabelContra3;
    private javax.swing.JLabel LabelContra4;
    private javax.swing.JLabel LabelContra5;
    private javax.swing.JLabel LabelContra6;
    private javax.swing.JLabel LabelContra7;
    private javax.swing.JLabel LabelContra8;
    private javax.swing.JLabel LabelContra9;
    private javax.swing.JLabel LabelIconoPersonal;
    private javax.swing.JLabel LineaBajoOlvideContra;
    private javax.swing.JLabel LineaBajoOlvideContra1;
    private javax.swing.JLabel LineaBajoOlvideContra2;
    private javax.swing.JLabel Minimizar;
    private javax.swing.JLabel TituloInicioSesion;
    private javax.swing.JLabel Volver;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
