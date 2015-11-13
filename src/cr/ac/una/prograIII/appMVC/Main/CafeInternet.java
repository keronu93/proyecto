/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Main;


import cr.ac.una.prograIII.appMVC.Controlador.ControladorSistAdministracion;
import cr.ac.una.prograIII.appMVC.Controlador.ServerControlador;
import cr.ac.una.prograIII.appMVC.Controlador.ValidarAcceso;
import cr.ac.una.prograIII.appMVC.Vista.InterFazSistemaAdministracion;
import cr.ac.una.prograIII.appMVC.Vista.Server;
import cr.ac.una.prograIII.appMVC.Vista.SolicitudUsuarioPassword;
import cr.ac.una.prograIII.appMVC.bl.ArticuloBL;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import cr.ac.una.prograIII.appMVC.bl.ProveedorBL;
import cr.ac.una.prograIII.appMVC.bl.TelefonoBL;
import cr.ac.una.prograIII.appMVC.bl.UsuarioBL;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class CafeInternet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
//         InterFazSistemaAdministracion manteAdmiView =new InterFazSistemaAdministracion();
//          ArticuloBL articuloBlModelo= new ArticuloBL();
//          ClienteBL clienteBlModelo= new ClienteBL();
//          ProveedorBL proveedorBlModelo= new ProveedorBL();
//          TelefonoBL telefonoBlModelo=new TelefonoBL();
//          UsuarioBL usuarioBLModelo = new UsuarioBL();
//          ControladorSistAdministracion admiControlador= new ControladorSistAdministracion(manteAdmiView,articuloBlModelo,clienteBlModelo,proveedorBlModelo,telefonoBlModelo,usuarioBLModelo);
//    
//          admiControlador.getManteAdmiView().setVisible(true);
//          ArrayList<ServerControlador.ClienteHilo> listaClientes =new ArrayList<>();
//          Server manteServerView = new Server();
//          ServerControlador serControlador = new  ServerControlador(manteServerView,listaClientes);
//          serControlador.getServerView().setVisible(true);
//          System.out.println("prueba");
            SolicitudUsuarioPassword solUsuarioPassword =new SolicitudUsuarioPassword();
            InterFazSistemaAdministracion ManteAdmiView= new InterFazSistemaAdministracion();
            SolicitudUsuarioPassword solUsePa = new SolicitudUsuarioPassword();
            ValidarAcceso validar = new ValidarAcceso(ManteAdmiView, solUsePa);
            validar.getSolUsePa().setVisible(true);
            
               
    }
    
}
