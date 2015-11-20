/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Dao;

import cr.ac.una.prograIII.appMVC.Conexion.MySQLConexion;
import cr.ac.una.prograIII.appMVC.Domain.Telefono;
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
public class TelefonoDao implements IBaseDao<Telefono>{
    
    private final MySQLConexion conexion;

    /**
     *
     */
    public TelefonoDao() {
        conexion = new MySQLConexion();
    }
    
    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Telefono obj) throws SQLException {
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("insert into Telefono (FK_idCliente,TipoTelefono,Telefono,"
                                             + "ultUsuario,ultFecha) values "
                                             + "(?,?,?,?,curdate())");
        
        cs.setInt(1, obj.getFK_idCliente());
        cs.setString(2, obj.getTipoTelfono());
         cs.setInt(3, obj.getNumeroTelefono());
        cs.setString(4, obj.getUltUsuario()); 
        cs.executeUpdate();
        con.close();
    }
    
    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void modificar(Telefono obj) throws SQLException {
       Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("update Telefono set TipoTelefono = ?, "
                                            + "Telefono = ?, "
                                            +" FK_idCliente = ?,"
                                            + "ultUsuario = ?,"
                                            + "ultFecha = curdate()"
                                            +"where PK_idTelefono = ?");
        cs.setString(1, obj.getTipoTelfono());
        cs.setInt(2, obj.getNumeroTelefono());
         cs.setInt(3, obj.getFK_idCliente());
        cs.setString(4, obj.getUltUsuario());
        cs.setInt(5, obj.getPk_idTelefono());
        cs.executeUpdate();
        con.close();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Telefono obj) throws SQLException {
         Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from Telefono where PK_idTelefono = ?");
        cs.setInt(1, obj.getPk_idTelefono());
        
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
    public Telefono obtenerPorId(Telefono obj) throws SQLException {
       Telefono t = null;
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("select * from Telefono where PK_idTelefono = ? " );
        cs.setInt(1, obj.getPk_idTelefono());
        ResultSet result = cs.executeQuery();
        while(result.next()){
            t = new Telefono();
            t.setPk_idTelefono(result.getInt("PK_idTelefono"));
            t.setFK_idCliente(result.getInt("FK_idCliente"));
            t.setNumeroTelefono(result.getInt("Telefono"));
            t.setTipoTelfono(result.getString("TipoTelefono"));
            t.setUltUsuario(result.getString("UltUsuario"));
    }
         con.close();
         return t;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Telefono> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Telefono> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Telefono ");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Telefono t = new Telefono();
            t.setPk_idTelefono(result.getInt("PK_idTelefono"));
            t.setFK_idCliente(result.getInt("FK_idCliente"));
            t.setNumeroTelefono(result.getInt("Telefono"));
            t.setTipoTelfono(result.getString("TipoTelefono"));
            t.setUltUsuario(result.getString("UltUsuario"));
            
            l.add(t);
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
    public ArrayList<Telefono> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Telefono> l = new ArrayList();
        
        PreparedStatement ps = con.prepareStatement("select * from Telefono "+where);
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Telefono t = new Telefono();
            t.setPk_idTelefono(result.getInt("PK_idTelefono"));
            t.setFK_idCliente(result.getInt("FK_idCliente"));
            t.setNumeroTelefono(result.getInt("Telefono"));
            t.setTipoTelfono(result.getString("TipoTelefono"));
            t.setUltUsuario(result.getString("UltUsuario"));
            
            l.add(t);
        }
        con.close();
        return l;
    }
    
}
