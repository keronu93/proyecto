/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Domain.Articulos;
import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import cr.ac.una.prograIII.appMVC.Vista.MantClienteBuscar;
import cr.ac.una.prograIII.appMVC.Vista.ManteCliente;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
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
public class ClienteControlador implements ActionListener, DocumentListener  {

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
    
    

    public ClienteControlador(ManteCliente mantClienteview, ClienteBL clienteBlModelo) {
        this.mantClienteview = mantClienteview;
        this.clienteBlModelo = clienteBlModelo;
        this.mantClienteview.btBuscar.addActionListener(this);
        this.mantClienteview.btInsertar.addActionListener(this);
        this.mantClienteview.btCancelar.addActionListener(this);
        this.mantClienteview.btEliminar.addActionListener(this);
        this.mantClienteview.btModificar.addActionListener(this);
        this.mantClienteview.btCargar.addActionListener(this);
        this.mantClienteview.txtIdCliente.getDocument().addDocumentListener(this);
        this.mantClienteview.btModificar.setEnabled(false);
        this.mantClienteview.btEliminar.setEnabled(false);
        inicializarPantalla();
        
    }
    private void inicializarPantalla() {
        this.mantClienteview.txtIdCliente.setEnabled(false);
        llenarTabla(this.mantClienteview.jTableCliente);
        //this.mantClienteview.jDCFecNacimiento.setDate(new Date());
    }
    
    public void llenarTabla(JTable tablaClientes) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaClientes.setModel(modeloTabla);
        modeloTabla.addColumn("Id Cliente");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");
        modeloTabla.addColumn("Fec. Naci.");
        

        Object fila[] = new Object[4];

