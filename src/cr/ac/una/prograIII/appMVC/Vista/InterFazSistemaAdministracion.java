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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
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
        ReporteCliente = new javax.swing.JMenuItem();
        ReporteProveedores = new javax.swing.JMenuItem();
        ReporteUsuarios = new javax.swing.JMenuItem();
        ReporteArticulos = new javax.swing.JMenuItem();
        jMFacturacion = new javax.swing.JMenu();
        jMFactura = new javax.swing.JMenuItem();
        jMInformacion = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

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

        ReporteCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        ReporteCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/ClientePequeno.png"))); // NOI18N
        ReporteCliente.setText("Reporte Clientes");
        ReporteCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteClienteActionPerformed(evt);
            }
        });
        jMenuEstadisticas.add(ReporteCliente);

        ReporteProveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        ReporteProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/ProvedorPequeño.png"))); // NOI18N
        ReporteProveedores.setText("Reporte Proveedores");
        ReporteProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteProveedoresActionPerformed(evt);
            }
        });
        jMenuEstadisticas.add(ReporteProveedores);

        ReporteUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
        ReporteUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/usuarioPequeño_1.png"))); // NOI18N
        ReporteUsuarios.setText("Reporte Usuarios");
        jMenuEstadisticas.add(ReporteUsuarios);

        ReporteArticulos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        ReporteArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Agregar Articulos.png"))); // NOI18N
        ReporteArticulos.setText("Reporte Articulos");
        jMenuEstadisticas.add(ReporteArticulos);

        jMenuBar1.add(jMenuEstadisticas);

        jMFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Facturacion.png"))); // NOI18N
        jMFacturacion.setText("Facturacion");

        jMFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/agregarFactura.png"))); // NOI18N
        jMFactura.setText("Factura");
        jMFacturacion.add(jMFactura);

        jMenuBar1.add(jMFacturacion);

        jMInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Informacion.png"))); // NOI18N
        jMInformacion.setText("Informacion");
        jMenuBar1.add(jMInformacion);

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

    private void ReporteClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteClienteActionPerformed
        
        
    }//GEN-LAST:event_ReporteClienteActionPerformed

    private void jMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuClienteActionPerformed

    private void jMenuArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuArticuloActionPerformed

    private void ReporteProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReporteProveedoresActionPerformed

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
    private javax.swing.JMenuItem ReporteArticulos;
    public javax.swing.JMenuItem ReporteCliente;
    public javax.swing.JMenuItem ReporteProveedores;
    private javax.swing.JMenuItem ReporteUsuarios;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JMenuItem jMFactura;
    public javax.swing.JMenu jMFacturacion;
    public javax.swing.JMenu jMInformacion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuArchivo;
    public javax.swing.JMenuItem jMenuArticulo;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuCliente;
    public javax.swing.JMenu jMenuEstadisticas;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMenuMantenimiento;
    public javax.swing.JMenuItem jMenuProveedores;
    public javax.swing.JMenuItem jMenuTelefono;
    public javax.swing.JMenuItem jMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
