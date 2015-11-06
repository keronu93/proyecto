/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import cr.ac.una.prograIII.appMVC.Vista.MantClienteBuscar;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
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
public class ClienteBuscarControlador implements  ActionListener{

    private MantClienteBuscar clienteBuscarView;
    private ClienteBL clienteBLModelo;
    private JTextField txtRespuesta;

    public ClienteBuscarControlador() {
    }

    public ClienteBuscarControlador(MantClienteBuscar clienteBuscarView, ClienteBL clienteBLModelo, JTextField txtRespuesta) {
        this.clienteBuscarView = clienteBuscarView;
        this.clienteBLModelo = clienteBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.clienteBuscarView.btBuscar.addActionListener(this);
        this.clienteBuscarView.btSeleccionar.addActionListener(this);
        llenarTabla(this.clienteBuscarView.jTBuscarCliente);
    }

    public MantClienteBuscar getClienteBuscarView() {
        return clienteBuscarView;
    }

    public void setClienteBuscarView(MantClienteBuscar clienteBuscarView) {
        this.clienteBuscarView = clienteBuscarView;
    }

    public ClienteBL getClienteBLModelo() {
        return clienteBLModelo;
    }

    public void setClienteBLModelo(ClienteBL clienteBLModelo) {
        this.clienteBLModelo = clienteBLModelo;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.clienteBuscarView.btBuscar){
            llenarTabla(this.clienteBuscarView.jTBuscarCliente);
        }
        
        if(e.getSource() == this.clienteBuscarView.btSeleccionar){
            int fila = this.clienteBuscarView.jTBuscarCliente.getSelectedRow();
            if (fila != -1) {
            Integer idCliente = Integer.parseInt(this.clienteBuscarView.jTBuscarCliente.getValueAt(fila, 0).toString());
            txtRespuesta.setText(String.valueOf(idCliente));
            
            this.clienteBuscarView.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(clienteBuscarView, "Error debe seleccionar un cliente:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
     public void llenarTabla(JTable tablaCliente) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaCliente.setModel(modeloTabla);

        modeloTabla.addColumn("Id Cliente");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");
        modeloTabla.addColumn("Fecha Nacimiento");
        

        Object fila[] = new Object[4];
        
        String Sql = "where apellidos like '%"+ this.clienteBuscarView.txtBuscar.getText() +"%'";

        try {
            for (Object oAux : clienteBLModelo.obtenerConWhere(new Cliente(), Sql)) {
                Cliente c = (Cliente) oAux;
                fila[0] = c.getPK_idCliente();
                fila[1] = c.getNombre();
                fila[2] = c.getApellidos();
                fila[3] = c.getFechaNacimiento();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
