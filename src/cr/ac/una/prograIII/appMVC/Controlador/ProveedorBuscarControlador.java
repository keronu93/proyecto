/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;


import cr.ac.una.prograIII.appMVC.Domain.Proveedores;
import cr.ac.una.prograIII.appMVC.Vista.MantProovedorBuscar;
import cr.ac.una.prograIII.appMVC.bl.ProveedorBL;
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
public class ProveedorBuscarControlador implements  ActionListener {
    
    private MantProovedorBuscar proovedorBuscarView;
    private ProveedorBL proveedorBLModelo;
    private JTextField txtRespuesta;

    public ProveedorBuscarControlador() {
    }

    public ProveedorBuscarControlador(MantProovedorBuscar proovedorBuscarView, ProveedorBL proveedorBLModelo, JTextField txtRespuesta) {
        this.proovedorBuscarView = proovedorBuscarView;
        this.proveedorBLModelo = proveedorBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.proovedorBuscarView.btBuscar.addActionListener(this);
        this.proovedorBuscarView.btSeleccionar.addActionListener(this);
        llenarTabla(this.proovedorBuscarView.jTableProovedor);
    }

    public MantProovedorBuscar getProovedorBuscarView() {
        return proovedorBuscarView;
    }

    public void setProovedorBuscarView(MantProovedorBuscar proovedorBuscarView) {
        this.proovedorBuscarView = proovedorBuscarView;
    }

    public ProveedorBL getProveedorBLModelo() {
        return proveedorBLModelo;
    }

    public void setProveedorBLModelo(ProveedorBL proveedorBLModelo) {
        this.proveedorBLModelo = proveedorBLModelo;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == this.proovedorBuscarView.btBuscar){
            llenarTabla(this.proovedorBuscarView.jTableProovedor);
        }
        
        if(e.getSource() == this.proovedorBuscarView.btSeleccionar){
            int fila = this.proovedorBuscarView.jTableProovedor.getSelectedRow();
            if (fila != -1) {
            Integer idProveedor = Integer.parseInt(this.proovedorBuscarView.jTableProovedor.getValueAt(fila, 0).toString());
            txtRespuesta.setText(String.valueOf(idProveedor));
            this.proovedorBuscarView.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(proovedorBuscarView, "Error debe seleccionar un proveedor:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void llenarTabla(JTable tablaProoveedor) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaProoveedor.setModel(modeloTabla);

        modeloTabla.addColumn("Id Proovedor");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Correo Elec.");
        

        Object fila[] = new Object[4];
        
        String Sql = "where Nombre like '%"+ this.proovedorBuscarView.txtBuscar.getText() +"%'";

        try {
            for (Object oAux : proveedorBLModelo.obtenerConWhere(new Proveedores(), Sql)) {
                Proveedores p = (Proveedores) oAux;
                fila[0] = p.getPK_IDProvedor();
                fila[1] = p.getNombre();
                fila[2] = p.getTelefono();
                fila[3] = p.getCorreoElectronico();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
}
