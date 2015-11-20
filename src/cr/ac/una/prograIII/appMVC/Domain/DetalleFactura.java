/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Domain;

/**
 * Detalle Factura
 * @author Gustavo
 */
public class DetalleFactura extends BaseDomain {
    private Integer FK_PK_idFacturacion;
    private Integer FK_PK_idArticulo;
    private Double  PrecioUnitario;
    private Integer Cantidad;
    
    /**
     *
     * @param FK_PK_idFacturacion
     * @param FK_PK_idArticulo
     * @param PrecioUnitario
     * @param Cantidad
     * @param ultUsuario
     * @param ultFecha
     */
    public DetalleFactura(Integer FK_PK_idFacturacion, Integer FK_PK_idArticulo, Double PrecioUnitario, Integer Cantidad,  String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.FK_PK_idFacturacion = FK_PK_idFacturacion;
        this.FK_PK_idArticulo = FK_PK_idArticulo;
        this.PrecioUnitario = PrecioUnitario;
        this.Cantidad = Cantidad;
        
    }

    /**
     *
     */
    public DetalleFactura() {
    }

    /**
     *
     * @return
     */
    public Integer getFK_PK_idFacturacion() {
        return FK_PK_idFacturacion;
    }

    /**
     *
     * @param FK_PK_idFacturacion
     */
    public void setFK_PK_idFacturacion(Integer FK_PK_idFacturacion) {
        this.FK_PK_idFacturacion = FK_PK_idFacturacion;
    }

    /**
     *
     * @return
     */
    public Integer getFK_PK_idArticulo() {
        return FK_PK_idArticulo;
    }

    /**
     *
     * @param FK_PK_idArticulo
     */
    public void setFK_PK_idArticulo(Integer FK_PK_idArticulo) {
        this.FK_PK_idArticulo = FK_PK_idArticulo;
    }

    /**
     *
     * @return
     */
    public Double getPrecioUnitario() {
        return PrecioUnitario;
    }

    /**
     *
     * @param PrecioUnitario
     */
    public void setPrecioUnitario(Double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    /**
     *
     * @return
     */
    public Integer getCantidad() {
        return Cantidad;
    }

    /**
     *
     * @param Cantidad
     */
    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
}
