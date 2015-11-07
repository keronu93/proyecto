package cr.ac.una.prograIII.appMVC.Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class AgregarFactura extends javax.swing.JFrame {

    /**
     * Creates new form Facturacion
     */
    public AgregarFactura() {
        initComponents();
        setTitle("Agregar Facturas");
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

        Fecha = new javax.swing.JLabel();
        etiquetaFecha = new javax.swing.JLabel();
        Cliente = new javax.swing.JLabel();
        Tiempo = new javax.swing.JLabel();
        EtiquetaTiempo = new javax.swing.JLabel();
        ValorHora = new javax.swing.JLabel();
        EtiquetaValorHora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalleFactura = new javax.swing.JTable();
        TotalEtiqueta = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        btCrearFac = new javax.swing.JButton();
        jLabelNumerodeFactura = new javax.swing.JLabel();
        btagregarArticulos = new javax.swing.JButton();
        txtidFactura = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        btBuscarCliente = new javax.swing.JButton();
        btCargar = new javax.swing.JButton();
        btInsertar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btBuscarId = new javax.swing.JButton();
        JPrecioUnitario = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        NombreArticulo = new javax.swing.JLabel();
        txtNombreArticulo = new javax.swing.JTextField();
        Cantidad = new javax.swing.JLabel();
        txtCantidadArticulos = new javax.swing.JTextField();
        IDArticulo = new javax.swing.JLabel();
        txtIdArticulo = new javax.swing.JTextField();
        jNombreCliente = new javax.swing.JLabel();
        JApellidosCliente = new javax.swing.JLabel();
        TxTNombreCliente = new javax.swing.JTextField();
        TxtApellidosCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Factura");

        Fecha.setText("Fecha:");

        etiquetaFecha.setText("sin definir");

        Cliente.setText("Id Cliente:");

        Tiempo.setText("Tiempo:");

        EtiquetaTiempo.setText("0.0");

        ValorHora.setText("Valor hora:");

        EtiquetaValorHora.setText("500");

        jTableDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Precio Unitario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDetalleFactura);

        TotalEtiqueta.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TotalEtiqueta.setText("Total:");

        jlTotal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jlTotal.setText("0.0");

        btCrearFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/aprobado.png"))); // NOI18N
        btCrearFac.setText("Ejecutar");

        jLabelNumerodeFactura.setText("Id Factura :");

        btagregarArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/Agregar Articulos.png"))); // NOI18N
        btagregarArticulos.setText("Agregar Articulo");
        btagregarArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btagregarArticulosActionPerformed(evt);
            }
        });

        btBuscarCliente.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/vista/images/buscar.png"))); // NOI18N
        btBuscarCliente.setText("Buscar Cliente");
        btBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarClienteActionPerformed(evt);
            }
        });

        btCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/vista/images/upload.png"))); // NOI18N
        btCargar.setText("Cargar");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });

        btInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/vista/images/agregar.png"))); // NOI18N
        btInsertar.setText("Insertar");
        btInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertarActionPerformed(evt);
            }
        });

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/vista/images/elimiar.png"))); // NOI18N
        btEliminar.setText("Eliminar");

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/vista/images/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/Vista/Images/user.png"))); // NOI18N

        btBuscarId.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btBuscarId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/prograIII/appMVC/vista/images/buscar.png"))); // NOI18N
        btBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarIdActionPerformed(evt);
            }
        });

        JPrecioUnitario.setText("Precio Unitario:");

        NombreArticulo.setText("Nombre Articulo:");

        Cantidad.setText("Cantidad de Articulos :");

        IDArticulo.setText("Id Articulo:");

        jNombreCliente.setText("Nombre :");

        JApellidosCliente.setText("Apellidos :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IDArticulo)
                            .addComponent(JPrecioUnitario)
                            .addComponent(NombreArticulo)
                            .addComponent(Cliente)
                            .addComponent(jLabelNumerodeFactura)
                            .addComponent(Cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Tiempo)
                            .addComponent(ValorHora)
                            .addComponent(jNombreCliente)
                            .addComponent(JApellidosCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxTNombreCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtidFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btBuscarId))
                                    .addComponent(txtIdArticulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(TxtApellidosCliente))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Fecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etiquetaFecha))
                                    .addComponent(btBuscarCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btagregarArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EtiquetaValorHora)
                                    .addComponent(EtiquetaTiempo)
                                    .addComponent(txtCantidadArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCrearFac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TotalEtiqueta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlTotal)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNumerodeFactura)
                                    .addComponent(txtidFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Fecha)
                                    .addComponent(etiquetaFecha)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btBuscarId)
                                .addGap(4, 4, 4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Cliente)
                                .addComponent(btBuscarCliente))
                            .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNombreCliente)
                            .addComponent(TxTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JApellidosCliente)
                            .addComponent(TxtApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDArticulo)
                            .addComponent(txtIdArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPrecioUnitario)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreArticulo)
                    .addComponent(txtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cantidad)
                    .addComponent(txtCantidadArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tiempo)
                    .addComponent(EtiquetaTiempo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ValorHora)
                    .addComponent(EtiquetaValorHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btagregarArticulos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TotalEtiqueta)
                        .addComponent(jlTotal))
                    .addComponent(btCrearFac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btagregarArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btagregarArticulosActionPerformed
        
    }//GEN-LAST:event_btagregarArticulosActionPerformed

    private void btBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarClienteActionPerformed

    }//GEN-LAST:event_btBuscarClienteActionPerformed

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCargarActionPerformed

    private void btInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btInsertarActionPerformed

    private void btBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarIdActionPerformed

    }//GEN-LAST:event_btBuscarIdActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel Cliente;
    public javax.swing.JLabel EtiquetaTiempo;
    public javax.swing.JLabel EtiquetaValorHora;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel IDArticulo;
    private javax.swing.JLabel JApellidosCliente;
    private javax.swing.JLabel JPrecioUnitario;
    private javax.swing.JLabel NombreArticulo;
    private javax.swing.JLabel Tiempo;
    private javax.swing.JLabel TotalEtiqueta;
    public javax.swing.JTextField TxTNombreCliente;
    public javax.swing.JTextField TxtApellidosCliente;
    private javax.swing.JLabel ValorHora;
    public javax.swing.JButton btBuscarCliente;
    public javax.swing.JButton btBuscarId;
    public javax.swing.JButton btCancelar;
    public javax.swing.JButton btCargar;
    public javax.swing.JButton btCrearFac;
    public javax.swing.JButton btEliminar;
    public javax.swing.JButton btInsertar;
    public javax.swing.JButton btagregarArticulos;
    public javax.swing.JLabel etiquetaFecha;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNumerodeFactura;
    private javax.swing.JLabel jNombreCliente;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableDetalleFactura;
    public javax.swing.JLabel jlTotal;
    public javax.swing.JTextField txtCantidadArticulos;
    public javax.swing.JTextField txtCliente;
    public javax.swing.JTextField txtIdArticulo;
    public javax.swing.JTextField txtNombreArticulo;
    public javax.swing.JTextField txtPrecioUnitario;
    public javax.swing.JTextField txtidFactura;
    // End of variables declaration//GEN-END:variables
}
