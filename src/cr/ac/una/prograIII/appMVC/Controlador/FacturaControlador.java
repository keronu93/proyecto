/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Vista.AgregarFactura;
import cr.ac.una.prograIII.appMVC.Vista.ManteArticulos;
import cr.ac.una.prograIII.appMVC.Vista.ManteCliente;
import cr.ac.una.prograIII.appMVC.bl.ArticuloBL;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import cr.ac.una.prograIII.appMVC.bl.DetalleFacturaBL;
import cr.ac.una.prograIII.appMVC.bl.FacturaBL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
