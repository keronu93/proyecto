/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import cr.ac.una.prograIII.appMVC.Domain.Telefono;
import cr.ac.una.prograIII.appMVC.Vista.MantClienteBuscar;
import cr.ac.una.prograIII.appMVC.Vista.MantTelefonoBuscar;
import cr.ac.una.prograIII.appMVC.Vista.ManteCliente;
import cr.ac.una.prograIII.appMVC.Vista.ManteTelefono;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import cr.ac.una.prograIII.appMVC.bl.TelefonoBL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class TelefonoControlador implements ActionListener, DocumentListener {
    
    private ManteTelefono mantTelfonoView;
    private TelefonoBL telefonoBLModelo;
    private ManteCliente mantClienteview;
    private ClienteBL clienteBlModelo;


    public ManteCliente getMantClienteview() {
        return mantClienteview;
    }

    public void setMantClienteview(ManteCliente mantClienteview) {
        this.mantClienteview = mantClienteview;
    }

    public ClienteBL getClienteBlModelo() {
        return clienteBlModelo;
    }

    public void setClienteBlModelo(ClienteBL clienteBlModelo) {
        this.clienteBlModelo = clienteBlModelo;
    }
    


    public ManteTelefono getMantTelfonoView() {
        return mantTelfonoView;
    }

    public void setMantTelfonoView(ManteTelefono mantTelfonoView) {
        this.mantTelfonoView = mantTelfonoView;
    }

    public TelefonoBL getTelefonoBLModelo() {
        return telefonoBLModelo;
    }

    public void setTelefonoBLModelo(TelefonoBL telefonoBLModelo) {
        this.telefonoBLModelo = telefonoBLModelo;
    }

    public TelefonoControlador(ManteTelefono mantTelfonoView, TelefonoBL telefonoBLModelo,ManteCliente mantClienteview,ClienteBL clienteBlModelo ) {
        this.mantTelfonoView = mantTelfonoView;
        this.telefonoBLModelo = telefonoBLModelo;
        this.mantClienteview = mantClienteview;
        this.clienteBlModelo = clienteBlModelo;
        this.mantTelfonoView.btBuscarCliente.addActionListener(this);
        this.mantTelfonoView.btCancelar.addActionListener(this);
        this.mantTelfonoView.btCargar.addActionListener(this);
        this.mantTelfonoView.btEliminar.addActionListener(this);
        this.mantTelfonoView.btInsertar.addActionListener(this);
        this.mantTelfonoView.btModificar.addActionListener(this);
        this.mantTelfonoView.btBuscar.addActionListener(this);
        this.mantTelfonoView.btEliminar.setEnabled(false);
        this.mantTelfonoView.btModificar.setEnabled(false);
        inicializarPantalla();
    }
    
     private void inicializarPantalla() {
        this.mantTelfonoView.txtidTelefono.setEnabled(false);
        llenarTabla(this.mantTelfonoView.jTableTelfono);
    }
     
     public void llenarTabla(JTable tablaTelefonos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaTelefonos.setModel(modeloTabla);
         modeloTabla.addColumn("Id Telefono");
        modeloTabla.addColumn("Id Cliente");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Num. Telefono");
        
        

        Object fila[] = new Object[4];

        try {
            for (Object oAux : telefonoBLModelo.obtenerTodos()) {
                Telefono t = (Telefono) oAux;
                fila[0] = t.getPk_idTelefono();
                fila[1] = t.getFK_idCliente();
                fila[2] = t.getTipoTelfono();
                fila[3] = t.getNumeroTelefono();
                
                
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mantTelfonoView, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.mantTelfonoView.btInsertar) {
            if(this.mantTelfonoView.txtIdCliente.getText().equals("")||this.mantTelfonoView.txtNumero.getText().equals("")){
                JOptionPane.showMessageDialog(mantTelfonoView, "Error faltan espacios por rellenar:", "Error en ingresar el Telefono", JOptionPane.ERROR_MESSAGE);
            }else{
                Telefono t = new Telefono();
                t.setPk_idTelefono(1);
                t.setFK_idCliente(Integer.parseInt(this.mantTelfonoView.txtIdCliente.getText())); 
                t.setNumeroTelefono(Integer.parseInt(this.mantTelfonoView.txtNumero.getText()));
                String tipo="";
                int x=0;
                if(mantTelfonoView.chckCasa.isSelected()){
                    tipo= "Casa";
                    x=1;
                }
                if(mantTelfonoView.chckCelular.isSelected()){
                    tipo="Celular";
                    x=2;
                }
                if(mantTelfonoView.chckOficina.isSelected()){
                    tipo="Oficina";
                    x=3;
                }
                t.setTipoTelfono(tipo);
                t.setCodtipo(x);
                System.out.println("insertando codigo "+t.getCodtipo());
            try {
                
                this.telefonoBLModelo.insertar(t);
                llenarTabla(this.mantTelfonoView.jTableTelfono);
                JOptionPane.showMessageDialog(mantTelfonoView, "El Numero de Telefono ha sido ingresado correctamente", "Numerod de telefono Agreagado", JOptionPane.INFORMATION_MESSAGE);
                this.mantTelfonoView.txtIdCliente.setText(null);
                this.mantTelfonoView.txtNumero.setText(null);
                this.mantTelfonoView.txtidTelefono.setText(null);
                this.mantTelfonoView.chckCasa.setSelected(false);
                this.mantTelfonoView.chckCelular.setSelected(false);
                this.mantTelfonoView.chckOficina.setSelected(false);
                this.mantTelfonoView.btModificar.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantTelfonoView, "Error al agregar el Numero de Telefono:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantTelfonoView, "Error al eliminar el Numero de Telefono:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            
        }if (e.getSource() == this.mantTelfonoView.btEliminar) {
            if(this.mantTelfonoView.jTableTelfono.getRowCount()!=0&&this.mantTelfonoView.jTableTelfono.getRowCount()!=-1){
            Telefono t = new Telefono();
            int fila = this.mantTelfonoView.jTableTelfono.getSelectedRow();
            int idTelefono = Integer.parseInt(this.mantTelfonoView.txtidTelefono.getText());
            t.setPk_idTelefono(idTelefono);
            try {
                telefonoBLModelo.eliminar(t);
                llenarTabla(this.mantTelfonoView.jTableTelfono);
                JOptionPane.showMessageDialog(mantTelfonoView, "El Telefono ha sido eliminado correctamente", "Telefono Eliminado", JOptionPane.INFORMATION_MESSAGE);
                this.mantTelfonoView.btEliminar.setEnabled(false);
                this.mantTelfonoView.txtIdCliente.setText(null);
                this.mantTelfonoView.txtNumero.setText(null);
                this.mantTelfonoView.txtidTelefono.setText(null);
                this.mantTelfonoView.chckCasa.setSelected(false);
                this.mantTelfonoView.chckCelular.setSelected(false);
                this.mantTelfonoView.chckOficina.setSelected(false);
            } catch (SQLException ex) {
                Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantTelfonoView, "Error al eliminar el Telefono:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantTelfonoView, "Error al eliminar el Telefono:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            }else{
                JOptionPane.showMessageDialog(mantTelfonoView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }if (e.getSource() == this.mantTelfonoView.btCargar) {
            
            if(this.mantTelfonoView.jTableTelfono.getRowCount()!=0&&this.mantTelfonoView.jTableTelfono.getRowCount()!=-1){
                Telefono t = new Telefono();
                int fila = this.mantTelfonoView.jTableTelfono.getSelectedRow();
                t.setPk_idTelefono(Integer.parseInt(this.mantTelfonoView.jTableTelfono.getValueAt(fila, 0).toString()));
                System.out.println("ojo " +t.getPk_idTelefono());
                try {
                    t = telefonoBLModelo.obtenerPorId(t);
                    this.mantTelfonoView.txtidTelefono.setText(String.valueOf(t.getPk_idTelefono().toString()));
                    this.mantTelfonoView.txtIdCliente.setText(String.valueOf(t.getFK_idCliente().toString()));
                    if(mantTelfonoView.chckCasa.equals("Casa")){
                        mantTelfonoView.chckCasa.setSelected(true);
                    }
                    if(mantTelfonoView.chckCelular.equals("Celular")){
                        mantTelfonoView.chckCelular.setSelected(true);
                    }
                    if(mantTelfonoView.chckOficina.equals("Oficina")){
                        mantTelfonoView.chckOficina.setSelected(true);
                    }
                    //this.mantTelfonoView.jCTelefono.setSelectedItem(t.getTipoTelfono());
                    //this.mantTelfonoView.jCTelefono.getSelectedItem().toString();
                    this.mantTelfonoView.txtNumero.setText(String.valueOf(t.getNumeroTelefono().toString()));
                    this.mantTelfonoView.btEliminar.setEnabled(true);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(mantTelfonoView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
          
        }if(e.getSource()==this.mantTelfonoView.btModificar){
            if(this.mantTelfonoView.txtIdCliente.getText().equals("")||this.mantTelfonoView.txtNumero.getText().equals("")){
                JOptionPane.showMessageDialog(mantTelfonoView, "Error debe seleccionar un telefono:", "Error en modificar el Telefono", JOptionPane.ERROR_MESSAGE);
            }else{
            if(this.mantTelfonoView.jTableTelfono.getRowCount()!=0&&this.mantTelfonoView.jTableTelfono.getRowCount()!=-1){
             Telefono t = new Telefono();
            
             
             t.setPk_idTelefono(Integer.parseInt(this.mantTelfonoView.txtIdCliente.getText()));
                
            try {
                t = telefonoBLModelo.obtenerPorId(t);
            } catch (SQLException ex) {
                Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }       
                    t.setFK_idCliente(Integer.parseInt(this.mantTelfonoView.txtIdCliente.getText())); 
                    t.setNumeroTelefono(Integer.parseInt(this.mantTelfonoView.txtNumero.getText()));
                    String tipo="";
                    int x=0;
                if(mantTelfonoView.chckCasa.isSelected()){
                    tipo= "Casa";
                    x=1;
                }
                if(mantTelfonoView.chckCelular.isSelected()){
                    tipo="Celular";
                    x=2;
                }
                if(mantTelfonoView.chckOficina.isSelected()){
                    tipo="Oficina";
                    x=3;
                }
                t.setTipoTelfono(tipo);
                t.setCodtipo(x);
                
                   try {
                
                        this.telefonoBLModelo.modificar(t);
                        llenarTabla(this.mantTelfonoView.jTableTelfono);
                        JOptionPane.showMessageDialog(mantTelfonoView, "El Telefono ha sido modificado correctamente", 
                                "Telefono Modificado", JOptionPane.INFORMATION_MESSAGE);
                        this.mantTelfonoView.txtIdCliente.setText(null);
                        this.mantTelfonoView.txtNumero.setText(null);
                        this.mantTelfonoView.txtidTelefono.setText(null);
                        this.mantTelfonoView.btEliminar.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantTelfonoView, "Error al modificar  el Telefono:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantTelfonoView, "Error al eliminar el Telefono:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
              }else{
                JOptionPane.showMessageDialog(mantTelfonoView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }          
            }  
        }if (e.getSource() == this.mantTelfonoView.btCancelar){
            this.mantTelfonoView.txtidTelefono.setText(null);
            this.mantTelfonoView.txtNumero.setText(null);
            this.mantTelfonoView.chckCasa.setSelected(false);
            this.mantTelfonoView.chckCelular.setSelected(false);
            this.mantTelfonoView.chckOficina.setSelected(false);
            this.mantTelfonoView.txtIdCliente.setText(null);
            this.mantTelfonoView.btEliminar.setEnabled(false);
            
        }
        if (e.getSource() == this.mantTelfonoView.btBuscar) { 
            MantTelefonoBuscar mantTelBuscarView = new MantTelefonoBuscar();
            TelefonoBuscarControlador telefonoBControlador ;
            telefonoBControlador = new TelefonoBuscarControlador(mantTelBuscarView, 
                    telefonoBLModelo, 
                    this.mantTelfonoView.txtIdCliente);
            telefonoBControlador.getTelefonoBuscarView().setVisible(true);
            this.mantTelfonoView.btEliminar.setEnabled(true);
             
        }if (e.getSource() == this.mantTelfonoView.btBuscarCliente) { 
            MantClienteBuscar mantClienteBuscarView = new MantClienteBuscar();
            ClienteBuscarControlador clienteBControlador ;
            clienteBControlador = new ClienteBuscarControlador(mantClienteBuscarView, 
                    clienteBlModelo, 
                    this.mantTelfonoView.txtIdCliente);
            clienteBControlador.getClienteBuscarView().setVisible(true);
             
        }
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
       cargarTelefono();
        cargarCliente();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargarTelefono();
        cargarCliente();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargarTelefono();
        cargarCliente();
    }
    
     private void cargarTelefono() {
       Telefono t = new Telefono();
        if (!this.mantTelfonoView.txtidTelefono.getText().isEmpty()) {
            t.setPk_idTelefono(Integer.parseInt(this.mantTelfonoView.txtidTelefono.getText()));
            try {
                t = telefonoBLModelo.obtenerPorId(t);
                this.mantTelfonoView.txtIdCliente.setText(String.valueOf(t.getFK_idCliente().toString()));
                this.mantTelfonoView.txtNumero.setText(String.valueOf(t.getNumeroTelefono().toString()));
                
                System.out.println("ojo:en el cargar "+t.getNumeroTelefono());
                if(t.getCodtipo()==1){
                    mantTelfonoView.chckCasa.setSelected(true);
                }
                if(t.getCodtipo()==2){
                    mantTelfonoView.chckCelular.setSelected(true);
                }
                if(t.getCodtipo()==3){
                    mantTelfonoView.chckOficina.setSelected(true);
                }
                

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantTelfonoView, "Error no se pudo consultar el Telefono (" + ex.getMessage() + ")",
                        "Error al cargar el telefono", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      private void cargarCliente() {
      Cliente c = new Cliente();
        if (!this.mantTelfonoView.txtIdCliente.getText().isEmpty()) {
            c.setPK_idCliente(Integer.parseInt(this.mantTelfonoView.txtIdCliente.getText()));
            try {
                c = clienteBlModelo.obtenerPorId(c);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantTelfonoView, "Error no se pudo consultar el Cliente (" + ex.getMessage() + ")",
                        "Error al cargar el cliente", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(TelefonoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

   
    
}
