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
public class DetalleFactura extends BaseDomain {
    private Integer FK_PK_idFacturacion;
    private Integer FK_PK_idArticulo;
    private Double  PrecioUnitario;
    private Integer Cantidad;
    private String nombre;

    public DetalleFactura(Integer FK_PK_idFacturacion, Integer FK_PK_idArticulo, Double PrecioUnitario, Integer Cantidad, String nombre, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.FK_PK_idFacturacion = FK_PK_idFacturacion;
        this.FK_PK_idArticulo = FK_PK_idArticulo;
        this.PrecioUnitario = PrecioUnitario;
        this.Cantidad = Cantidad;
        this.nombre = nombre;
    }

    
    

   
    public DetalleFactura() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getFK_PK_idFacturacion() {
        return FK_PK_idFacturacion;
    }

    public void setFK_PK_idFacturacion(Integer FK_PK_idFacturacion) {
        this.FK_PK_idFacturacion = FK_PK_idFacturacion;
    }

    public Integer getFK_PK_idArticulo() {
        return FK_PK_idArticulo;
    }

    public void setFK_PK_idArticulo(Integer FK_PK_idArticulo) {
        this.FK_PK_idArticulo = FK_PK_idArticulo;
    }

    public Double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(Double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
}
