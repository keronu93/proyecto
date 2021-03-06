/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Dao;

import cr.ac.una.prograIII.appMVC.Conexion.MySQLConexion;
import cr.ac.una.prograIII.appMVC.Domain.Articulos;
import cr.ac.una.prograIII.appMVC.Domain.Proveedores;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class ProveedorDao implements IBaseDao<Proveedores> {

    private final MySQLConexion conexion;
     
    /**
     *
     */
    public ProveedorDao() {
        conexion = new MySQLConexion();
    }
      
    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Proveedores obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into proveedores(Nombre,Direccion,CorreoElectronico,"
                                             + "Telefono,ultUsuario,ultFecha) values "
                                             + "(?,?,?,?,?,curdate())");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getDireccion());
        cs.setString(3, obj.getCorreoElectronico());
        cs.setString(4, obj.getTelefono());
        cs.setString(5, obj.getUltUsuario());
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Proveedores obj) throws SQLException {
       Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update proveedores set Nombre= ?,"
                                            + "Direccion=?, correoElectronico=?,"
                                            + "Telefono=?, ultUsuario=?,"
                                            + "ultFecha = curdate() "
                                            + "where PK_IDProvedor=? ");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getDireccion());
        cs.setString(3, obj.getCorreoElectronico());
        cs.setString(4, obj.getTelefono());
        cs.setString(5, obj.getUltUsuario());
        cs.setInt(6, obj.getPK_IDProvedor());
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Proveedores obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from proveedores where PK_IDProvedor = ?");
        cs.setInt(1, obj.getPK_IDProvedor());
        
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Proveedores obtenerPorId(Proveedores obj) throws SQLException {
        Proveedores p = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("select * from proveedores where PK_IDProvedor = ? " );
        cs.setInt(1, obj.getPK_IDProvedor());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            p = new Proveedores();
            p.setPK_IDProvedor(result.getInt("PK_IDProvedor"));
            p.setNombre(result.getString("Nombre"));
            p.setDireccion(result.getString("Direccion"));
            p.setCorreoElectronico(result.getString("correoElectronico"));
            p.setTelefono(result.getString("Telefono"));
            p.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return p;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Proveedores> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Proveedores> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from proveedores ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Proveedores p = new Proveedores();
            p.setPK_IDProvedor(result.getInt("PK_IDProvedor"));
            p.setNombre(result.getString("Nombre"));
            p.setDireccion(result.getString("Direccion"));
            p.setCorreoElectronico(result.getString("correoElectronico"));
            p.setTelefono(result.getString("Telefono"));
            p.setUltUsuario(result.getString("UltUsuario"));
            l.add(p);
        }
        con.close();
        return l;
    }

    /**
     *
     * @param where
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Proveedores> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Proveedores> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from proveedores "+where );
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Proveedores p = new Proveedores();
            p.setPK_IDProvedor(result.getInt("PK_IDProvedor"));
            p.setNombre(result.getString("Nombre"));
            p.setDireccion(result.getString("Direccion"));
            p.setCorreoElectronico(result.getString("correoElectronico"));
            p.setTelefono(result.getString("Telefono"));
            p.setUltUsuario(result.getString("UltUsuario"));
            l.add(p);
        }
        con.close();
        return l;
    }
    
}

