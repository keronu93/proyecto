/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;


import cr.ac.una.prograIII.appMVC.Controlador.ClienteControlador;
import cr.ac.una.prograIII.appMVC.Domain.Proveedores;
import cr.ac.una.prograIII.appMVC.Vista.MantClienteBuscar;
import cr.ac.una.prograIII.appMVC.Vista.MantProovedorBuscar;
import cr.ac.una.prograIII.appMVC.Vista.ManteProveedores;
import cr.ac.una.prograIII.appMVC.bl.ProveedorBL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class ProveedorControlador implements ActionListener, DocumentListener{

    private ManteProveedores mantProveedorView;
    private ProveedorBL ProveedorBLModelo;

    /**
     *
     * @return
     */
    public ManteProveedores getMantProveedorView() {
        return mantProveedorView;
    }

    /**
     *
     * @param mantProveedorView
     */
    public void setMantProveedorView(ManteProveedores mantProveedorView) {
        this.mantProveedorView = mantProveedorView;
    }

    /**
     *
     * @return
     */
    public ProveedorBL getProveedorBLModelo() {
        return ProveedorBLModelo;
    }

    /**
     *
     * @param ProveedorBLModelo
     */
    public void setProveedorBLModelo(ProveedorBL ProveedorBLModelo) {
        this.ProveedorBLModelo = ProveedorBLModelo;
    }

    /**
     *
     * @param mantProveedorView
     * @param ProveedorBLModelo
     */
    public ProveedorControlador(ManteProveedores mantProveedorView, ProveedorBL ProveedorBLModelo) {
        this.mantProveedorView = mantProveedorView;
        this.ProveedorBLModelo = ProveedorBLModelo;
        
        this.mantProveedorView.btInsertar.addActionListener(this);
        this.mantProveedorView.btEliminar.addActionListener(this);
        this.mantProveedorView.btModificar.addActionListener(this);
        this.mantProveedorView.btCancelar.addActionListener(this);
        this.mantProveedorView.btCargar.addActionListener(this);
        this.mantProveedorView.btBuscar.addActionListener(this);
        this.mantProveedorView.txtIdProveedor.getDocument().addDocumentListener(this);
        this.mantProveedorView.btModificar.setEnabled(false);
        this.mantProveedorView.btEliminar.setEnabled(false);
        inicializarPantalla();
    }
    
    private void inicializarPantalla() {
       this.mantProveedorView.txtIdProveedor.setEnabled(false);
        llenarTabla(this.mantProveedorView.jTableProveedor);
    }
     
    /**
     *
     * @param TablaProovedores
     */
    public void llenarTabla(JTable TablaProovedores) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        TablaProovedores.setModel(modeloTabla);
        modeloTabla.addColumn("Id Proveedor");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Correo Elec");

        Object fila[] = new Object[4];

        try {
            for (Object oAux : ProveedorBLModelo.obtenerTodos()) {
                Proveedores p = (Proveedores) oAux;
                fila[0] = p.getPK_IDProvedor();
                fila[1] = p.getNombre();
                fila[2] = p.getTelefono();
                fila[3] = p.getCorreoElectronico();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mantProveedorView, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == this.mantProveedorView.btInsertar) {
            
            if(this.mantProveedorView.txtNombre.getText().equals("")||this.mantProveedorView.txtCorreo.getText().equals("")||this.mantProveedorView.txtCorreo.getText().equals("")||this.mantProveedorView.txtDireccion.getText().equals(""))
            {
                JOptionPane.showMessageDialog(mantProveedorView, "Error faltan espacios por rellenar:", "Error en ingresar articulo", JOptionPane.ERROR_MESSAGE);
            }
            else{
            Proveedores p = new Proveedores();
            p.setPK_IDProvedor(1); //como es auto generado no es relavante tomar el campo de texto id.
            p.setNombre(this.mantProveedorView.txtNombre.getText());
            p.setTelefono(this.mantProveedorView.txtTelefono.getText());
            p.setCorreoElectronico(this.mantProveedorView.txtCorreo.getText());
            p.setDireccion(this.mantProveedorView.txtDireccion.getText());
            try {
                if(this.isEmail(this.mantProveedorView.txtCorreo.getText())){
                this.ProveedorBLModelo.insertar(p);
                llenarTabla(this.mantProveedorView.jTableProveedor);
                JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor ha sido ingresado correctamente", "Proveedor Agreagado", JOptionPane.INFORMATION_MESSAGE);
                this.mantProveedorView.txtNombre.setText(null);
                this.mantProveedorView.txtIdProveedor.setText(null);
                this.mantProveedorView.txtTelefono.setText(null);
                this.mantProveedorView.txtCorreo.setText(null);
                this.mantProveedorView.txtDireccion.setText(null);
                this.mantProveedorView.btModificar.setEnabled(true);
                }else{
                JOptionPane.showMessageDialog(mantProveedorView, "Error ingrese el correo nuevamente:", "Error en ingresar correo", JOptionPane.ERROR_MESSAGE);
                this.mantProveedorView.txtCorreo.setText(null);
            }        
                        
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantProveedorView, "Error al agregar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
          }
        }
       if (e.getSource() == this.mantProveedorView.btEliminar){
           if(this.mantProveedorView.jTableProveedor.getRowCount()!=0&&this.mantProveedorView.jTableProveedor.getRowCount()!=-1){
            Proveedores p = new Proveedores();
            
            int fila = this.mantProveedorView.jTableProveedor.getSelectedRow();
            
            int idProveedor = Integer.parseInt(this.mantProveedorView.txtIdProveedor.getText());
            p.setPK_IDProvedor(idProveedor);
                try {
                    int resp;
                    resp=JOptionPane.showConfirmDialog(mantProveedorView, "Esta seguro que desea eliminar el Proveedor");
                    if(resp==0){
                    ProveedorBLModelo.eliminar(p);
                    llenarTabla(this.mantProveedorView.jTableProveedor);
                    JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor ha sido eliminado correctamente", "Proveedor Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    this.mantProveedorView.txtNombre.setText(null);
                    this.mantProveedorView.txtIdProveedor.setText(null);
                    this.mantProveedorView.txtTelefono.setText(null);
                    this.mantProveedorView.txtCorreo.setText(null);
                    this.mantProveedorView.txtDireccion.setText(null);
                    this.mantProveedorView.btModificar.setEnabled(true);
                    this.mantProveedorView.btEliminar.setEnabled(false);
                    }
                    if(resp==1){
                        JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor no sera eliminado ",
                        "Proveedor Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar el Proveedor:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                }
           else{
                    JOptionPane.showMessageDialog(mantProveedorView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
                }
           
       }
       if (e.getSource() == this.mantProveedorView.btCargar) {
            if(this.mantProveedorView.jTableProveedor.getRowCount()!=0&&this.mantProveedorView.jTableProveedor.getRowCount()!=-1){
                Proveedores p = new Proveedores();
                
                int fila = this.mantProveedorView.jTableProveedor.getSelectedRow();
                
                p.setPK_IDProvedor(Integer.parseInt(this.mantProveedorView.jTableProveedor.getValueAt(fila, 0).toString()));
                try {
                    p = ProveedorBLModelo.obtenerPorId(p);
                    this.mantProveedorView.txtIdProveedor.setText(p.getPK_IDProvedor().toString());
                    this.mantProveedorView.txtNombre.setText(p.getNombre().toString());
                    this.mantProveedorView.txtCorreo.setText(p.getTelefono().toString());
                    this.mantProveedorView.txtCorreo.setText(p.getCorreoElectronico().toString());
                    this.mantProveedorView.txtDireccion.setText(p.getDireccion().toString());
                    this.mantProveedorView.btModificar.setEnabled(true);
                    this.mantProveedorView.btEliminar.setEnabled(true);
                                
                } catch (SQLException ex) {
                    Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(mantProveedorView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }
       }
       if(e.getSource()==this.mantProveedorView.btModificar){
           if(this.mantProveedorView.txtIdProveedor.getText().equals("") || this.mantProveedorView.txtNombre.getText().equals("")||this.mantProveedorView.txtCorreo.getText().equals("")||this.mantProveedorView.txtCorreo.getText().equals("")||this.mantProveedorView.txtDireccion.getText().equals("")){
               JOptionPane.showMessageDialog(mantProveedorView, "Error al Modificar debe seleccionar antes un proveedor:", "Error", JOptionPane.ERROR_MESSAGE);
           }else{
             if(this.mantProveedorView.jTableProveedor.getRowCount()!=0&&this.mantProveedorView.jTableProveedor.getRowCount()!=-1){
             Proveedores p = new Proveedores();
            
            
             p.setPK_IDProvedor(Integer.parseInt(this.mantProveedorView.txtIdProveedor.getText()));
                
            try {
                p = ProveedorBLModelo.obtenerPorId(p);
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                    p.setNombre(this.mantProveedorView.txtNombre.getText());
                    p.setCorreoElectronico(this.mantProveedorView.txtCorreo.getText());
                    p.setTelefono(String.valueOf(this.mantProveedorView.txtTelefono.getText()));
                    p.setDireccion(this.mantProveedorView.txtDireccion.getText());
                   
                    
                   try {
                
                        this.ProveedorBLModelo.modificar(p);
                        llenarTabla(this.mantProveedorView.jTableProveedor);
                        JOptionPane.showMessageDialog(mantProveedorView, "El Proveedor ha sido modificado correctamente", 
                                "Proveedor Modificado", JOptionPane.INFORMATION_MESSAGE);
                        this.mantProveedorView.txtNombre.setText(null);
                        this.mantProveedorView.txtIdProveedor.setText(null);
                        this.mantProveedorView.txtTelefono.setText(null);
                        this.mantProveedorView.txtCorreo.setText(null);
                        this.mantProveedorView.txtDireccion.setText(null);
                        this.mantProveedorView.btEliminar.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantProveedorView, "Error al modificar  al proveedor:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantProveedorView, "Error al eliminar al proveedor:" + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
              }else{
                JOptionPane.showMessageDialog(mantProveedorView, "Error al cargar la tabla esta vacia:", "Error", JOptionPane.ERROR_MESSAGE);
            }          
           }  
        }
       if (e.getSource() == this.mantProveedorView.btCancelar){
            this.mantProveedorView.txtNombre.setText(null);
            this.mantProveedorView.txtCorreo.setText(null);
            this.mantProveedorView.txtDireccion.setText(null);
            this.mantProveedorView.txtTelefono.setText(null);
            this.mantProveedorView.txtIdProveedor.setText(null);
            this.mantProveedorView.txtCorreo.setText(null);
            this.mantProveedorView.btEliminar.setEnabled(false);
        }
       if (e.getSource() == this.mantProveedorView.btBuscar) { 
            MantProovedorBuscar mantBuscarView = new MantProovedorBuscar();
            ProveedorBuscarControlador pBControlador ;
            pBControlador = new ProveedorBuscarControlador(mantBuscarView, 
                    ProveedorBLModelo, 
                    this.mantProveedorView.txtIdProveedor);
            pBControlador.getProovedorBuscarView().setVisible(true);
            this.mantProveedorView.btEliminar.setEnabled(true);
        }
       
    }

    /**
     *
     * @param correo
     * @return
     */
    public boolean isEmail(String correo) {
    Pattern pat = null;
    Matcher mat = null; 
    pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
    mat = pat.matcher(correo);
    if (mat.find()) {
    return true;
    }else{
    return false;
    } 
}
    
    
    
    @Override
    public void insertUpdate(DocumentEvent de) {
        cargarProveedor();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        cargarProveedor();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        cargarProveedor();
    }
    private void cargarProveedor() {
        Proveedores p = new Proveedores();
        if (!this.mantProveedorView.txtIdProveedor.getText().isEmpty()) {
            p.setPK_IDProvedor(Integer.parseInt(this.mantProveedorView.txtIdProveedor.getText()));
            try {
                p = ProveedorBLModelo.obtenerPorId(p);
                this.mantProveedorView.txtNombre.setText(p.getNombre());
                this.mantProveedorView.txtDireccion.setText(p.getDireccion());
                this.mantProveedorView.txtTelefono.setText(p.getTelefono());
                this.mantProveedorView.txtCorreo.setText(p.getCorreoElectronico());
                
                

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantProveedorView, "Error no se pudo consultar el Proveedor (" + ex.getMessage() + ")",
                        "Error al cargar el Proveedor", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ProveedorControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}

