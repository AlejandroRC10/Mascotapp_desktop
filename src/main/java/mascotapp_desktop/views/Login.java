/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.views;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mascotapp_desktop.controllers.VeterinarioController;
import mascotapp_desktop.util.MascotappUtilImpl;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase que inicia la aplicación desde la pantalla de Login
 */
public class Login extends javax.swing.JFrame {

    /**
     * Crea un formulario de Login
     */
    public Login() {
        initComponents();

        setTitle("MASCOTAPP");
                
        initImage();
    }

    /**
     * Mëtodo que inicializa la imagen del Logotipo
     */
    private void initImage() {
        ImageIcon img = new ImageIcon(getClass().getResource("/mascotapp_desktop/resources/mascotapp.png"));
        jlabelImagen.setIcon(img);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jpfPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jpfRepeatPassword = new javax.swing.JPasswordField();
        jbRegistro = new javax.swing.JButton();
        jbInicioSesion = new javax.swing.JButton();
        jlabelImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelLogin.setBackground(new java.awt.Color(0, 128, 55));
        jPanelLogin.setForeground(new java.awt.Color(255, 255, 255));
        jPanelLogin.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N

        jpfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfPasswordActionPerformed(evt);
            }
        });

        jLabel2.setFont(jPanelLogin.getFont());
        jLabel2.setForeground(jPanelLogin.getForeground());
        jLabel2.setText("Contraseña:");

        jLabel1.setFont(jPanelLogin.getFont());
        jLabel1.setForeground(jPanelLogin.getForeground());
        jLabel1.setText("Usuario:");

        jLabel3.setFont(jPanelLogin.getFont());
        jLabel3.setForeground(jPanelLogin.getForeground());
        jLabel3.setText("Repetir contraseña:");

        jpfRepeatPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfRepeatPasswordActionPerformed(evt);
            }
        });

        jbRegistro.setFont(jPanelLogin.getFont());
        jbRegistro.setText("Registrarse");
        jbRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistroActionPerformed(evt);
            }
        });

        jbInicioSesion.setFont(jLabel3.getFont());
        jbInicioSesion.setText("Iniciar Sesión");
        jbInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInicioSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jbInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpfRepeatPassword)
                            .addComponent(jpfPassword)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jlabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jpfRepeatPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfPasswordActionPerformed

    private void jpfRepeatPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfRepeatPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfRepeatPasswordActionPerformed

    private void jbInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInicioSesionActionPerformed
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
                iniciarSesion();
//            }
//        }).start();

    }//GEN-LAST:event_jbInicioSesionActionPerformed

    /**
     * Mëtodo para iniciar sesión Crea un HashMap con el usuario y contraseña
     * que será enviado en la petición
     */
    private void iniciarSesion() {
        VeterinarioController vc = new VeterinarioController();
        
        
        String password = new String(jpfPassword.getPassword());
        String password2 = new String(jpfRepeatPassword.getPassword());

        
        Map<String, String> loginMap = new HashMap();

        loginMap.put("password", password);
        loginMap.put("usuario", jtfUsuario.getText());

        if (password.equals(password2)) {
            if (vc.login(loginMap)) {
                VentanaPrincipal vp = new VentanaPrincipal();
                vp.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos", "Mascotapp Login", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Mascotapp Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jbRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistroActionPerformed
        RegistroVeterinario ruser = new RegistroVeterinario(this, true);
        ruser.setVisible(true);
    }//GEN-LAST:event_jbRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JButton jbInicioSesion;
    private javax.swing.JButton jbRegistro;
    private javax.swing.JLabel jlabelImagen;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JPasswordField jpfRepeatPassword;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
