/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.views;

import javax.swing.JOptionPane;
import mascotapp_desktop.controllers.VeterinarioController;
import mascotapp_desktop.models.Veterinario;
import mascotapp_desktop.util.MascotappUtilImpl;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase que inicia la ventana de Registro de Veterinario
 */
public class RegistroVeterinario extends javax.swing.JDialog {

    /**
     * Creates new form RegistroUsuario
     *
     * @param parent
     * @param modal
     */
    public RegistroVeterinario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        vc = new VeterinarioController();
        mui = new MascotappUtilImpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNumCol = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfNomClinica = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jpfPasswordRepeat = new javax.swing.JPasswordField();
        jpfPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 128, 55));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N

        jLabel1.setFont(jPanel1.getFont());
        jLabel1.setForeground(jPanel1.getForeground());
        jLabel1.setText("Nombre*:");

        jtfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(jPanel1.getFont());
        jLabel2.setForeground(jPanel1.getForeground());
        jLabel2.setText("Apellidos*:");

        jLabel3.setFont(jPanel1.getFont());
        jLabel3.setForeground(jPanel1.getForeground());
        jLabel3.setText("Nº Col*.");

        jLabel4.setFont(jPanel1.getFont());
        jLabel4.setForeground(jPanel1.getForeground());
        jLabel4.setText("Nombre clínica:");

        jtfNomClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomClinicaActionPerformed(evt);
            }
        });

        jLabel5.setFont(jPanel1.getFont());
        jLabel5.setForeground(jPanel1.getForeground());
        jLabel5.setText("Dirección*:");

        jLabel6.setFont(jPanel1.getFont());
        jLabel6.setForeground(jPanel1.getForeground());
        jLabel6.setText("Teléfono*:");

        jtfTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTelefonoActionPerformed(evt);
            }
        });

        jLabel7.setFont(jPanel1.getFont());
        jLabel7.setForeground(jPanel1.getForeground());
        jLabel7.setText("Usuario*:");

        jLabel8.setFont(jPanel1.getFont());
        jLabel8.setForeground(jPanel1.getForeground());
        jLabel8.setText("Contraseña*:");

        jLabel9.setFont(jPanel1.getFont());
        jLabel9.setForeground(jPanel1.getForeground());
        jLabel9.setText("Repetir contraseña*:");

        jbCancelar.setFont(jPanel1.getFont());
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(jPanel1.getFont());
        jbGuardar.setForeground(new java.awt.Color(51, 102, 0));
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jpfPasswordRepeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfPasswordRepeatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfDireccion)
                                .addComponent(jtfNomClinica)
                                .addComponent(jtfApellidos)
                                .addComponent(jtfNumCol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jpfPasswordRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(85, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCancelar)
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfNumCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfNomClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jpfPasswordRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreActionPerformed

    private void jtfNomClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomClinicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomClinicaActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        registerVet();
    }//GEN-LAST:event_jbGuardarActionPerformed

    /**
     * Método que valida los campos introducidos por el usuario y si son
     * correctos registra el Veterinario
     *
     */
    public void registerVet() {

        String password = new String(jpfPassword.getPassword());
        String password2 = new String(jpfPasswordRepeat.getPassword());

        if (!jtfNombre.getText().isBlank()
                && !jtfApellidos.getText().isBlank()
                && !jtfDireccion.getText().isBlank()
                && !jtfNumCol.getText().isBlank()
                && !jtfUsuario.getText().isBlank()
                && !jtfTelefono.getText().isBlank()
                && !password.isBlank()
                && !password2.isBlank()) {

            if (mui.validarTexto(jtfNombre.getText())) {
                if (mui.validarTexto(jtfApellidos.getText())) {
                    if (mui.validarDireccion(jtfDireccion.getText())) {
                        if (mui.validarDigitos(jtfNumCol.getText())) {
                            if (mui.validarTelefono(jtfTelefono.getText())) {

                                vet = new Veterinario();
                                vet.setNombre(jtfNombre.getText());
                                vet.setApellidos(jtfApellidos.getText());
                                vet.setDireccion(jtfDireccion.getText());
                                vet.setNom_clinica(jtfNomClinica.getText());
                                vet.setNumColegiado(Integer.parseInt(jtfNumCol.getText()));
                                vet.setUsuario(jtfUsuario.getText());
                                vet.setTelefono(jtfTelefono.getText());

                                if (password.equals(password2)) {
                                    vet.setPassword(password);
                                    if (vc.addVeterinario(vet)) {
                                        JOptionPane.showMessageDialog(this, "Usuario registrado correctamente", "Mascotapp Registro", JOptionPane.INFORMATION_MESSAGE);
                                        this.dispose();
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Es posible que el 'Usuario' o 'NºCol.' introducidos ya existan", "Mascotapp Registro", JOptionPane.ERROR_MESSAGE);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Mascotapp Registro", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "El teléfono de tener 9 dígitos", "CAMPO TELÉFONO", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Parece que ha introducido caracteres no numéricos", "CAMPO NºCol.", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Parece que ha introducido caracteres no alfabéticos", "CAMPO DIRECCIÓN", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Parece que ha introducido caracteres no alfabéticos", "CAMPO APELLIDOS", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Parece que ha introducido caracteres no alfabéticos", "CAMPO NOMBRE", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Introduzca los campos obligatorios (*)", "Campos obligatorios", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jpfPasswordRepeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfPasswordRepeatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfPasswordRepeatActionPerformed

    private void jtfTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTelefonoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVeterinario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegistroVeterinario dialog = new RegistroVeterinario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JPasswordField jpfPasswordRepeat;
    private javax.swing.JTextField jtfApellidos;
    private javax.swing.JTextField jtfDireccion;
    private javax.swing.JTextField jtfNomClinica;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNumCol;
    private javax.swing.JTextField jtfTelefono;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
    private VeterinarioController vc;
    private Veterinario vet;
    private MascotappUtilImpl mui;
}
