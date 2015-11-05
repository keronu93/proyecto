/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Domain.Articulos;
import cr.ac.una.prograIII.appMVC.Domain.DetalleFactura;
import cr.ac.una.prograIII.appMVC.Domain.Factura;
import cr.ac.una.prograIII.appMVC.Vista.AgregarFactura;
import cr.ac.una.prograIII.appMVC.Vista.ManteArticulos;
import cr.ac.una.prograIII.appMVC.Vista.ManteCliente;
import cr.ac.una.prograIII.appMVC.bl.ArticuloBL;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import cr.ac.una.prograIII.appMVC.bl.DetalleFacturaBL;
import cr.ac.una.prograIII.appMVC.bl.FacturaBL;
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
public class FacturaControlador implements ActionListener, DocumentListener{
    private AgregarFactura agregarFacturaView;
    private FacturaBL FacturaBlModelo;
    private ManteCliente mantClienteview;
    private ClienteBL clienteBlModelo; 
    private ManteArticulos mantArticuloView;
    private ArticuloBL ArticuloBLModelo;
    private DetalleFacturaBL DetalleFacturaBLModelo;

    public FacturaControlador(AgregarFactura agregarFacturaView, FacturaBL FacturaBlModelo, ManteCliente mantClienteview, ClienteBL clienteBlModelo, ManteArticulos mantArticuloView, ArticuloBL ArticuloBLModelo, DetalleFacturaBL DetalleFacturaBLModelo) {
        this.agregarFacturaView = agregarFacturaView;
        this.FacturaBlModelo = FacturaBlModelo;
        this.mantClienteview = mantClienteview;
        this.clienteBlModelo = clienteBlModelo;
        this.mantArticuloView = mantArticuloView;
        this.ArticuloBLModelo = ArticuloBLModelo;
        this.DetalleFacturaBLModelo = DetalleFacturaBLModelo;
        this.agregarFacturaView.btInsertar.addActionListener(this);
        this.agregarFacturaView.btBuscarCliente.addActionListener(this);
        this.agregarFacturaView.btBuscarId.addActionListener(this);
        this.agregarFacturaView.btCancelar.addActionListener(this);
        this.agregarFacturaView.btCargar.addActionListener(this);
        this.agregarFacturaView.btCrearFac.addActionListener(this);
        this.agregarFacturaView.btEliminar.addActionListener(this);
        this.agregarFacturaView.btagregarArticulos.addActionListener(this);
        inicializarPantalla();
    }

    public AgregarFactura getAgregarFacturaView() {
        return agregarFacturaView;
    }

    public void setAgregarFacturaView(AgregarFactura agregarFacturaView) {
        this.agregarFacturaView = agregarFacturaView;
    }

    public FacturaBL getFacturaBlModelo() {
        return FacturaBlModelo;
    }

    public void setFacturaBlModelo(FacturaBL FacturaBlModelo) {
        this.FacturaBlModelo = FacturaBlModelo;
    }

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

    public ManteArticulos getMantArticuloView() {
        return mantArticuloView;
    }

    public void setMantArticuloView(ManteArticulos mantArticuloView) {
        this.mantArticuloView = mantArticuloView;
    }

    public ArticuloBL getArticuloBLModelo() {
        return ArticuloBLModelo;
    }

    public void setArticuloBLModelo(ArticuloBL ArticuloBLModelo) {
        this.ArticuloBLModelo = ArticuloBLModelo;
    }

    public DetalleFacturaBL getDetalleFacturaBLModelo() {
        return DetalleFacturaBLModelo;
    }

    public void setDetalleFacturaBLModelo(DetalleFacturaBL DetalleFacturaBLModelo) {
        this.DetalleFacturaBLModelo = DetalleFacturaBLModelo;
    }
     private void inicializarPantalla() {
        this.agregarFacturaView.txtidFactura.setEnabled(false);
        this.agregarFacturaView.txtCliente.setEnabled(false);
        this.agregarFacturaView.EtiquetaTiempo.setEnabled(false);
        this.agregarFacturaView.etiquetaFecha.setEnabled(false);
        this.agregarFacturaView.EtiquetaValorHora.setEnabled(false);
        this.agregarFacturaView.txtNombreArticulo.setEnabled(false);
        this.agregarFacturaView.txtPrecioUnitario.setEnabled(false);
        this.agregarFacturaView.jlTotal.setEnabled(false);
    }
     
     public void llenarTabla(JTable tablaArticulos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaArticulos.setModel(modeloTabla);
        modeloTabla.addColumn("Id Articulo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio");

        Object fila[] = new Object[4];

        try {
            for (Object oAux : DetalleFacturaBLModelo.obtenerTodos()) {
                DetalleFactura df =(DetalleFactura)oAux;
                fila[0] = df.getFK_PK_idFacturacion();
                fila[1] = df.getFK_PK_idArticulo();
                fila[2] = df.getCantidad();
                fila[3] = df.getPrecioUnitario();
                
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mantArticuloView, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == this.agregarFacturaView.btInsertar) {
            
            Factura f = new Factura();
            f.setPk_idfacturacion(1); //como es auto generado no es relavante tomar el campo de texto id.
            f.setFk_idCliente(Integer.parseInt(this.mantArticuloView.txtIdProveedor.getText()));
            try {
               
                this.ArticuloBLModelo.insertar(a);
                llenarTabla(this.mantArticuloView.jTableArticulos);
                JOptionPane.showMessageDialog(mantArticuloView, "El Articulo ha sido ingresado correctamente", "Articulo Agregado", JOptionPane.INFORMATION_MESSAGE);
                this.mantArticuloView.TxtCantidad.setText(null);
                this.mantArticuloView.TxtPrecio.setText(null);
                this.mantArticuloView.txtDescripcion.setText(null);
                this.mantArticuloView.txtIdArticulo.setText(null);
                this.mantArticuloView.txtIdProveedor.setText(null);
                this.mantArticuloView.txtNombre.setText(null);
                this.mantArticuloView.btModificar.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(mantArticuloView, "Error al eliminar el Articulo:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
          }
        }
    

    @Override
    public void insertUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
