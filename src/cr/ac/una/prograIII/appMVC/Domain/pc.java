/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Domain;

/**
 *
 * @author kevin
 */
public class pc {
    
    private Integer idPc;
    private Boolean estado;
    private Integer tiempo;
    private String Ip;

    public pc() {
    }

    public pc(Integer idPc, Boolean estado, Integer tiempo, String Ip) {
        this.idPc = idPc;
        this.estado = estado;
        this.tiempo = tiempo;
        this.Ip = Ip;
    }

    public Integer getIdPc() {
        return idPc;
    }

    public void setIdPc(Integer idPc) {
        this.idPc = idPc;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String Ip) {
        this.Ip = Ip;
    }
    
    
}
