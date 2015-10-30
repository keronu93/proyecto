/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.bl;


import cr.ac.una.prograIII.appMVC.Dao.GenericDao;
import cr.ac.una.prograIII.appMVC.Domain.Proveedores;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class ProveedorBL implements IBaseBL<Proveedores> {
    
    private GenericDao pDao;
    
     public ProveedorBL(){
        this.pDao = new GenericDao();
    }

    @Override
    public void insertar(Proveedores obj) throws SQLException {
        pDao.insertar(obj);
    }

    @Override
    public void modificar(Proveedores obj) throws SQLException {
        pDao.modificar(obj);
    }

    @Override
    public void eliminar(Proveedores obj) throws SQLException {
        pDao.eliminar(obj);
    }

    @Override
    public Proveedores obtenerPorId(Proveedores obj) throws SQLException {
       return (Proveedores)this.pDao.obtenerPorId(obj);
    }

    @Override
    public ArrayList<Proveedores> obtenerTodos() throws SQLException {
       return this.pDao.obtenerTodos(new Proveedores());
    }

 
    public ArrayList<Proveedores> obtenerConWhere(Proveedores obj, String where ) throws SQLException {
        return this.pDao.obtenerConWhere(obj, where);
    } 
    
}

