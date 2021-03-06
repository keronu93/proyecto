/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;


import cr.ac.una.prograIII.appMVC.Domain.Usuario;
import cr.ac.una.prograIII.appMVC.Vista.MantUsuarioBuscar;
import cr.ac.una.prograIII.appMVC.bl.UsuarioBL;
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
public class UsuarioBuscarControlador implements  ActionListener {
    
    private MantUsuarioBuscar usuarioBuscarView;
    private UsuarioBL UsuarioBLModelo;
    private JTextField txtRespuesta;

    /**
     *
     */
    public UsuarioBuscarControlador() {
    }

    /**
     *
     * @param usuarioBuscarView
     * @param UsuarioBLModelo
     * @param txtRespuesta
     */
    public UsuarioBuscarControlador(MantUsuarioBuscar usuarioBuscarView, UsuarioBL UsuarioBLModelo, JTextField txtRespuesta) {
        this.usuarioBuscarView = usuarioBuscarView;
        this.UsuarioBLModelo = UsuarioBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.usuarioBuscarView.btBuscar.addActionListener(this);
        this.usuarioBuscarView.btSeleccionar.addActionListener(this);
        llenarTabla(this.usuarioBuscarView.jTableusuarios);
    }

    /**
     *
     * @return
     */
    public MantUsuarioBuscar getUsuarioBuscarView() {
        return usuarioBuscarView;
    }

    /**
     *
     * @param usuarioBuscarView
     */
    public void setUsuarioBuscarView(MantUsuarioBuscar usuarioBuscarView) {
        this.usuarioBuscarView = usuarioBuscarView;
    }

    /**
     *
     * @return
     */
    public UsuarioBL getUsuarioBLModelo() {
        return UsuarioBLModelo;
    }

    /**
     *
     * @param UsuarioBLModelo
     */
    public void setUsuarioBLModelo(UsuarioBL UsuarioBLModelo) {
        this.UsuarioBLModelo = UsuarioBLModelo;
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
    
    /**
     *
     * @param tablaUsuarios
     */
    public void llenarTabla(JTable tablaUsuarios) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaUsuarios.setModel(modeloTabla);

        modeloTabla.addColumn("Id Usuario");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Usuario");
        
        

        Object fila[] = new Object[3];
        
        String Sql = "where Nombre like '%"+ this.usuarioBuscarView.txtBuscar.getText() +"%'";

        try {
            for (Object oAux : UsuarioBLModelo.obtenerConWhere(new Usuario(), Sql)) {
                Usuario u = (Usuario) oAux;
                fila[0] = u.getPK_idUsuario();
                fila[1] = u.getNombre();
                fila[2] = u.getUsuario();
                
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == this.usuarioBuscarView.btBuscar){
            llenarTabla(this.usuarioBuscarView.jTableusuarios);
        }
        
        if(e.getSource() == this.usuarioBuscarView.btSeleccionar){
            int fila = this.usuarioBuscarView.jTableusuarios.getSelectedRow();
            if (fila != -1) {
            Integer idCliente = Integer.parseInt(this.usuarioBuscarView.jTableusuarios.getValueAt(fila, 0).toString());
            txtRespuesta.setText(String.valueOf(idCliente));
            this.usuarioBuscarView.setVisible(false);
            }else{
               JOptionPane.showMessageDialog(usuarioBuscarView, "Error debe seleccionar un usuario:", "Error", JOptionPane.ERROR_MESSAGE); 
            }
                            
        }
    }
    
}
