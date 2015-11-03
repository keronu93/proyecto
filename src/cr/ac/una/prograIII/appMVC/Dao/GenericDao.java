/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Dao;


import cr.ac.una.prograIII.appMVC.Domain.Articulos;
import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import cr.ac.una.prograIII.appMVC.Domain.DetalleFactura;
import cr.ac.una.prograIII.appMVC.Domain.Factura;
import cr.ac.una.prograIII.appMVC.Domain.Proveedores;
import cr.ac.una.prograIII.appMVC.Domain.Telefono;
import cr.ac.una.prograIII.appMVC.Domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chgari
 */
public class GenericDao {

    private IBaseDao iBaseDato;

    public GenericDao() {
    }

    public void insertar(Object obj) throws SQLException {
        if (obj instanceof Cliente) {
            iBaseDato = new ClienteDao();

        }
        if (obj instanceof Telefono) {
            iBaseDato = new TelefonoDao();

        }
        if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();

        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
        if (obj instanceof Articulos) {
            iBaseDato = new ArticuloDao();
        }
        if (obj instanceof Factura) {
            iBaseDato = new FacturaDao();
        }
        if (obj instanceof DetalleFactura) {
            iBaseDato = new DetalleFacturaDao();
        }
        iBaseDato.insertar(obj);
    }

    public void modificar(Object obj) throws SQLException {
        if (obj instanceof Cliente) {
            iBaseDato = new ClienteDao();
        }
        if (obj instanceof Telefono) {
            iBaseDato = new TelefonoDao();
        }
        if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
        if (obj instanceof Articulos) {
            iBaseDato = new ArticuloDao();
        }
        if (obj instanceof Factura) {
            iBaseDato = new FacturaDao();
        }
        if (obj instanceof DetalleFactura) {
            iBaseDato = new DetalleFacturaDao();
        }
        iBaseDato.modificar(obj);
    }

    public void eliminar(Object obj) throws SQLException {
        if (obj instanceof Cliente) {
            iBaseDato = new ClienteDao();
        }
        if (obj instanceof Telefono) {
            iBaseDato = new TelefonoDao();
        }
        if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
        if (obj instanceof Articulos) {
            iBaseDato = new ArticuloDao();
        }
        if (obj instanceof Factura) {
            iBaseDato = new FacturaDao();
        }
        if (obj instanceof DetalleFactura) {
            iBaseDato = new DetalleFacturaDao();
        }

        iBaseDato.eliminar(obj);
    }

    public Object obtenerPorId(Object obj) throws SQLException {
        if (obj instanceof Cliente) {
            iBaseDato = new ClienteDao();
        }
        if (obj instanceof Telefono) {
            iBaseDato = new TelefonoDao();
        }
        if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
        if (obj instanceof Articulos) {
            iBaseDato = new ArticuloDao();
        }if (obj instanceof Factura) {
            iBaseDato = new FacturaDao();
        }
        if (obj instanceof DetalleFactura) {
            iBaseDato = new DetalleFacturaDao();
        }
        return iBaseDato.obtenerPorId(obj);
    }

    public ArrayList obtenerTodos(Object obj) throws SQLException {
        if (obj instanceof Cliente) {
            iBaseDato = new ClienteDao();
        }
        if (obj instanceof Telefono) {
            iBaseDato = new TelefonoDao();
        }
        if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
        if (obj instanceof Articulos) {
            iBaseDato = new ArticuloDao();
        }
        if (obj instanceof Factura) {
            iBaseDato = new FacturaDao();
        }
        if (obj instanceof DetalleFactura) {
            iBaseDato = new DetalleFacturaDao();
        }
        return iBaseDato.obtenerTodos();
    }

    public ArrayList obtenerConWhere(Object obj, String where) throws SQLException {
        if (obj instanceof Cliente) {
            iBaseDato = new ClienteDao();
        }
        if (obj instanceof Telefono) {
            iBaseDato = new TelefonoDao();
        }
        if (obj instanceof Proveedores) {
            iBaseDato = new ProveedorDao();
        }
        if (obj instanceof Usuario) {
            iBaseDato = new UsuarioDao();
        }
        if (obj instanceof Articulos) {
            iBaseDato = new ArticuloDao();
        }
        if (obj instanceof Factura) {
            iBaseDato = new FacturaDao();
        }
        if (obj instanceof DetalleFactura) {
            iBaseDato = new DetalleFacturaDao();
        }

        return iBaseDato.obtenerConWhere(where);
    }
}
