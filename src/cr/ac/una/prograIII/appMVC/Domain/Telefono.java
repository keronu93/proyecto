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
    private Integer codtipo;

    /**
     *
     */
    public Telefono() {
    }

    /**
     *
     * @param Pk_idTelefono
     * @param FK_idCliente
     * @param tipoTelfono
     * @param numeroTelefono
     * @param ultUsuario
     * @param ultFecha
     * @param codtipo
     */
    public Telefono(Integer Pk_idTelefono, Integer FK_idCliente,String tipoTelfono,Integer numeroTelefono, String ultUsuario, String ultFecha, Integer codtipo ) {
        super(ultUsuario, ultFecha);
        this.Pk_idTelefono = Pk_idTelefono;
        this.FK_idCliente = FK_idCliente;
        this.tipoTelfono = tipoTelfono;
        this.numeroTelefono = numeroTelefono;
        this.codtipo = codtipo;
    }

    /**
     *
     * @return
     */
    public Integer getCodtipo() {
        return codtipo;
    }

    /**
     *
     * @param codtipo
     */
    public void setCodtipo(Integer codtipo) {
        this.codtipo = codtipo;
    }
    
    /**
     *
     * @return
     */
    public Integer getPk_idTelefono() {
        return Pk_idTelefono;
    }

    /**
     *
     * @param Pk_idTelefono
     */
    public void setPk_idTelefono(Integer Pk_idTelefono) {
        this.Pk_idTelefono = Pk_idTelefono;
    }

    /**
     *
     * @return
     */
    public Integer getFK_idCliente() {
        return FK_idCliente;
    }

    /**
     *
     * @param FK_idCliente
     */
    public void setFK_idCliente(Integer FK_idCliente) {
        this.FK_idCliente = FK_idCliente;
    }

    /**
     *
     * @return
     */
    public String getTipoTelfono() {
        return tipoTelfono;
    }

    /**
     *
     * @param tipoTelfono
     */
    public void setTipoTelfono(String tipoTelfono) {
        this.tipoTelfono = tipoTelfono;
    }

    /**
     *
     * @return
     */
    public Integer getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     *
     * @param numeroTelefono
     */
    public void setNumeroTelefono(Integer numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    

   
    
    
}
