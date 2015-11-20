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

    /**
     *
     */
    public TelefonoBL() {
        this.tDao = new GenericDao();
    }
    
    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Telefono obj) throws SQLException {
         this.tDao.insertar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Telefono obj) throws SQLException {
        this.tDao.modificar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Telefono obj) throws SQLException {
         this.tDao.eliminar(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Telefono obtenerPorId(Telefono obj) throws SQLException {
        return (Telefono)this.tDao.obtenerPorId(obj);    
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Telefono> obtenerTodos() throws SQLException {
        return this.tDao.obtenerTodos(new Telefono());
    }

    /**
     *
     * @param obj
     * @param where
     * @return
     * @throws SQLException
     */
    public ArrayList<Telefono> obtenerConWhere(Telefono obj, String where ) throws SQLException {
        return this.tDao.obtenerConWhere(obj, where);
    } 
    
    
}
