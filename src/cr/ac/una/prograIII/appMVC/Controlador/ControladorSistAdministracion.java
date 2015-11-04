/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Conexion.MySQLConexion;
import cr.ac.una.prograIII.appMVC.Controlador.ServerControlador.ClienteHilo;
import cr.ac.una.prograIII.appMVC.Vista.InterFazSistemaAdministracion;
import cr.ac.una.prograIII.appMVC.Vista.MantUsuario;
import cr.ac.una.prograIII.appMVC.Vista.ManteArticulos;
import cr.ac.una.prograIII.appMVC.Vista.ManteCliente;
import cr.ac.una.prograIII.appMVC.Vista.ManteProveedores;
import cr.ac.una.prograIII.appMVC.Vista.ManteTelefono;
import cr.ac.una.prograIII.appMVC.Vista.Server;
import cr.ac.una.prograIII.appMVC.bl.ArticuloBL;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import cr.ac.una.prograIII.appMVC.bl.ProveedorBL;
import cr.ac.una.prograIII.appMVC.bl.TelefonoBL;
import cr.ac.una.prograIII.appMVC.bl.UsuarioBL;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author kevin
 */
public class ControladorSistAdministracion implements ActionListener {

    private InterFazSistemaAdministracion ManteAdmiView;
    private ArticuloBL articuloBlModelo;
    private ClienteBL clienteBlModelo;
    private ProveedorBL proveedorBlModelo;
    private TelefonoBL telefonoBlModelo;
    private UsuarioBL usuarioBLModelo;
    
    

    public UsuarioBL getUsuarioBLModelo() {
        return usuarioBLModelo;
    }

    public void setUsuarioBLModelo(UsuarioBL usuarioBLModelo) {
        this.usuarioBLModelo = usuarioBLModelo;
    }

    
    public ArticuloBL getArticuloBlModelo() {
        return articuloBlModelo;
    }

    public void setArticuloBlModelo(ArticuloBL articuloBlModelo) {
        this.articuloBlModelo = articuloBlModelo;
    }

    public ClienteBL getClienteBlModelo() {
        return clienteBlModelo;
    }

    public void setClienteBlModelo(ClienteBL clienteBlModelo) {
        this.clienteBlModelo = clienteBlModelo;
    }

    public ProveedorBL getProveedorBlModelo() {
        return proveedorBlModelo;
    }

    public void setProveedorBlModelo(ProveedorBL proveedorBlModelo) {
        this.proveedorBlModelo = proveedorBlModelo;
    }

    public TelefonoBL getTelefonoBlModelo() {
        return telefonoBlModelo;
    }

    public void setTelefonoBlModelo(TelefonoBL telefonoBlModelo) {
        this.telefonoBlModelo = telefonoBlModelo;
    }
    
    public InterFazSistemaAdministracion getManteAdmiView() {
        return ManteAdmiView;
    }

    public void setManteAdmiView(InterFazSistemaAdministracion ManteAdmiView) {
        this.ManteAdmiView = ManteAdmiView;
    }

    public ControladorSistAdministracion(InterFazSistemaAdministracion ManteAdmiView, ArticuloBL articuloBlModelo, 
        ClienteBL clienteBlModelo, ProveedorBL proveedorBlModelo, TelefonoBL telefonoBlModelo,UsuarioBL usuarioBL) {
        this.ManteAdmiView = ManteAdmiView;
        this.articuloBlModelo = articuloBlModelo;
        this.clienteBlModelo = clienteBlModelo;
        this.proveedorBlModelo = proveedorBlModelo;
        this.telefonoBlModelo = telefonoBlModelo;
        this.usuarioBLModelo= usuarioBL;
        this.ManteAdmiView.jMenuArticulo.addActionListener(this);
        this.ManteAdmiView.jMenuCliente.addActionListener(this);
        this.ManteAdmiView.jMenuProveedores.addActionListener(this);
        this.ManteAdmiView.jMenuTelefono.addActionListener(this);
        this.ManteAdmiView.jMenuUsuario.addActionListener(this);
        this.ManteAdmiView.MenuServer.addActionListener(this);
        this.ManteAdmiView.MenuPC.addActionListener(this);
        this.ManteAdmiView.ReporteCliente.addActionListener(this);
        inicializarPantalla();
    }

    
    
    private void inicializarPantalla() {
        this.ManteAdmiView.setEnabled(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.ManteAdmiView.jMenuProveedores){
            ManteProveedores mantProveedoresView = new ManteProveedores();
            ProveedorControlador provControlador ;
            provControlador  = new ProveedorControlador (mantProveedoresView, proveedorBlModelo );
            provControlador.getMantProveedorView().setVisible(true);
        }
        if(e.getSource()==this.ManteAdmiView.jMenuCliente){
            ManteCliente mantClienteView = new ManteCliente();
            ClienteControlador clientControlador;
            clientControlador = new ClienteControlador(mantClienteView, clienteBlModelo);
            clientControlador.getMantClienteview().setVisible(true);
        }
        
        if(e.getSource()==this.ManteAdmiView.jMenuUsuario){
            MantUsuario mantClienteView = new  MantUsuario();
            UsuarioControlador  usuControlador;
            usuControlador = new UsuarioControlador(mantClienteView,usuarioBLModelo);
            usuControlador.getMantUsuarioview().setVisible(true);
        }
        if(e.getSource()==this.ManteAdmiView.jMenuArticulo){
            ManteArticulos mantArticuloView= new ManteArticulos();
            ManteProveedores mantProveedoresView=new ManteProveedores();
            ArticuloControlador artControlador;
            artControlador = new ArticuloControlador(mantArticuloView,articuloBlModelo,proveedorBlModelo,mantProveedoresView);
            artControlador.getMantArticuloView().setVisible(true);
        }
        if(e.getSource()==this.ManteAdmiView.jMenuTelefono){
            ManteTelefono mantetelefonoView = new ManteTelefono();
            ManteCliente manteClienteView = new ManteCliente();
            TelefonoBL telefonoBLModelo = new  TelefonoBL();
            ClienteBL clienteBLModelo = new  ClienteBL();
            TelefonoControlador tControlador = new TelefonoControlador(mantetelefonoView,telefonoBLModelo,manteClienteView,clienteBLModelo); 
            tControlador.getMantTelfonoView().setVisible(true);
        }
        if(e.getSource()==this.ManteAdmiView.MenuServer){
             ArrayList<ClienteHilo> listaClientes =new ArrayList<>();
             Server serverView =new Server();
             ServerControlador serControlador = new ServerControlador(serverView,listaClientes);
             serControlador.getServerView().setVisible(true);
        
        }
        
        if(e.getSource()==this.ManteAdmiView.ReporteCliente){
        InputStream inputStream = null;
        try {            
            inputStream = new FileInputStream ("C:\\Users\\Gustavo\\Desktop\\repositorio\\CafeInternet\\src\\cr\\ac\\una\\prograIII\\appMVC\\Vista\\Reportes\\ListaClientes.jrxml");
            Map parameters = new HashMap();
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            
            MySQLConexion Con = new MySQLConexion();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,Con.getConexion());
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Gustavo\\Desktop\\ListaClientes.pdf");
            
            File file = new File("C:\\Users\\Gustavo\\Desktop\\ListaClientes.pdf");
            if (file.toString().endsWith(".pdf")) 
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
            else {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("ver si entra");
            System.err.println(ex.getMessage());
        }   catch (IOException ex) {
                Logger.getLogger(ControladorSistAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(ControladorSistAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorSistAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
    
}
