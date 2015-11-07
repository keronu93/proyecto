/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Domain.Articulos;
import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import cr.ac.una.prograIII.appMVC.Domain.DetalleFactura;
import cr.ac.una.prograIII.appMVC.Domain.Factura;
import cr.ac.una.prograIII.appMVC.Vista.AgregarFactura;
import cr.ac.una.prograIII.appMVC.Vista.BuscarFactura;
import cr.ac.una.prograIII.appMVC.Vista.MantArticuloBuscar;
import cr.ac.una.prograIII.appMVC.Vista.MantClienteBuscar;
import cr.ac.una.prograIII.appMVC.Vista.ManteArticulos;
import cr.ac.una.prograIII.appMVC.Vista.ManteCliente;
import cr.ac.una.prograIII.appMVC.bl.ArticuloBL;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import cr.ac.una.prograIII.appMVC.bl.DetalleFacturaBL;
import cr.ac.una.prograIII.appMVC.bl.FacturaBL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
public class FacturaControlador implements ActionListener, DocumentListener {

    private AgregarFactura agregarFacturaView;
    private FacturaBL FacturaBlModelo;
    private ManteCliente mantClienteview;
    private ClienteBL clienteBlModelo;
    private ManteArticulos mantArticuloView;
    private ArticuloBL ArticuloBLModelo;
    private DetalleFacturaBL DetalleFacturaBLModelo;
    private Calendar calendario = Calendar.getInstance();
    private String Fecha;
    ArrayList<Articulos> listAr=new ArrayList();

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
        this.agregarFacturaView.BtAgregarArticulo.addActionListener(this);
        this.agregarFacturaView.btBuscarArticulos.addActionListener(this);
        this.agregarFacturaView.txtIdArticulo.getDocument().addDocumentListener(this);
        this.agregarFacturaView.txtCliente.getDocument().addDocumentListener(this);
        
        

