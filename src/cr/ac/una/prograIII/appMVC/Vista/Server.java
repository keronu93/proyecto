/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Vista;

/**
 *
 * @author Gustavo
 */
public class Server extends javax.swing.JFrame {

    /**
     * Creates new form Server
     */
    public Server() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        //this.setLocation(750, 50);
        this.setResizable(false);
        //this.setAlwaysOnTop( true );
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btDesbloquear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chat_Servidor = new javax.swing.JTextArea();
        btIniciarServidor = new javax.swing.JButton();
        btDetenerServidor = new javax.swing.JButton();
        btUsuariosEnLinea = new javax.swing.JButton();
        btLimpiarPantalla = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPC = new javax.swing.JTable();
        BtBloquear = new javax.swing.JButton();
        BtAgregarFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Servidor");

        btDesbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Candado.png"))); // NOI18N
        btDesbloquear.setText("Desbloquear");
        btDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesbloquearActionPerformed(evt);
            }
        });

        Chat_Servidor.setColumns(20);
        Chat_Servidor.setRows(5);
        jScrollPane1.setViewportView(Chat_Servidor);

        btIniciarServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Server.png"))); // NOI18N
        btIniciarServidor.setText("Iniciar Servidor");
        btIniciarServidor.setPreferredSize(new java.awt.Dimension(115, 23));
        btIniciarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarServidorActionPerformed(evt);
            }
        });

        btDetenerServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Detener.png"))); // NOI18N
        btDetenerServidor.setText("Detener Servidor");
        btDetenerServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetenerServidorActionPerformed(evt);
            }
        });

        btUsuariosEnLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/usuarioPequeño_1.png"))); // NOI18N
        btUsuariosEnLinea.setText("Usuarios en linea");
        btUsuariosEnLinea.setPreferredSize(new java.awt.Dimension(115, 23));
        btUsuariosEnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuariosEnLineaActionPerformed(evt);
            }
        });

        btLimpiarPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Limpiar.png"))); // NOI18N
        btLimpiarPantalla.setText("Limpiar pantalla");
        btLimpiarPantalla.setPreferredSize(new java.awt.Dimension(115, 23));
        btLimpiarPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarPantallaActionPerformed(evt);
            }
        });

        jTPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "IP", "Estado", "Hora Conexion", "Hora Desconexion", "Tiempo Total"
            }
        ));
        jScrollPane2.setViewportView(jTPC);

        BtBloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Candado1.png"))); // NOI18N
        BtBloquear.setText("Bloquear");

        BtAgregarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/agregarFactura.png"))); // NOI18N
        BtAgregarFactura.setText("Agregar a Factura");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btIniciarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDesbloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDetenerServidor))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btUsuariosEnLinea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(btLimpiarPantalla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BtAgregarFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btIniciarServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUsuariosEnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btLimpiarPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btDetenerServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDesbloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAgregarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesbloquearActionPerformed

        
            //*****************************************************
            //se recorre la lista de clientes y se verifica a cual
            //sokect se le quiere enviar el mensaja (el seleccionado
                //en la tabla)
           
    }//GEN-LAST:event_btDesbloquearActionPerformed

    private void btIniciarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarServidorActionPerformed
      
    }//GEN-LAST:event_btIniciarServidorActionPerformed

    private void btDetenerServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetenerServidorActionPerformed
       
    }//GEN-LAST:event_btDetenerServidorActionPerformed

    private void btUsuariosEnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuariosEnLineaActionPerformed
       
    }//GEN-LAST:event_btUsuariosEnLineaActionPerformed

    private void btLimpiarPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarPantallaActionPerformed
        
    }//GEN-LAST:event_btLimpiarPantallaActionPerformed

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtAgregarFactura;
    public javax.swing.JButton BtBloquear;
    public javax.swing.JTextArea Chat_Servidor;
    public javax.swing.JButton btDesbloquear;
    public javax.swing.JButton btDetenerServidor;
    public javax.swing.JButton btIniciarServidor;
    public javax.swing.JButton btLimpiarPantalla;
    public javax.swing.JButton btUsuariosEnLinea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTPC;
    // End of variables declaration//GEN-END:variables
}
