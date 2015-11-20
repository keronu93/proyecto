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

    /**
     *
     */
    public Cliente() {
    }

    /**
     *
     * @param PK_idCliente
     * @param nombre
     * @param apellidos
     * @param fechaNacimiento
     * @param direccion
     * @param observaciones
     * @param ultUsuario
     * @param ultFecha
     */
    public Cliente(Integer PK_idCliente, String nombre, String apellidos, String fechaNacimiento, String direccion, String observaciones, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_idCliente = PK_idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.observaciones = observaciones;
    }

    /**
     *
     * @return
     */
    public Integer getPK_idCliente() {
        return PK_idCliente;
    }

    /**
     *
     * @param PK_idCliente
     */
    public void setPK_idCliente(Integer PK_idCliente) {
        this.PK_idCliente = PK_idCliente;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     *
     * @param observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
