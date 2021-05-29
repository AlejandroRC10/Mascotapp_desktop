/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.views;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mascotapp_desktop.controllers.MascotaController;
import mascotapp_desktop.controllers.PropietarioController;
import mascotapp_desktop.controllers.VeterinarioController;
import mascotapp_desktop.models.Mascota;

/**
 *
 * @author alex_
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public VentanaPrincipal() {
        initComponents();
        pc = new PropietarioController();
        mc = new MascotaController();
        vc = new VeterinarioController();

        ImageIcon perro = new ImageIcon(getClass().getResource("../resources/perro.png"));
        jlPerro.setIcon(perro);

        ImageIcon huellas = new ImageIcon(getClass().getResource("../resources/huellas.png"));
        jlHuellas.setIcon(huellas);

        ImageIcon lupa = new ImageIcon(getClass().getResource("../resources/lupa.png"));
        jbBusca.setIcon(lupa);
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
        jtfBuscar = new javax.swing.JTextField();
        jbBusca = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlHuellas = new javax.swing.JLabel();
        jlPerro = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiMiPerfil = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiNuevo = new javax.swing.JMenuItem();
        jmiBuscar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 128, 55));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Sylfaen", 1, 10)); // NOI18N

        jtfBuscar.setToolTipText("");
        jtfBuscar.setSelectedTextColor(new java.awt.Color(204, 255, 204));
        jtfBuscar.setSelectionColor(new java.awt.Color(0, 153, 102));
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        jbBusca.setBackground(jPanel1.getBackground());
        jbBusca.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jbBusca.setPreferredSize(new java.awt.Dimension(40, 40));
        jbBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(jPanel1.getForeground());
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¿ A quién buscas ?");

        jlHuellas.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jlHuellas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jlPerro)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jlPerro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlHuellas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGap(52, 52, 52))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 102, 51), null, null));
        jMenuBar1.setForeground(new java.awt.Color(51, 102, 0));

        jMenu1.setForeground(jMenuBar1.getForeground());
        jMenu1.setText("Inicio");
        jMenu1.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N

        jmiMiPerfil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiMiPerfil.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jmiMiPerfil.setForeground(jMenuBar1.getForeground());
        jmiMiPerfil.setText("Mi perfil");
        jmiMiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMiPerfilActionPerformed(evt);
            }
        });
        jMenu1.add(jmiMiPerfil);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jMenuItem2.setText("Cerrar Sesión");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(jMenuBar1.getForeground());
        jMenu2.setText("Propietarios");
        jMenu2.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N

        jmiNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiNuevo.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jmiNuevo.setForeground(jMenuBar1.getForeground());
        jmiNuevo.setText("Nuevo");
        jmiNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiNuevo);

        jmiBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiBuscar.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jmiBuscar.setForeground(jMenuBar1.getForeground());
        jmiBuscar.setText("Buscar");
        jmiBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBuscarActionPerformed(evt);
            }
        });
        jMenu2.add(jmiBuscar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiMiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMiPerfilActionPerformed
        MiPerfil mp = new MiPerfil(this, true);
        mp.setVisible(true);
    }//GEN-LAST:event_jmiMiPerfilActionPerformed

    private void jmiBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBuscarActionPerformed
        String jop = JOptionPane.showInputDialog("Ingresa el DNI de propietario: ");

        if (pc.getPropietarioByDniAndVetId(jop, vc.getVeterinario().getId())) {
            PerfilPropietario pc = new PerfilPropietario(this, true);
            pc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "DNI incorrecto, el propietario no existe", "Mascotapp Login", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jmiBuscarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jmiNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoActionPerformed
        RegistroPropietario rp = new RegistroPropietario(this, true);
        rp.setVisible(true);
    }//GEN-LAST:event_jmiNuevoActionPerformed

    private void jbBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaActionPerformed
        String busqueda = jtfBuscar.getText();
        List<Mascota> list = mc.getMascotaByNombre(busqueda);

        if (!busqueda.isBlank() // && busqueda != ""
                ) {
            if (!list.isEmpty()) {
                mc.setMascotas(mc.getMascotaByNombre(busqueda));
                ListadoBusquedaMascotas lbm = new ListadoBusquedaMascotas(this, true);
                lbm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No hay mascotas con ese nombre", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Introduzca un nombre de mascota", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        jtfBuscar.setText("");
    }//GEN-LAST:event_jbBuscaActionPerformed

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new VentanaPrincipal().setVisible(true);
//            }
//        });
    }

    public VentanaPrincipal getFrame() {
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBusca;
    private javax.swing.JLabel jlHuellas;
    private javax.swing.JLabel jlPerro;
    private javax.swing.JMenuItem jmiBuscar;
    private javax.swing.JMenuItem jmiMiPerfil;
    private javax.swing.JMenuItem jmiNuevo;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
  private PropietarioController pc;
    private MascotaController mc;
    private Mascota masc;
    private VeterinarioController vc;
}
