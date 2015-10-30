/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Domain;


/**
 *
 * @author Gustavo
 */
public class Cliente extends BaseDomain {
    private Integer PK_idCliente;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String direccion;
    private String observaciones;

    public Cliente() {
    }

    public Cliente(Integer PK_idCliente, String nombre, String apellidos, String fechaNacimiento, String direccion, String observaciones, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_idCliente = PK_idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.observaciones = observaciones;
    }

    public Integer getPK_idCliente() {
        return PK_idCliente;
    }

    public void setPK_idCliente(Integer PK_idCliente) {
        this.PK_idCliente = PK_idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
