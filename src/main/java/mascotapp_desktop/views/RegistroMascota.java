/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.views;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import mascotapp_desktop.controllers.MascotaController;
import mascotapp_desktop.controllers.PropietarioController;
import mascotapp_desktop.models.Mascota;
import mascotapp_desktop.models.Propietario;
import mascotapp_desktop.util.MascotappUtilImpl;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase que inicia la ventana de Registro de Mascota
 */
public class RegistroMascota extends javax.swing.JDialog {

    /**
     * Creates new form RegistroMascota
     *
     * @param parent
     * @param modal
     */
    public RegistroMascota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setParent(parent);
        setTitle("REGISTRO MASCOTA");

        initControllers();
    }

    /**
     * Inicializa los controllers y clases necesarias
     */
    private void initControllers() {
        mc = new MascotaController();
        mui = new MascotappUtilImpl();
        mascList = new ArrayList();
        pc = new PropietarioController();
        prop = pc.getPropietario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBotones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfChip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfRaza = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfPeso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbVolver = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jrbMacho = new javax.swing.JRadioButton();
        jrbHembra = new javax.swing.JRadioButton();
        jdcFechaNac = new com.toedter.calendar.JDateChooser();
        jtfEspecie = new javax.swing.JTextField();

        bgBotones.add(jrbMacho);
        bgBotones.add(jrbHembra);

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
        jLabel2.setText("Nº Chip*:");

        jLabel3.setFont(jPanel1.getFont());
        jLabel3.setForeground(jPanel1.getForeground());
        jLabel3.setText("Especie*:");

        jLabel4.setFont(jPanel1.getFont());
        jLabel4.setForeground(jPanel1.getForeground());
        jLabel4.setText("Raza:");

        jtfRaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfRazaActionPerformed(evt);
            }
        });

        jLabel5.setFont(jPanel1.getFont());
        jLabel5.setForeground(jPanel1.getForeground());
        jLabel5.setText("Peso:");

        jLabel6.setFont(jPanel1.getFont());
        jLabel6.setForeground(jPanel1.getForeground());
        jLabel6.setText("Sexo*:");

        jLabel7.setFont(jPanel1.getFont());
        jLabel7.setForeground(jPanel1.getForeground());
        jLabel7.setText("Fecha nacimiento*:");

        jbVolver.setFont(jPanel1.getFont());
        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
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

        jrbMacho.setBackground(jPanel1.getBackground());
        jrbMacho.setFont(jPanel1.getFont());
        jrbMacho.setForeground(jPanel1.getForeground());
        jrbMacho.setText("Macho");
        jrbMacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMachoActionPerformed(evt);
            }
        });

        jrbHembra.setBackground(jPanel1.getBackground());
        jrbHembra.setFont(jPanel1.getFont());
        jrbHembra.setForeground(jPanel1.getForeground());
        jrbHembra.setText("Hembra");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(0, 3, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfRaza, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jtfChip, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfEspecie)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jrbMacho)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jrbHembra)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jdcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jbGuardar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVolver)
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfChip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jrbMacho)
                            .addComponent(jrbHembra))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jdcFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardar)
                            .addComponent(jbVolver))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jrbMachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMachoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbMachoActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jtfRazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfRazaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfRazaActionPerformed

    private void jtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        guardarMascota();
    }//GEN-LAST:event_jbGuardarActionPerformed

    /**
     * Método que valida todos los campos introducidos por el usuario y si son
     * correctos guarda la Mascota
     *
     * @throws NumberFormatException
     * @throws HeadlessException
     */
    private void guardarMascota() throws NumberFormatException, HeadlessException {
        masc = new Mascota();

        if (!jtfNombre.getText().isBlank()
                && !jtfEspecie.getText().isBlank()
                && !jtfChip.getText().isBlank()
                && (jrbMacho.isSelected() || jrbHembra.isSelected())
                && jdcFechaNac.getCalendar() != null) {

            if (mui.validarTexto(jtfNombre.getText())) {
                if (mui.validarTexto(jtfEspecie.getText())) {
                    if (jtfRaza.getText().isBlank() || mui.validarTexto(jtfRaza.getText())) {
                        if (mui.validarAlfanumerico(jtfChip.getText())) {
                            if (jtfPeso.getText().isBlank() || mui.validarPeso(jtfPeso.getText())) {
                                if (jdcFechaNac.getCalendar().equals(Calendar.getInstance()) || jdcFechaNac.getCalendar().before(Calendar.getInstance())) {

                                    masc.setNombre(jtfNombre.getText());
                                    masc.setEspecie(jtfEspecie.getText());
                                    masc.setRaza(jtfRaza.getText());
                                    masc.setNum_chip(jtfChip.getText());
                                    if (!jtfPeso.getText().isBlank()) {
                                        masc.setPeso(Double.parseDouble(jtfPeso.getText()));
                                    } else {
                                        masc.setPeso(0.0);
                                    }

                                    if (jrbMacho.isSelected()) {
                                        masc.setSexo("M");
                                    } else if (jrbHembra.isSelected()) {
                                        masc.setSexo("H");
                                    }

                                    masc.setFecha_nac(jdcFechaNac.getCalendar());

                                    mc.addMascota(masc);

                                    //Obtiene la lista de mascotas del Propietario 
                                    mascList = mc.getMascotasByPropietario(prop.getId());

                                    /*Recorre la lista de mascotas y si coincide el Nº de chip con la mascota creada, 
                                    se modifica el objeto Mascota de MascotaController*/
                                    for (Mascota m : mascList) {
                                        if (m != null) {
                                            if (m.getNum_chip().equals(masc.getNum_chip())) {
                                                mc.setMascota(m);
                                            }
                                        }
                                    }

                                    this.dispose();

                                    PerfilMascota pm = new PerfilMascota(parent, true);
                                    pm.setVisible(true);

                                } else {
                                    JOptionPane.showMessageDialog(this, "La fecha de nacimiento debe ser igual o anterior a la fecha de hoy", "Campos fecha", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Parece que ha introducido un formato incorrecto o caracteres no numéricos\n\t*Formatos válidos: 'X' o 'X.X'", "CAMPO PESO", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Parece que ha introducido caracteres no numéricos", "CAMPO CHIP", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Parece que ha introducido caracteres no alfabéticos", "CAMPO RAZA", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Parece que ha introducido caracteres no alfabéticos", "CAMPO ESPECIE", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Parece que ha introducido caracteres no alfabéticos", "CAMPO NOMBRE", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Introduzca los campos obligatorios (*)", "Campos obligatorios", JOptionPane.ERROR_MESSAGE);
        }
    }

        /**
     * Método que cambia el Frame padre por el que le entra por parámetro
     *
     * @param parent
     */
    private void setParent(Frame parent) {
        this.parent = parent;
    }

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
            java.util.logging.Logger.getLogger(RegistroMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegistroMascota dialog = new RegistroMascota(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bgBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbVolver;
    private com.toedter.calendar.JDateChooser jdcFechaNac;
    private javax.swing.JRadioButton jrbHembra;
    private javax.swing.JRadioButton jrbMacho;
    private javax.swing.JTextField jtfChip;
    private javax.swing.JTextField jtfEspecie;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPeso;
    private javax.swing.JTextField jtfRaza;
    // End of variables declaration//GEN-END:variables
    private Mascota masc;
    private MascotaController mc;
    private Frame parent;
    private MascotappUtilImpl mui;
    private List<Mascota> mascList;
    private Propietario prop;
    private PropietarioController pc;
}
