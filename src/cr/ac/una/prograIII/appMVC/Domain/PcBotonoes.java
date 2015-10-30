/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Domain;

import javax.swing.ImageIcon;

/**
 *
 * @author Gustavo
 */
public class PcBotonoes extends javax.swing.JButton{
    private Integer Boton;

    public PcBotonoes() {
        
    }
    

    public PcBotonoes(Integer Boton) {
        this.Boton = Boton;
        this.setVisible(true);
        this.setSize(90,90);
        ImageIcon icono=new ImageIcon("src/cr/ac/una/prograIII/appMVC/Vista/Images/pc2.png");
        this.setIcon(icono);
        
    }

    public Integer getBoton() {
        return Boton;
    }

    public void setBoton(Integer Boton) {
        this.Boton = Boton;
    }

    
    
    
    
}
