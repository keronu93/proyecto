/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.bl;

import cr.ac.una.prograIII.appMVC.Dao.GenericDao;
import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import cr.ac.una.prograIII.appMVC.Domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class UsuarioBL implements IBaseBL<Usuario> {
    
    private GenericDao uDao;

    public UsuarioBL() {
        this.uDao = new GenericDao();
    }

    
    @Override
    public void insertar(Usuario obj) throws SQLException {
        this.uDao.insertar(obj);
    }

    @Override
    public void modificar(Usuario obj) throws SQLException {
        this.uDao.modificar(obj);
    }

    @Override
    public void eliminar(Usuario obj) throws SQLException {
        this.uDao.eliminar(obj);
    }

    @Override
    public Usuario obtenerPorId(Usuario obj) throws SQLException {
       return (Usuario)this.uDao.obtenerPorId(obj);    
    }

    @Override
    public ArrayList<Usuario> obtenerTodos() throws SQLException {
        return this.uDao.obtenerTodos(new Usuario());
    }
    public ArrayList<Usuario> obtenerConWhere(Usuario obj, String where ) throws SQLException {
        return this.uDao.obtenerConWhere(obj, where);
    } 
    
}
