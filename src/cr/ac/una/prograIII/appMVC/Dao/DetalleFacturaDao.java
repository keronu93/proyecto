/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Dao;

import cr.ac.una.prograIII.appMVC.Conexion.MySQLConexion;
import cr.ac.una.prograIII.appMVC.Domain.DetalleFactura;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class DetalleFacturaDao implements IBaseDao<DetalleFactura> {

    private final MySQLConexion conexion;

    public DetalleFacturaDao() {
         conexion = new MySQLConexion();
    }

    @Override
    public void insertar(DetalleFactura obj) throws SQLException {
       Connection con = conexion.getConexion();
       CallableStatement cs = con.prepareCall("insert into DetalleFactura(FK_PK_idArticulo,"
                                             +"precioUnitario,Cantidad"
                                             +",ultUsuario,ultFecha) values "
                                             + "(?,?,?,?,curdate())");
        cs.setInt(1, obj.getFK_PK_idArticulo());
        cs.setDouble(2, obj.getPrecioUnitario());
        cs.setInt(3, obj.getCantidad());
        cs.setString(4, obj.getUltUsuario());     
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(DetalleFactura obj) throws SQLException {
        Connection con = conexion.getConexion();
       CallableStatement cs = con.prepareCall("update DetalleFactura set FK_PK_idArticulo= ?,"
                                             +"precioUnitario=?,Cantidad=?"
                                             +",ultUsuario=?,ultFecha=curdate()) values "
                                             + "where FK_PK_idFacturacion=?");
        cs.setInt(1, obj.getFK_PK_idArticulo());
        cs.setDouble(2, obj.getPrecioUnitario());
        cs.setInt(3, obj.getCantidad());
        cs.setString(4, obj.getUltUsuario());   
        cs.setInt(7,obj.getFK_PK_idFacturacion());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(DetalleFactura obj) throws SQLException {
       Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from DetalleFacturacion where FK_PK_idFacturacion = ?");
        cs.setInt(1, obj.getFK_PK_idFacturacion());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public DetalleFactura obtenerPorId(DetalleFactura obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleFactura> obtenerTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleFactura> obtenerConWhere(String where) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
  
}
