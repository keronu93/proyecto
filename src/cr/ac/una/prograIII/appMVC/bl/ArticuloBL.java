/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.bl;

import cr.ac.una.prograIII.appMVC.Dao.GenericDao;
import cr.ac.una.prograIII.appMVC.Domain.Articulos;
import cr.ac.una.prograIII.appMVC.Domain.Proveedores;
import cr.ac.una.prograIII.appMVC.bl.IBaseBL;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author kevin
 */
public class ArticuloBL implements IBaseBL<Articulos> {
    
    private GenericDao aDao;
    
     public ArticuloBL(){
        this.aDao = new GenericDao();
    }

    @Override
    public void insertar(Articulos obj) throws SQLException {
        this.aDao.insertar(obj);
    }

    @Override
    public void modificar(Articulos obj) throws SQLException {
        this.aDao.modificar(obj);
    }

    @Override
    public void eliminar(Articulos obj) throws SQLException {
        this.aDao.eliminar(obj);
    }

    @Override
    public Articulos obtenerPorId(Articulos obj) throws SQLException {
        return (Articulos)this.aDao.obtenerPorId(obj);
    }

    @Override
    public ArrayList<Articulos> obtenerTodos() throws SQLException {
        return this.aDao.obtenerTodos(new Articulos());
    }

  
    public ArrayList<Proveedores> obtenerConWhere(Articulos obj, String where ) throws SQLException {
        return this.aDao.obtenerConWhere(obj, where);
    } 

    public void obtenerPorId(int idArticulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
