/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Conexion.MySQLConexion;
import cr.ac.una.prograIII.appMVC.Vista.InterFazSistemaAdministracion;
import cr.ac.una.prograIII.appMVC.Vista.Server;
import cr.ac.una.prograIII.appMVC.Vista.SolicitudUsuarioPassword;
import cr.ac.una.prograIII.appMVC.bl.ArticuloBL;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import cr.ac.una.prograIII.appMVC.bl.ProveedorBL;
import cr.ac.una.prograIII.appMVC.bl.TelefonoBL;
import cr.ac.una.prograIII.appMVC.bl.UsuarioBL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Gustavo
 */
public class ValidarAcceso implements ActionListener, DocumentListener {
    MySQLConexion metodos= new MySQLConexion();
    private InterFazSistemaAdministracion ManteAdmiView;
    private SolicitudUsuarioPassword solUsePa;

    public InterFazSistemaAdministracion getManteAdmiView() {
        return ManteAdmiView;
    }

    public void setManteAdmiView(InterFazSistemaAdministracion ManteAdmiView) {
        this.ManteAdmiView = ManteAdmiView;
    }

    public MySQLConexion getMetodos() {
        return metodos;
    }

    public void setMetodos(MySQLConexion metodos) {
        this.metodos = metodos;
    }

    public SolicitudUsuarioPassword getSolUsePa() {
        return solUsePa;
    }

    public void setSolUsePa(SolicitudUsuarioPassword solUsePa) {
        this.solUsePa = solUsePa;
    }

    public ValidarAcceso(InterFazSistemaAdministracion ManteAdmiView, SolicitudUsuarioPassword solUsePa) {
        this.ManteAdmiView = ManteAdmiView;
        this.solUsePa = solUsePa;
        this.solUsePa.BtIngresar.addActionListener(this);
    }

    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.solUsePa.BtIngresar) {
            if(validadIngreso()==1){
                this.solUsePa.dispose();
                JOptionPane.showMessageDialog(null, "Bienbenido has ingresado"
                                                +"Satisfactoriamente al Sistema de Administracion Cafe Internet","Mensaje de Bienvenida", 
                                                JOptionPane.INFORMATION_MESSAGE);
                InterFazSistemaAdministracion ManteAdmiView = new InterFazSistemaAdministracion();
                ArticuloBL articuloBlModelo = new ArticuloBL();
                ClienteBL clienteBlModelo= new ClienteBL();
                ProveedorBL proveedorBlModelo = new ProveedorBL();
                TelefonoBL telefonoBlModelo = new TelefonoBL();
                UsuarioBL usuarioBLModelo = new UsuarioBL();
                ControladorSistAdministracion controlador = new ControladorSistAdministracion(ManteAdmiView,articuloBlModelo,clienteBlModelo, proveedorBlModelo, telefonoBlModelo,usuarioBLModelo);
                controlador.getManteAdmiView().setVisible(true);
                ArrayList<ServerControlador.ClienteHilo> listaClientes =new ArrayList<>();
                Server manteServerView = new Server();
                ServerControlador serControlador = new  ServerControlador(manteServerView,listaClientes);
                serControlador.getServerView().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Acceso Denegado"
                                                +"por favor ingrese su usuario y contrasena correctos ","Acceso Denegado", 
                                                JOptionPane.ERROR_MESSAGE);
            
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
       validadIngreso();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        validadIngreso();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validadIngreso();
    }
     public int validadIngreso(){
        
        String usuario= solUsePa.txtUsuario.getText();
        String password= String.valueOf(solUsePa.TxtPassword.getPassword());
        
        int resultado= 0;
        String SSQL="SELECT * FROM usuarios WHERE usuario='"+ usuario+"'AND Contraseña=('"+password+"')";
        Connection connect= null;
        try {
            connect= metodos.getConexion();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            if(rs.next()){
                resultado=1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de Conexion ", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                connect.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error de Desconexion ", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }
     
       

}
