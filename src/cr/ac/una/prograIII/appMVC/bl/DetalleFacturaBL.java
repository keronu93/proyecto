/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.bl;

import cr.ac.una.prograIII.appMVC.Dao.GenericDao;
import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import cr.ac.una.prograIII.appMVC.Domain.DetalleFactura;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class DetalleFacturaBL implements IBaseBL<DetalleFactura> {
     private GenericDao dfDao;

    /**
     *
     */
    public DetalleFacturaBL() {
        this.dfDao = new GenericDao();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(DetalleFactura obj) throws SQLException {
         this.dfDao.insertar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(DetalleFactura obj) throws SQLException {
        this.dfDao.modificar(obj);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(DetalleFactura obj) throws SQLException {
        this.dfDao.eliminar(obj);
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public DetalleFactura obtenerPorId(DetalleFactura obj) throws SQLException {
         return (DetalleFactura)this.dfDao.obtenerPorId(obj);    
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<DetalleFactura> obtenerTodos() throws SQLException {
         return this.dfDao.obtenerTodos(new DetalleFactura());
    }

    /**
     *
     * @param obj
     * @param where
     * @return
     * @throws SQLException
     */
    public ArrayList<DetalleFactura> obtenerConWhere(DetalleFactura obj, String where ) throws SQLException {
        return this.dfDao.obtenerConWhere(obj, where);
    } 
 
    
}
