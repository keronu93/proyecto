/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;



import cr.ac.una.prograIII.appMVC.Domain.Telefono;
import cr.ac.una.prograIII.appMVC.Vista.MantTelefonoBuscar;
import cr.ac.una.prograIII.appMVC.bl.TelefonoBL;
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
public class TelefonoBuscarControlador implements  ActionListener {
    
    private MantTelefonoBuscar telefonoBuscarView;
    private TelefonoBL telefonoBLModelo;
    private JTextField txtRespuesta;

    /**
     *
     * @param telefonoBuscarView
     * @param telefonoBLModelo
     * @param txtRespuesta
     */
    public TelefonoBuscarControlador(MantTelefonoBuscar telefonoBuscarView, TelefonoBL telefonoBLModelo, JTextField txtRespuesta) {
        this.telefonoBuscarView = telefonoBuscarView;
        this.telefonoBLModelo = telefonoBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.telefonoBuscarView.btBuscar.addActionListener(this);
        this.telefonoBuscarView.btSeleccionar.addActionListener(this);
        llenarTabla(this.telefonoBuscarView.jTableBuscarTelefono);
    }

    /**
     *
     * @return
     */
    public MantTelefonoBuscar getTelefonoBuscarView() {
        return telefonoBuscarView;
    }

    /**
     *
     * @param telefonoBuscarView
     */
    public void setTelefonoBuscarView(MantTelefonoBuscar telefonoBuscarView) {
        this.telefonoBuscarView = telefonoBuscarView;
    }

    /**
     *
     * @return
     */
    public TelefonoBL getTelefonoBLModelo() {
        return telefonoBLModelo;
    }

    /**
     *
     * @param telefonoBLModelo
     */
    public void setTelefonoBLModelo(TelefonoBL telefonoBLModelo) {
        this.telefonoBLModelo = telefonoBLModelo;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    /**
     *
     * @param txtRespuesta
     */
    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.telefonoBuscarView.btBuscar){
            llenarTabla(this.telefonoBuscarView.jTableBuscarTelefono);
        }
        
        if(e.getSource() == this.telefonoBuscarView.btSeleccionar){
            int fila = this.telefonoBuscarView.jTableBuscarTelefono.getSelectedRow();
            if (fila != -1) {
            Integer idTelefono = Integer.parseInt(this.telefonoBuscarView.jTableBuscarTelefono.getValueAt(fila, 0).toString());
            txtRespuesta.setText(String.valueOf(idTelefono));
            this.telefonoBuscarView.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(telefonoBuscarView, "Error debe seleccionar un telefono:", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }
    }
    
    /**
     *
     * @param tablaTelefono
     */
    public void llenarTabla(JTable tablaTelefono) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaTelefono.setModel(modeloTabla);
        modeloTabla.addColumn("Id Telefono");
        modeloTabla.addColumn("Id Cliente");
        modeloTabla.addColumn("Tipo Telefono");
        modeloTabla.addColumn("Num. Telefono");
        Object fila[] = new Object[4];
        
        String Sql = "where Telefono like '%"+ this.telefonoBuscarView.txtBuscar.getText() +"%'";

        try {
            for (Object oAux : telefonoBLModelo.obtenerConWhere(new Telefono(), Sql)) {
                Telefono t = (Telefono) oAux;
                fila[0] = t.getPk_idTelefono();
                fila[1] = t.getFK_idCliente();
                fila[2] = t.getTipoTelfono();
                fila[3] = t.getNumeroTelefono();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
