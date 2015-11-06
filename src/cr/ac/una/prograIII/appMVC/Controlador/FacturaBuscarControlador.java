/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Domain.Factura;
import cr.ac.una.prograIII.appMVC.Vista.BuscarFactura;
import cr.ac.una.prograIII.appMVC.bl.DetalleFacturaBL;
import cr.ac.una.prograIII.appMVC.bl.FacturaBL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class FacturaBuscarControlador implements  ActionListener {
    
    private BuscarFactura buscarFacturaView;
    private FacturaBL facturablModelo;
    private DetalleFacturaBL detalleblModelo;
    private JTextField txtRespuesta;

    public FacturaBuscarControlador(BuscarFactura buscarFacturaView, FacturaBL facturablModelo, DetalleFacturaBL detalleblModelo, JTextField txtRespuesta) {
        this.buscarFacturaView = buscarFacturaView;
        this.facturablModelo = facturablModelo;
        this.detalleblModelo = detalleblModelo;
        this.txtRespuesta = txtRespuesta;
        this.buscarFacturaView.btBuscar1.addActionListener(this);
        this.buscarFacturaView.btSeleccionar.addActionListener(this);
    }

    public BuscarFactura getBuscarFacturaView() {
        return buscarFacturaView;
    }

    public void setBuscarFacturaView(BuscarFactura buscarFacturaView) {
        this.buscarFacturaView = buscarFacturaView;
    }

    public FacturaBL getFacturablModelo() {
        return facturablModelo;
    }

    public void setFacturablModelo(FacturaBL facturablModelo) {
        this.facturablModelo = facturablModelo;
    }

    public DetalleFacturaBL getDetalleblModelo() {
        return detalleblModelo;
    }

    public void setDetalleblModelo(DetalleFacturaBL detalleblModelo) {
        this.detalleblModelo = detalleblModelo;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }
     public void llenarTabla(JTable tablaFctura) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaFctura.setModel(modeloTabla);

        modeloTabla.addColumn("Id de Factura");
        modeloTabla.addColumn("Id Cliente");
        modeloTabla.addColumn("Fecha de compra");
        modeloTabla.addColumn("Monto");
        
        

        Object fila[] = new Object[4];
        
        String Sql = "where Nombre like '%"+ this.buscarFacturaView.txtBuscar.getText() +"%'";

        try {
            for (Object oAux : facturablModelo.obtenerConWhere(new Factura(), Sql)) {
                Factura f = (Factura) oAux;
                fila[0] = f.getPk_idfacturacion();
                fila[1] = f.getFk_idCliente();
                //fila[2] = 
                
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == this.buscarFacturaView.btBuscar1){
           llenarTabla(this.buscarFacturaView.tablaFacturas);
        } if(e.getSource() == this.buscarFacturaView.btSeleccionar){
            int fila = this.buscarFacturaView.tablaFacturas.getSelectedRow();
            if (fila != -1) {
            Integer idFactura = Integer.parseInt(this.buscarFacturaView.tablaFacturas.getValueAt(fila, 0).toString());
            txtRespuesta.setText(String.valueOf(idFactura));
            
            this.buscarFacturaView.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(buscarFacturaView, "Error debe seleccionar la Factura:", "Error", JOptionPane.ERROR_MESSAGE);
            }
                
        }
    }
    
}
