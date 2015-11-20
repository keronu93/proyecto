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
 * @author Gustavo
 */
public class GenericDao {

    private IBaseDao iBaseDato;

    /**
     *
     */
    public GenericDao() {
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
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

    /**
     *
     * @param obj
     * @throws SQLException
     */
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

    /**
     *
     * @param obj
     * @throws SQLException
     */
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

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
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

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
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

    /**
     *
     * @param obj
     * @param where
     * @return
     * @throws SQLException
     */
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
