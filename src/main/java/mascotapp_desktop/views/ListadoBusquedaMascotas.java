/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.views;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import mascotapp_desktop.controllers.MascotaController;
import mascotapp_desktop.models.Mascota;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase que inicia la aplicación desde la pantalla de Login
 */
public class ListadoBusquedaMascotas extends javax.swing.JDialog {

    /**
     * Crea una pantalla para mostrar el ListadoBusquedaMascotas
     *
     * @param parent
     * @param modal
     */
    public ListadoBusquedaMascotas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setParent(parent);

        mc = new MascotaController();
        listaMascotas = mc.getMascotas();
        jtTabla.setModel(getModeloTablaMascota(listaMascotas));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jbVer = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 0));
        setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setForeground(new java.awt.Color(51, 102, 0));

        jtTabla.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 102, 0)));
        jtTabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtTabla.setForeground(new java.awt.Color(0, 102, 0));
        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Nº Chip", "Propietario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabla.setToolTipText("");
        jtTabla.setGridColor(new java.awt.Color(51, 102, 0));
        jtTabla.setOpaque(false);
        jtTabla.setSelectionBackground(new java.awt.Color(51, 153, 0));
        jtTabla.setSelectionForeground(new java.awt.Color(204, 255, 204));
        jtTabla.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jtTabla.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jtTabla);

        jbVer.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jbVer.setForeground(new java.awt.Color(51, 102, 0));
        jbVer.setText("Ver");
        jbVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerActionPerformed(evt);
            }
        });

        jbVolver.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jbVolver.setForeground(new java.awt.Color(51, 102, 0));
        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(jbVer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVolver)
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVer)
                    .addComponent(jbVolver))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerActionPerformed
        verMascota();
    }//GEN-LAST:event_jbVerActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        dispose();
    }//GEN-LAST:event_jbVolverActionPerformed

    /**
     * Método que abre la pantalla 'PerfilMascota' para la Mascota seleccionada
     *
     * @throws HeadlessException
     */
    private void verMascota() throws HeadlessException {
        Mascota m = selectMascotaList();

        if (m != null) {
            mc.setMascota(m);
            dispose();
            PerfilMascota pm = new PerfilMascota(parent, true);
            pm.setVisible(true);
        }
    }

    private Mascota selectMascotaList() {

        int index = jtTabla.getSelectedRow();

        if (index != -1) {
            if (!listaMascotas.isEmpty()) {
                return listaMascotas.get(index);
            } else {
                JOptionPane.showMessageDialog(this, "No hay mascotas con ese nombre");
            }

        } else {
            JOptionPane.showMessageDialog(parent, "Debe seleccionar una mascota de la lista", "WARNING", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    /**
     * Mëtodo para obtener el modelo de la tabla
     *
     * @param listaMascotas la lista de mascotas
     * @return el modelo de tabla
     */
    public AbstractTableModel getModeloTablaMascota(List<Mascota> listaMascotas) {
        final int COLUMNAS_NUMERO = 3;
        final String[] COLUMNAS_NOMBRES = {"Nombre", "Nº Chip", "Propietario"};

        final int COLUMNA_NOMBRE = 0;
        final int COLUMNA_CHIP = 1;
        final int COLUMNA_PROPIETARIO = 2;

        AbstractTableModel modeloTabla = new AbstractTableModel() {
            @Override
            public int getRowCount() {

                return listaMascotas.size();

            }

            @Override
            public int getColumnCount() {

                return COLUMNAS_NUMERO;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                Mascota masc = listaMascotas.get(rowIndex);
                Object valor = null;

                switch (columnIndex) {

                    case COLUMNA_NOMBRE:
                        valor = masc.getNombre();
                        break;
                    case COLUMNA_CHIP:
                        valor = masc.getNum_chip();
                        break;
                    case COLUMNA_PROPIETARIO:
                        valor = masc.getPropietario().getNombre();
                        break;

                    default:
                        throw new AssertionError("Columna invalida");
                }

                return valor;
            }

            @Override
            public String getColumnName(int column) {
                return COLUMNAS_NOMBRES[column];
            }
        };

        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) jtTabla.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        return modeloTabla;
    }

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
            java.util.logging.Logger.getLogger(ListadoBusquedaMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoBusquedaMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoBusquedaMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoBusquedaMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListadoBusquedaMascotas dialog = new ListadoBusquedaMascotas(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbVer;
    private javax.swing.JButton jbVolver;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables
    private MascotaController mc;
    private Frame parent;
    private List<Mascota> listaMascotas;
}
