/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Controlador;


import cr.ac.una.prograIII.appMVC.Domain.PcBotonoes;
import cr.ac.una.prograIII.appMVC.Vista.VentanaPC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Gustavo
 */
public class PcControlador implements ActionListener, DocumentListener{
      ArrayList<PcBotonoes> ListaBotones;
      private VentanaPC viewVentana;
      private Integer p;

    public PcControlador() {
    }

    public PcControlador(ArrayList<PcBotonoes> ListaBotones, VentanaPC viewVentana, Integer p) {
        this.ListaBotones = ListaBotones;
        this.viewVentana = viewVentana;
        this.p=p;
        this.viewVentana.BtIniciar.addActionListener(this);
        this.viewVentana.BtTerminar.addActionListener(this);
    }

    public ArrayList<PcBotonoes> getListaBotones() {
        return ListaBotones;
    }

    public void setListaBotones(ArrayList<PcBotonoes> ListaBotones) {
        this.ListaBotones = ListaBotones;
    }

    public VentanaPC getViewVentana() {
        return viewVentana;
    }

    public void setViewVentana(VentanaPC viewVentana) {
        this.viewVentana = viewVentana;
    }
    
    
      
      

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.viewVentana.BtIniciar){
            PcBotonoes aux=new PcBotonoes(p);
            aux.setText("pc"+p);
            ListaBotones.add(aux);
        }
        //p.cargarpc.doclick(); para cargar el boton
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
