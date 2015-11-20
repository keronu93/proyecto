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
public class Factura extends BaseDomain {
    private Integer Pk_idfacturacion;
    private Integer Fk_idCliente;
    private String Fecha;
    private double Total;

    /**
     *
     * @param Pk_idfacturacion
     * @param Fk_idCliente
     * @param Fecha
     * @param ultUsuario
     * @param ultFecha
     * @param Total
     */
    public Factura(Integer Pk_idfacturacion, Integer Fk_idCliente, String Fecha, String ultUsuario, String ultFecha, Double Total) {
        super(ultUsuario, ultFecha);
        this.Pk_idfacturacion = Pk_idfacturacion;
        this.Fk_idCliente = Fk_idCliente;
        this.Fecha = Fecha;
        this.Total = Total;
    }

    /**
     *
     */
    public Factura() {
    }

    /**
     *
     * @return
     */
    public double getTotal() {
        return Total;
    }

    /**
     *
     * @param Total
     */
    public void setTotal(double Total) {
        this.Total = Total;
    }

    /**
     *
     * @return
     */
    public Integer getPk_idfacturacion() {
        return Pk_idfacturacion;
    }
    
    /**
     *
     * @param Pk_idfacturacion
     */
    public void setPk_idfacturacion(Integer Pk_idfacturacion) {
        this.Pk_idfacturacion = Pk_idfacturacion;
    }

    /**
     *
     * @return
     */
    public Integer getFk_idCliente() {
        return Fk_idCliente;
    }

    /**
     *
     * @param Fk_idCliente
     */
    public void setFk_idCliente(Integer Fk_idCliente) {
        this.Fk_idCliente = Fk_idCliente;
    }

    /**
     *
     * @return
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     *
     * @param Fecha
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
    
}
