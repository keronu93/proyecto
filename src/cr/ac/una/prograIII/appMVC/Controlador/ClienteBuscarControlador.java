/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;

import cr.ac.una.prograIII.appMVC.Conexion.MySQLConexion;
import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import cr.ac.una.prograIII.appMVC.Vista.MantClienteBuscar;
import cr.ac.una.prograIII.appMVC.bl.ClienteBL;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
 * @author Gustavo
 */
public class ClienteBuscarControlador implements ActionListener {

    private MantClienteBuscar clienteBuscarView;
    private ClienteBL clienteBLModelo;
    private JTextField txtRespuesta;

    public ClienteBuscarControlador() {
    }

    public ClienteBuscarControlador(MantClienteBuscar clienteBuscarView, ClienteBL clienteBLModelo, JTextField txtRespuesta) {
        this.clienteBuscarView = clienteBuscarView;
        this.clienteBLModelo = clienteBLModelo;
        this.txtRespuesta = txtRespuesta;
        this.clienteBuscarView.btBuscar.addActionListener(this);
        this.clienteBuscarView.btSeleccionar.addActionListener(this);
        this.clienteBuscarView.BtVerFacturasCliente.addActionListener(this);
        llenarTabla(this.clienteBuscarView.jTBuscarCliente);
    }

    public MantClienteBuscar getClienteBuscarView() {
        return clienteBuscarView;
    }

    public void setClienteBuscarView(MantClienteBuscar clienteBuscarView) {
        this.clienteBuscarView = clienteBuscarView;
    }

    public ClienteBL getClienteBLModelo() {
        return clienteBLModelo;
    }

    public void setClienteBLModelo(ClienteBL clienteBLModelo) {
        this.clienteBLModelo = clienteBLModelo;
    }

    public JTextField getTxtRespuesta() {
        return txtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        this.txtRespuesta = txtRespuesta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.clienteBuscarView.btBuscar) {
            llenarTabla(this.clienteBuscarView.jTBuscarCliente);
        }

        if (e.getSource() == this.clienteBuscarView.btSeleccionar) {
            int fila = this.clienteBuscarView.jTBuscarCliente.getSelectedRow();
            if (fila != -1) {
                Integer idCliente = Integer.parseInt(this.clienteBuscarView.jTBuscarCliente.getValueAt(fila, 0).toString());
                txtRespuesta.setText(String.valueOf(idCliente));
                this.clienteBuscarView.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(clienteBuscarView, "Error debe seleccionar un cliente:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == this.clienteBuscarView.BtVerFacturasCliente) {
            int fila = this.clienteBuscarView.jTBuscarCliente.getSelectedRow();
            if (fila != -1) {
                Integer idCliente = Integer.parseInt(this.clienteBuscarView.jTBuscarCliente.getValueAt(fila, 0).toString());
                this.clienteBuscarView.setVisible(false);
                InputStream inputStream = null;
                try {
                    inputStream = new FileInputStream("C:\\Users\\Gustavo\\Desktop\\repositorio\\proyecto\\src\\cr\\ac\\una\\prograIII\\appMVC\\Vista\\Reportes\\FacturasCliente.jrxml");
                    Map parameters = new HashMap();
                    parameters.put("IdCliente", idCliente);
                    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

                    MySQLConexion Con = new MySQLConexion();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, Con.getConexion());
                    JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Gustavo\\Desktop\\FacturasCliente.pdf");

                    File file = new File("C:\\Users\\Gustavo\\Desktop\\FacturasCliente.pdf");
                    if (file.toString().endsWith(".pdf")) {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
                    } else {
                        Desktop desktop = Desktop.getDesktop();
                        desktop.open(file);
                    }

                } catch (FileNotFoundException ex) {

                    System.err.println(ex.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(ControladorSistAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(ControladorSistAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSistAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(clienteBuscarView, "Error debe seleccionar un cliente:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void llenarTabla(JTable tablaCliente) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaCliente.setModel(modeloTabla);

        modeloTabla.addColumn("Id Cliente");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");
        modeloTabla.addColumn("Fecha Nacimiento");

        Object fila[] = new Object[4];

        String Sql = "where apellidos like '%" + this.clienteBuscarView.txtBuscar.getText() + "%'";

        try {
            for (Object oAux : clienteBLModelo.obtenerConWhere(new Cliente(), Sql)) {
                Cliente c = (Cliente) oAux;
                fila[0] = c.getPK_idCliente();
                fila[1] = c.getNombre();
                fila[2] = c.getApellidos();
                fila[3] = c.getFechaNacimiento();
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error (llenarTabla):" + ex.getMessage(), "Error en llenarTabla", JOptionPane.ERROR_MESSAGE);
        }
    }

}
