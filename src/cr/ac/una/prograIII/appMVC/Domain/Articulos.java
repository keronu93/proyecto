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
public class Articulos extends BaseDomain {
    
    private Integer PK_IDArticulo;
    private Integer FK_idProveedor;
    private String Nombre;
    private String Descripcion;
    private Integer CantidadExistencia;
    private double PrecioUnitario;
    private double tiempoconexion;

    public Articulos() {
    }

    public Articulos(Integer PK_IDArticulo, Integer FK_idProveedor, String Nombre, String Descripcion, Integer CantidadExistencia, double PrecioUnitario,double tiempoconexion, String ultUsuario, String ultFecha) {
        super(ultUsuario, ultFecha);
        this.PK_IDArticulo = PK_IDArticulo;
        this.FK_idProveedor = FK_idProveedor;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.CantidadExistencia = CantidadExistencia;
        this.PrecioUnitario = PrecioUnitario;
        this.tiempoconexion = tiempoconexion;
    }

    public double getTiempoconexion() {
        return tiempoconexion;
    }

    public void setTiempoconexion(double tiempoconexion) {
        this.tiempoconexion = tiempoconexion;
    }

    
    public Integer getPK_IDArticulo() {
        return PK_IDArticulo;
    }

    public void setPK_IDArticulo(Integer PK_IDArticulo) {
        this.PK_IDArticulo = PK_IDArticulo;
    }

    public Integer getFK_idProveedor() {
        return FK_idProveedor;
    }

    public void setFK_idProveedor(Integer FK_idProveedor) {
        this.FK_idProveedor = FK_idProveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getCantidadExistencia() {
        return CantidadExistencia;
    }

    public void setCantidadExistencia(Integer CantidadExistencia) {
        this.CantidadExistencia = CantidadExistencia;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }    
    
}
