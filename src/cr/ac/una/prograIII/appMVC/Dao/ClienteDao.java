/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Dao;

import cr.ac.una.prograIII.appMVC.Conexion.MySQLConexion;
import cr.ac.una.prograIII.appMVC.Domain.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ClienteDao implements IBaseDao<Cliente>{
    
    private final MySQLConexion conexion;

    public ClienteDao() {
        conexion = new MySQLConexion();
    }
    

    @Override
    public void insertar(Cliente obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("insert into Cliente (nombre,apellidos,"
                                             + "fechaNacimiento,direccion,"
                                             + "observaciones,ultUsuario,"
                                             + "ultFecha) values "
                                             + "(?,?,?,?,?,?,curdate())");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getApellidos());
        cs.setString(3, obj.getFechaNacimiento());
        cs.setString(4, obj.getDireccion());
        cs.setString(5, obj.getObservaciones());
        cs.setString(6, obj.getUltUsuario()); 
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(Cliente obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update Cliente set nombre = ?, "
                                            + "apellidos = ?, fechaNacimiento = ?, "
                                            + "direccion = ?,observaciones = ?,"
                                            + "ultUsuario = ?,"
                                            + "ultFecha = curdate() "
                                            + "where PK_idCliente = ?");
        cs.setString(1, obj.getNombre());
        cs.setString(2, obj.getApellidos());
        cs.setString(3, obj.getFechaNacimiento());
        cs.setString(4, obj.getDireccion());
        cs.setString(5, obj.getObservaciones());
        cs.setString(6, obj.getUltUsuario());
        cs.setInt(7, obj.getPK_idCliente());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(Cliente obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from Cliente  where PK_idCliente = ?");
        cs.setInt(1, obj.getPK_idCliente());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public Cliente obtenerPorId(Cliente obj) throws SQLException {
        Cliente c = null;
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("select * from Cliente where PK_idCliente = ? " );
        cs.setInt(1, obj.getPK_idCliente());
        ResultSet result = cs.executeQuery();
        while(result.next()){
            c = new Cliente();
            c.setPK_idCliente(result.getInt("PK_idCliente"));
            c.setNombre(result.getString("nombre"));
            c.setApellidos(result.getString("apellidos"));
            c.setFechaNacimiento(result.getString("fechaNacimiento"));
            c.setDireccion(result.getString("direccion"));
            c.setObservaciones(result.getString("Observaciones"));
            c.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return c;
    }

    @Override
    public ArrayList<Cliente> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Cliente> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Cliente ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Cliente c = new Cliente();
            c.setPK_idCliente(result.getInt("PK_idCliente"));
            c.setNombre(result.getString("nombre"));
            c.setApellidos(result.getString("apellidos"));
            c.setFechaNacimiento(result.getString("fechaNacimiento"));
            c.setDireccion(result.getString("direccion"));
            c.setObservaciones(result.getString("Observaciones"));
            c.setUltUsuario(result.getString("UltUsuario"));
            l.add(c);
        }
        con.close();
        return l;
    }

    @Override
    public ArrayList<Cliente> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Cliente> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Cliente "+where);
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Cliente c = new Cliente();
            c.setPK_idCliente(result.getInt("PK_idCliente"));
            c.setNombre(result.getString("nombre"));
            c.setApellidos(result.getString("apellidos"));
            c.setFechaNacimiento(result.getString("fechaNacimiento"));
            c.setDireccion(result.getString("direccion"));
            c.setObservaciones(result.getString("Observaciones"));
            c.setUltUsuario(result.getString("UltUsuario"));
            l.add(c);
        }
        con.close();
        return l;
        
    }
    
}
