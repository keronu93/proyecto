/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.bl;

import cr.ac.una.prograIII.appMVC.Dao.GenericDao;
import cr.ac.una.prograIII.appMVC.Domain.DetalleFactura;
import cr.ac.una.prograIII.appMVC.Domain.Factura;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class FacturaBL implements IBaseBL<Factura>{
    private GenericDao fDao;
    private DetalleFacturaBL dfDao;

    public FacturaBL() {
        this.fDao = new GenericDao();
        
    }
    
    
    @Override
    public void insertar(Factura obj) throws SQLException {
       this.fDao.insertar(obj);
       
    }

    @Override
    public void modificar(Factura obj) throws SQLException {
        this.fDao.modificar(obj);
    }

    @Override
    public void eliminar(Factura obj) throws SQLException {
        this.fDao.eliminar(obj);
    }

    @Override
    public Factura obtenerPorId(Factura obj) throws SQLException {
         return (Factura)this.fDao.obtenerPorId(obj);    
    }

    @Override
    public ArrayList<Factura> obtenerTodos() throws SQLException {
       return this.fDao.obtenerTodos(new Factura());
    }

    public ArrayList<Factura> obtenerConWhere(Factura obj, String where ) throws SQLException {
        return this.fDao.obtenerConWhere(obj, where);
    } 
}