        inicializarPantalla();
    }

    public ArrayList<Articulos> getListAr() {
        return listAr;
    }

    public void setListAr(ArrayList<Articulos> listAr) {
        this.listAr = listAr;
    }
    
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }

    public Calendar getCalendario() {
        return calendario;
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
        this.agregarFacturaView.txtIdArticulo.setEnabled(false);
        this.agregarFacturaView.EtiquetaTiempo.setEnabled(false);
        this.agregarFacturaView.etiquetaFecha.setText(calendario.getTime().toString());
        this.agregarFacturaView.EtiquetaValorHora.setEnabled(false);
        this.agregarFacturaView.txtNombreArticulo.setEnabled(false);
        this.agregarFacturaView.txtPrecioUnitario.setEnabled(false);
        this.agregarFacturaView.jlTotal.setEnabled(false);
        this.agregarFacturaView.btEliminar.setEnabled(false);
        this.agregarFacturaView.TxTNombreCliente.setEnabled(false);
        this.agregarFacturaView.TxtApellidosCliente.setEnabled(false);
        llenarTabla(this.agregarFacturaView.jTableDetalleFactura);
    }

    public void llenarTabla(JTable tablaArticulos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaArticulos.setModel(modeloTabla);
        modeloTabla.addColumn("Id Articulo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Subtotal");

        Object fila[] = new Object[4];

        for (Articulos a : listAr) {
            fila[0] = a.getPK_IDArticulo();
            fila[1] = a.getNombre();
            fila[2] = a.getCantidadExistencia();
            fila[3] = a.getPrecioUnitario();
            modeloTabla.addRow(fila);
        }
        tablaArticulos.setModel(modeloTabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.agregarFacturaView.btInsertar) {
            if(this.agregarFacturaView.txtCliente.getText().isEmpty()||this.agregarFacturaView.txtCantidadArticulos.getText().equals("")||this.agregarFacturaView.txtNombreArticulo.getText().equals("")||this.agregarFacturaView.txtPrecioUnitario.getText().equals(""))
            {
                JOptionPane.showMessageDialog(agregarFacturaView, "Error faltan espacios por rellenar:", "Error al Realizar la factura", JOptionPane.ERROR_MESSAGE);
            }
            else{
            Factura f = new Factura();
            DetalleFactura df = new DetalleFactura();
            f.setPk_idfacturacion(1); //como es auto generado no es relavante tomar el campo de texto id.
            f.setFk_idCliente(Integer.parseInt(this.agregarFacturaView.txtCliente.getText()));
            df.setFK_PK_idArticulo(Integer.parseInt(this.agregarFacturaView.txtIdArticulo.getText()));
            df.setPrecioUnitario(Double.parseDouble(this.agregarFacturaView.txtPrecioUnitario.getText()));
            
            df.setCantidad(Integer.parseInt(this.agregarFacturaView.txtCantidadArticulos.getText()));
            try {

                this.FacturaBlModelo.insertar(f);
                this.DetalleFacturaBLModelo.insertar(df);
                llenarTabla(this.agregarFacturaView.jTableDetalleFactura);
                //double total;
                //int cant=Integer.parseInt(this.agregarFacturaView.txtCantidadArticulos.getText());
                //int valor=Integer.parseInt(this.agregarFacturaView.txtPrecioUnitario.getText());
                //total=cant*valor;
                //this.agregarFacturaView.jlTotal.setText();
                JOptionPane.showMessageDialog(agregarFacturaView, "la Factura ha sido ingresado correctamente", "Factura Agregada", JOptionPane.INFORMATION_MESSAGE);
                this.agregarFacturaView.txtCantidadArticulos.setText(null);
                this.agregarFacturaView.txtCliente.setText(null);
                this.agregarFacturaView.txtIdArticulo.setText(null);
                this.agregarFacturaView.txtNombreArticulo.setText(null);
                this.agregarFacturaView.txtPrecioUnitario.setText(null);
                this.agregarFacturaView.txtidFactura.setText(null);
                
            } catch (SQLException ex) {

                Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(agregarFacturaView, "Error al agregar la Factura:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(agregarFacturaView, "Error al eliminar la Factura:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
        if (e.getSource() == this.agregarFacturaView.btEliminar) {
            Factura f = new Factura();

            int fila = this.agregarFacturaView.jTableDetalleFactura.getSelectedRow();
            int idFactura = Integer.parseInt(this.agregarFacturaView.txtidFactura.getText());
            f.setPk_idfacturacion(idFactura);
            System.out.println(f.getPk_idfacturacion());
            try {
                int resp;
                resp = JOptionPane.showConfirmDialog(agregarFacturaView, "Esta seguro que desea eliminar la Factura");
                if (resp == 0) {
                    FacturaBlModelo.eliminar(f);
                    llenarTabla(this.agregarFacturaView.jTableDetalleFactura);
                    JOptionPane.showMessageDialog(agregarFacturaView, "La Factura ha sido eliminado correctamente", "Proveedor Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    this.agregarFacturaView.txtCantidadArticulos.setText(null);
                    this.agregarFacturaView.txtCliente.setText(null);
                    this.agregarFacturaView.txtIdArticulo.setText(null);
                    this.agregarFacturaView.txtNombreArticulo.setText(null);
                    this.agregarFacturaView.txtPrecioUnitario.setText(null);
                    this.agregarFacturaView.txtidFactura.setText(null);
                }
                if (resp == 1) {
                    JOptionPane.showMessageDialog(agregarFacturaView, "La Factura sera eliminado ",
                            "Factura Eliminado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(agregarFacturaView, "Error al eliminar La Factura:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(agregarFacturaView, "Error al eliminar La Factura:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == this.agregarFacturaView.btCargar) {
            Factura f = new Factura();
            DetalleFactura df = new DetalleFactura();
            int fila = this.agregarFacturaView.jTableDetalleFactura.getSelectedRow();
            f.setPk_idfacturacion( Integer.parseInt(this.agregarFacturaView.jTableDetalleFactura.getValueAt(fila, 1).toString()));
            try {                    
                    f = FacturaBlModelo.obtenerPorId(f);
                    df= DetalleFacturaBLModelo.obtenerPorId(df);
                    this.agregarFacturaView.txtidFactura.setText(String.valueOf(f.getPk_idfacturacion().toString()));
                    this.agregarFacturaView.txtIdArticulo.setText(String.valueOf(df.getFK_PK_idArticulo().toString()));
                    this.agregarFacturaView.txtCliente.setText(String.valueOf(f.getFk_idCliente().toString()));
                    
                    this.agregarFacturaView.txtPrecioUnitario.setText(String.valueOf(df.getPrecioUnitario()));
                    this.agregarFacturaView.txtCantidadArticulos.setText(String.valueOf(df.getCantidad().toString()));
                    this.mantArticuloView.btEliminar.setEnabled(true);
                                
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        if (e.getSource() == this.agregarFacturaView.btBuscarArticulos) {

            MantArticuloBuscar mantArticuloBuscarView = new MantArticuloBuscar();
            ArticuloBuscarControlador articuloBControlador;
            articuloBControlador = new ArticuloBuscarControlador(mantArticuloBuscarView,
                    ArticuloBLModelo,
                    this.agregarFacturaView.txtIdArticulo);
            
            articuloBControlador.getArticuloBuscarView().setVisible(true);

        }
        if (e.getSource() == this.agregarFacturaView.btBuscarCliente) {
            MantClienteBuscar mantClienteBuscarView = new MantClienteBuscar();
            ClienteBuscarControlador clienteBControlador;
            clienteBControlador = new ClienteBuscarControlador(mantClienteBuscarView,
                    clienteBlModelo, this.agregarFacturaView.txtCliente);
            clienteBControlador.getClienteBuscarView().setVisible(true);

        }
        if (e.getSource() == this.agregarFacturaView.btCancelar) {
            this.agregarFacturaView.txtCantidadArticulos.setText(null);
            this.agregarFacturaView.txtCliente.setText(null);
            this.agregarFacturaView.txtIdArticulo.setText(null);
            this.agregarFacturaView.txtNombreArticulo.setText(null);
            this.agregarFacturaView.txtPrecioUnitario.setText(null);
            this.agregarFacturaView.txtidFactura.setText(null);
            this.agregarFacturaView.EtiquetaTiempo.setText("0.0");
            
        }
        if (e.getSource() == this.agregarFacturaView.btBuscarId) {
            BuscarFactura BuscarView = new BuscarFactura();
            FacturaBuscarControlador FacturaBControlador;
            FacturaBControlador = new FacturaBuscarControlador(BuscarView,
                    FacturaBlModelo, this.agregarFacturaView.txtidFactura);
            FacturaBControlador.getBuscarFacturaView().setVisible(true);

        }if(e.getSource() == this.agregarFacturaView.BtAgregarArticulo){
            Articulos a = new Articulos();
            a.setPK_IDArticulo(Integer.parseInt(this.agregarFacturaView.txtIdArticulo.getText()));
            a.setNombre(this.agregarFacturaView.txtNombreArticulo.getText());
            a.setCantidadExistencia(Integer.parseInt(this.agregarFacturaView.txtCantidadArticulos.getText()));
            a.setPrecioUnitario(Double.parseDouble(this.agregarFacturaView.txtPrecioUnitario.getText()));
            listAr.add(a);
            
        }
        if(e.getSource() == this.agregarFacturaView.btCrearFac){
            if(this.agregarFacturaView.jTableDetalleFactura.equals("")){
                JOptionPane.showMessageDialog(agregarFacturaView, "Error faltan espacios por rellenar:", "Error al Realizar la factura", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        cargarArticulo();
        cargarCliente();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        cargarArticulo();
        cargarCliente();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        cargarArticulo();
        cargarCliente();
    }

    private void cargarArticulo() {
        Articulos a = new Articulos();
        if (!this.agregarFacturaView.txtIdArticulo.getText().isEmpty()) {
            a.setPK_IDArticulo(Integer.parseInt(this.agregarFacturaView.txtIdArticulo.getText()));
            try {
                a = ArticuloBLModelo.obtenerPorId(a);
                this.agregarFacturaView.txtNombreArticulo.setText(a.getNombre().toString());
                this.agregarFacturaView.txtPrecioUnitario.setText(String.valueOf(a.getPrecioUnitario()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mantArticuloView, "Error no se pudo consultar el Articulo (" + ex.getMessage() + ")",
                        "Error al cargar el Articulo", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cargarCliente() {
        Cliente c = new Cliente();
        if (!this.agregarFacturaView.txtCliente.getText().isEmpty()) {
            c.setPK_idCliente(Integer.parseInt(this.agregarFacturaView.txtCliente.getText()));
            try {
                c = clienteBlModelo.obtenerPorId(c);
                this.agregarFacturaView.TxTNombreCliente.setText(c.getNombre().toString());
                this.agregarFacturaView.TxtApellidosCliente.setText(c.getApellidos().toString());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(agregarFacturaView, "Error no se pudo consultar el Cliente (" + ex.getMessage() + ")",
                        "Error al cargar el cliente", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    

}
