/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Vista;


import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class InterFazSistemaAdministracion extends javax.swing.JFrame {
    
 
    /**
     * Creates new form InterFazSistemaAdministracion
     */
    public InterFazSistemaAdministracion() {
        initComponents();
        setTitle("Sistema de Administracion");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuMantenimiento = new javax.swing.JMenu();
        jMenuArticulo = new javax.swing.JMenuItem();
        jMenuCliente = new javax.swing.JMenuItem();
        jMenuProveedores = new javax.swing.JMenuItem();
        jMenuTelefono = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenuItem();
        MenuPcMantenimiento = new javax.swing.JMenu();
        MenuServer = new javax.swing.JMenuItem();
        MenuPC = new javax.swing.JMenuItem();
        jMenuEstadisticas = new javax.swing.JMenu();
        jmArticulo = new javax.swing.JMenuItem();
        jmCliente = new javax.swing.JMenuItem();
        jmHoras = new javax.swing.JMenuItem();
        jMenuInformaciion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Adminsitracion Internet Cafe");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/fiber-optic-cables_0-1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Archivo.png"))); // NOI18N
        jMenuArchivo.setText("Archivo");
        jMenuBar1.add(jMenuArchivo);

        jMenuMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Mantenimiento.png"))); // NOI18N
        jMenuMantenimiento.setText("Mantenimientos");

        jMenuArticulo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Agregar Articulos.png"))); // NOI18N
        jMenuArticulo.setText("Articulos");
        jMenuArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArticuloActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuArticulo);

        jMenuCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/usuarioPequeño_1.png"))); // NOI18N
        jMenuCliente.setText("Clientes");
        jMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClienteActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuCliente);

        jMenuProveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/ProvedorPequeño.png"))); // NOI18N
        jMenuProveedores.setText("Proveedores");
        jMenuMantenimiento.add(jMenuProveedores);

        jMenuTelefono.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/phone.png"))); // NOI18N
        jMenuTelefono.setText("Telefonos");
        jMenuMantenimiento.add(jMenuTelefono);

        jMenuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/usuariope.png"))); // NOI18N
        jMenuUsuario.setText("Usuarios");
        jMenuMantenimiento.add(jMenuUsuario);

        jMenuBar1.add(jMenuMantenimiento);

        MenuPcMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/PCMantenimeinto.png"))); // NOI18N
        MenuPcMantenimiento.setText("PC Mantenimientos");

        MenuServer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        MenuServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Server.png"))); // NOI18N
        MenuServer.setText("Servidor");
        MenuServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuServerActionPerformed(evt);
            }
        });
        MenuPcMantenimiento.add(MenuServer);

        MenuPC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        MenuPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/PCS.png"))); // NOI18N
        MenuPC.setText("PCS");
        MenuPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPCActionPerformed(evt);
            }
        });
        MenuPcMantenimiento.add(MenuPC);

        jMenuBar1.add(MenuPcMantenimiento);

        jMenuEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Reportes.png"))); // NOI18N
        jMenuEstadisticas.setText("Reportes");

        jmArticulo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        jmArticulo.setText("Articulo");
        jmArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmArticuloActionPerformed(evt);
            }
        });
        jMenuEstadisticas.add(jmArticulo);

        jmCliente.setText("Cliente");
        jMenuEstadisticas.add(jmCliente);

        jmHoras.setText("Horas");
        jMenuEstadisticas.add(jmHoras);

        jMenuBar1.add(jMenuEstadisticas);

        jMenuInformaciion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Informacion.png"))); // NOI18N
        jMenuInformaciion.setText("Informacion");
        jMenuBar1.add(jMenuInformaciion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void MenuServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuServerActionPerformed
      
    }//GEN-LAST:event_MenuServerActionPerformed

    private void MenuPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPCActionPerformed
      
    }//GEN-LAST:event_MenuPCActionPerformed

    private void jmArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmArticuloActionPerformed

    private void jMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuClienteActionPerformed

    private void jMenuArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuArticuloActionPerformed

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
            java.util.logging.Logger.getLogger(InterFazSistemaAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterFazSistemaAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterFazSistemaAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterFazSistemaAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterFazSistemaAdministracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem MenuPC;
    public javax.swing.JMenu MenuPcMantenimiento;
    public javax.swing.JMenuItem MenuServer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenuArchivo;
    public javax.swing.JMenuItem jMenuArticulo;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuCliente;
    private javax.swing.JMenu jMenuEstadisticas;
    private javax.swing.JMenu jMenuInformaciion;
    private javax.swing.JMenu jMenuMantenimiento;
    public javax.swing.JMenuItem jMenuProveedores;
    public javax.swing.JMenuItem jMenuTelefono;
    public javax.swing.JMenuItem jMenuUsuario;
    private javax.swing.JMenuItem jmArticulo;
    private javax.swing.JMenuItem jmCliente;
    private javax.swing.JMenuItem jmHoras;
    // End of variables declaration//GEN-END:variables
}
