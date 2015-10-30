/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.bl;


import cr.ac.una.prograIII.appMVC.Dao.GenericDao;
import cr.ac.una.prograIII.appMVC.Domain.Telefono;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class TelefonoBL implements IBaseBL<Telefono>{
    private GenericDao tDao;

    public TelefonoBL() {
        this.tDao = new GenericDao();
    }
    
    
    
    @Override
    public void insertar(Telefono obj) throws SQLException {
         this.tDao.insertar(obj);
    }

    @Override
    public void modificar(Telefono obj) throws SQLException {
        this.tDao.modificar(obj);
    }

    @Override
    public void eliminar(Telefono obj) throws SQLException {
         this.tDao.eliminar(obj);
    }

    @Override
    public Telefono obtenerPorId(Telefono obj) throws SQLException {
        return (Telefono)this.tDao.obtenerPorId(obj);    
    }

    @Override
    public ArrayList<Telefono> obtenerTodos() throws SQLException {
        return this.tDao.obtenerTodos(new Telefono());
    }
     public ArrayList<Telefono> obtenerConWhere(Telefono obj, String where ) throws SQLException {
        return this.tDao.obtenerConWhere(obj, where);
    } 
    
    
}