        try {
            for (Object oAux : clienteBlModelo.obtenerTodos()) {
                Cliente c = (Cliente) oAux;
                fila[0] = c.getPK_idCliente();
                fila[1] = c.getNombre();
                fila[2] = c.getApellidos();
                fila[3] = c.getFechaNacimiento();
                
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mantClienteview, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mantClienteview.btInsertar) {
            if(this.mantClienteview.txtNombre.getText().equals("")||this.mantClienteview.txtApellidos.getText().equals("")||this.mantClienteview.txtDireccion.getText().equals("")||this.mantClienteview.txtObservaciones.getText().equals("")){
                JOptionPane.showMessageDialog(mantClienteview, "Error faltan espacios por rellenar:", "Error!!! en ingresar Cliente", JOptionPane.ERROR_MESSAGE);
            }else{
            Cliente c = new Cliente();
            c.setPK_idCliente(1); 
            c.setNombre(this.mantClienteview.txtNombre.getText());
            c.setApellidos(this.mantClienteview.txtApellidos.getText());
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
            c.setFechaNacimiento(formatoFecha.format(this.mantClienteview.jDCFecNacimiento.getDate()));
            c.setDireccion(this.mantClienteview.txtDireccion.getText());
            c.setObservaciones(this.mantClienteview.txtObservaciones.getText());
            
            try {
                //se agrega el socio a la base de datos
                this.clienteBlModelo.insertar(c);
                llenarTabla(this.mantClienteview.jTableCliente);
                JOptionPane.showMessageDialog(mantClienteview, "El Cliente ha sido ingresado correctamente", "Cliente Agreagado", JOptionPane.INFORMATION_MESSAGE);
                this.mantClienteview.txtApellidos.setText(null);
                this.mantClienteview.txtDireccion.setText(null);
                this.mantClienteview.txtIdCliente.setText(null);
                this.mantClienteview.txtNombre.setText(null);
                this.mantClienteview.txtObservaciones.setText(null);
                this.mantClienteview.jDCFecNacimiento.setCalendar(null);
                this.mantClienteview.btModificar.setEnabled(true);
                
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantClienteview, "Error al agregar el Cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantClienteview, "Error al eliminar el Cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            
        } if (e.getSource() == this.mantClienteview.btEliminar) {
           if(this.mantClienteview.jTableCliente.getRowCount()!=0&&this.mantClienteview.jTableCliente.getRowCount()!=-1){
            Cliente c = new Cliente();
            int fila = this.mantClienteview.jTableCliente.getSelectedRow();
            int idCliente = Integer.parseInt(this.mantClienteview.txtIdCliente.getText());
            c.setPK_idCliente(idCliente);
            try {
                int resp;
                resp=JOptionPane.showConfirmDialog(mantClienteview, "Esta seguro que desea eliminar el Cliente");
                if(resp==0){
                clienteBlModelo.eliminar(c);
                llenarTabla(this.mantClienteview.jTableCliente);
                JOptionPane.showMessageDialog(mantClienteview, "El Cliente ha sido eliminado correctamente", "Cliente Eliminado", JOptionPane.INFORMATION_MESSAGE);
                this.mantClienteview.txtApellidos.setText(null);
                this.mantClienteview.txtDireccion.setText(null);
                this.mantClienteview.txtIdCliente.setText(null);
                this.mantClienteview.txtNombre.setText(null);
                this.mantClienteview.txtObservaciones.setText(null);
                this.mantClienteview.jDCFecNacimiento.setCalendar(null);
                this.mantClienteview.btEliminar.setEnabled(false);
                }if(resp==1){
                    JOptionPane.showMessageDialog(mantClienteview, "El Cliente no sera eliminado ",
                        "Cliente Eliminado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantClienteview, "Error al eliminar el Cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantClienteview, "Error al eliminar el Cliente:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            }else{
                JOptionPane.showMessageDialog(mantClienteview, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }if (e.getSource() == this.mantClienteview.btCargar) {
            if(this.mantClienteview.jTableCliente.getRowCount()!=0&&this.mantClienteview.jTableCliente.getRowCount()!=-1){
                Cliente c = new Cliente();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                int fila = this.mantClienteview.jTableCliente.getSelectedRow();
                int aux = Integer.parseInt(this.mantClienteview.jTableCliente.getValueAt(fila, 0).toString());
                c.setPK_idCliente(aux);
                try {
                    c = clienteBlModelo.obtenerPorId(c);
                    this.mantClienteview.txtIdCliente.setText(c.getPK_idCliente().toString());
                    this.mantClienteview.txtNombre.setText(c.getNombre().toString());
                    this.mantClienteview.txtApellidos.setText(c.getApellidos().toString());

                    String fechaN = c.getFechaNacimiento().trim();
                    try {
                        java.util.Date dato = formatoFecha.parse(fechaN);
                        this.mantClienteview.jDCFecNacimiento.setDate(dato);
                    } catch (ParseException ex) {
                        System.out.println("error con fecha");
                    }

                    this.mantClienteview.txtDireccion.setText(c.getDireccion().toString());
                    this.mantClienteview.txtObservaciones.setText(c.getObservaciones().toString());
                    this.mantClienteview.btEliminar.setEnabled(true);
                    this.mantClienteview.btModificar.setEnabled(true);

                } catch (SQLException ex) {
                    Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(mantClienteview, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }if(e.getSource()==this.mantClienteview.btModificar){
            if(this.mantClienteview.txtNombre.getText().equals("")||this.mantClienteview.txtApellidos.getText().equals("")||this.mantClienteview.txtDireccion.getText().equals("")||this.mantClienteview.txtObservaciones.getText().equals("")){
              JOptionPane.showMessageDialog(mantClienteview, "Error al cargar primero debe seleccionar un Cliente:", "Error", JOptionPane.ERROR_MESSAGE);  
            }else{
             if(this.mantClienteview.jTableCliente.getRowCount()!=0&&this.mantClienteview.jTableCliente.getRowCount()!=-1){
             Cliente c = new Cliente();
            
             //int fila = Integer.parseInt(this.mantClienteview.txtIdCliente.getText());
             c.setPK_idCliente( Integer.parseInt(this.mantClienteview.txtIdCliente.getText()));
                
            try {
                c = clienteBlModelo.obtenerPorId(c);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                    c.setNombre(this.mantClienteview.txtNombre.getText());
                    c.setApellidos(this.mantClienteview.txtApellidos.getText());
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
                    c.setFechaNacimiento(formatoFecha.format(this.mantClienteview.jDCFecNacimiento.getDate()));
                    c.setDireccion(this.mantClienteview.txtDireccion.getText());
                    c.setObservaciones(this.mantClienteview.txtObservaciones.getText());
                   try {
                
                        this.clienteBlModelo.modificar(c);
                        llenarTabla(this.mantClienteview.jTableCliente);
                        JOptionPane.showMessageDialog(mantClienteview, "El Cliente ha sido modificado correctamente", 
                                "Cliente Modificado", JOptionPane.INFORMATION_MESSAGE);
                        this.mantClienteview.txtApellidos.setText(null);
                        this.mantClienteview.txtDireccion.setText(null);
                        this.mantClienteview.txtIdCliente.setText(null);
                        this.mantClienteview.txtNombre.setText(null);
                        this.mantClienteview.txtObservaciones.setText(null);
                        this.mantClienteview.jDCFecNacimiento.setCalendar(null);
                        this.mantClienteview.btEliminar.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantClienteview, "Error al modificar  al cliente:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantClienteview, "Error al eliminar al cliente:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
              }else{
                JOptionPane.showMessageDialog(mantClienteview, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }          
           } 
        } if (e.getSource() == this.mantClienteview.btCancelar){
            this.mantClienteview.txtNombre.setText(null);
            this.mantClienteview.txtApellidos.setText(null);
            this.mantClienteview.txtDireccion.setText(null);
            this.mantClienteview.txtIdCliente.setText(null);
            this.mantClienteview.txtObservaciones.setText(null);
            this.mantClienteview.jDCFecNacimiento.setDate(null);
            this.mantClienteview.btEliminar.setEnabled(false);
            
        }if (e.getSource() == this.mantClienteview.btBuscar) { 
            MantClienteBuscar mantClienteBuscarView = new MantClienteBuscar();
            ClienteBuscarControlador clienteBControlador ;
            clienteBControlador = new ClienteBuscarControlador(mantClienteBuscarView, 
                    clienteBlModelo, 
                    this.mantClienteview.txtIdCliente);
            clienteBControlador.getClienteBuscarView().setVisible(true);
            this.mantClienteview.btEliminar.setEnabled(true);
        }
        
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargarCliente();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargarCliente();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargarCliente();
    }
    private void cargarCliente() {
        Cliente c = new Cliente();
        if (!this.mantClienteview.txtIdCliente.getText().isEmpty()) {
            c.setPK_idCliente(Integer.parseInt(this.mantClienteview.txtIdCliente.getText()));
            try {
                c = clienteBlModelo.obtenerPorId(c);
                this.mantClienteview.txtNombre.setText(c.getNombre());
                this.mantClienteview.txtApellidos.setText(c.getApellidos());
                this.mantClienteview.txtDireccion.setText(c.getDireccion());
                this.mantClienteview.txtObservaciones.setText(c.getObservaciones());
                String fecha[] = c.getFechaNacimiento().split("-");
                java.util.Date date = new GregorianCalendar(Integer.parseInt(fecha[0]), 
                         Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2])).getTime();
                this.mantClienteview.jDCFecNacimiento.setDate(date);
                

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantClienteview, "Error no se pudo consultar el Cliente (" + ex.getMessage() + ")",
                        "Error al cargar el Cliente", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
