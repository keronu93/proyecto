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
public class Usuario extends BaseDomain {
    
    private Integer PK_idUsuario;
    private String nombre;
    private String usuario;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(Integer PK_idUsuario, String nombre, String usuario, String contraseña, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_idUsuario = PK_idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Integer getPK_idUsuario() {
        return PK_idUsuario;
    }

    public void setPK_idUsuario(Integer PK_idUsuario) {
        this.PK_idUsuario = PK_idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
