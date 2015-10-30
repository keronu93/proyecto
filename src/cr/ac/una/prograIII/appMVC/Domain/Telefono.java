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
public class Telefono extends BaseDomain {
    
    private Integer Pk_idTelefono;
    private Integer FK_idCliente;
    private String tipoTelfono;
    private Integer numeroTelefono;

    public Telefono() {
    }

    public Telefono(Integer Pk_idTelefono, Integer FK_idCliente, String tipoTelfono, Integer numeroTelefono, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.Pk_idTelefono = Pk_idTelefono;
        this.FK_idCliente = FK_idCliente;
        this.tipoTelfono = tipoTelfono;
        this.numeroTelefono = numeroTelefono;
    }

    public Integer getPk_idTelefono() {
        return Pk_idTelefono;
    }

    public void setPk_idTelefono(Integer Pk_idTelefono) {
        this.Pk_idTelefono = Pk_idTelefono;
    }

    public Integer getFK_idCliente() {
        return FK_idCliente;
    }

    public void setFK_idCliente(Integer FK_idCliente) {
        this.FK_idCliente = FK_idCliente;
    }

    public String getTipoTelfono() {
        return tipoTelfono;
    }

    public void setTipoTelfono(String tipoTelfono) {
        this.tipoTelfono = tipoTelfono;
    }

    public Integer getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(Integer numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    

   
    
    
}
