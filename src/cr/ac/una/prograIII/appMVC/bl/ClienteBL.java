/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.bl;

import cr.ac.una.prograIII.appMVC.Dao.GenericDao;
import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Gustavo
 */
public class ClienteBL implements IBaseBL<Cliente>{
    private GenericDao cDao;

    /**
     *
     */
    public ClienteBL() {
        this.cDao = new GenericDao();
    }
    
    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Cliente obj) throws SQLException {
         this.cDao.insertar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Cliente obj) throws SQLException {
         this.cDao.modificar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Cliente obj) throws SQLException {
         this.cDao.eliminar(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Cliente obtenerPorId(Cliente obj) throws SQLException {
        return (Cliente)this.cDao.obtenerPorId(obj);    
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Cliente> obtenerTodos() throws SQLException {
        return this.cDao.obtenerTodos(new Cliente());
    }

    /**
     *
     * @param obj
     * @param where
     * @return
     * @throws SQLException
     */
    public ArrayList<Cliente> obtenerConWhere(Cliente obj, String where ) throws SQLException {
        return this.cDao.obtenerConWhere(obj, where);
    } 
    
}
