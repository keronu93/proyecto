/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Domain;

import cr.ac.una.prograIII.appMVC.Domain.BaseDomain;

/**
 *
 * @author kevin
 */
public class Proveedores extends BaseDomain {
    
    private Integer PK_IDProvedor;
    private String Nombre;
    private String Direccion;
    private String CorreoElectronico;
    private String Telefono;

    public Proveedores() {
    }

    public Proveedores(Integer PK_IDProvedor, String Nombre, String Direccion, String CorreoElectronico, String Telefono, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IDProvedor = PK_IDProvedor;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.CorreoElectronico = CorreoElectronico;
        this.Telefono = Telefono;
    }

    public Integer getPK_IDProvedor() {
        return PK_IDProvedor;
    }

    public void setPK_IDProvedor(Integer PK_IDProvedor) {
        this.PK_IDProvedor = PK_IDProvedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
  
    
}
