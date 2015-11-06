/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.Dao;

import cr.ac.una.prograIII.appMVC.Conexion.MySQLConexion;
import cr.ac.una.prograIII.appMVC.Domain.Factura;
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
public class FacturaDao implements IBaseDao<Factura>{
    
    private final MySQLConexion conexion;

    public FacturaDao() {
        conexion = new MySQLConexion();
    }

    @Override
    public void insertar(Factura obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into Facturacion(FK_idCliente ,ultUsuario,ultFecha) values "
                                             + "(?,?,curdate())");
        cs.setInt(1, obj.getFk_idCliente());
        cs.setString(2, obj.getUltUsuario());     
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void modificar(Factura obj) throws SQLException {
        Connection con = conexion.getConexion();
         CallableStatement cs = con.prepareCall("update Facturacion set FK_PK_idFacturacion= ?," 
                                                +"Fk_idCliente=?,"
                                                +"ultUsuario=?,"
                                                +"ultFecha = curdate()"
                                                +"where Pk_idfacturacion=? ");
        cs.setInt(1, obj.getFk_idCliente());
        cs.setString(2, obj.getUltUsuario());  
        cs.setInt(3,obj.getPk_idfacturacion());
        cs.executeUpdate();
        con.close();
       
    }

    @Override
    public void eliminar(Factura obj) throws SQLException {
       Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("delete from Facturacion where Pk_idfacturacion = ?");
        cs.setInt(1, obj.getPk_idfacturacion());
        
        cs.executeUpdate();
        con.close();
    }

    @Override
    public Factura obtenerPorId(Factura obj) throws SQLException {
        Factura f = null;
        Connection con = conexion.getConexion();
        
        CallableStatement cs = con.prepareCall("select * from Facturacion where Pk_idfacturacion = ? " );
        cs.setInt(1, obj.getPk_idfacturacion());
        
        ResultSet result = cs.executeQuery();
        while(result.next()){
            f = new Factura();
            f.setPk_idfacturacion(result.getInt("Pk_idfacturacion"));
            f.setFk_idCliente(result.getInt("Fk_idCliente"));
            f.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return f;
    }

    @Override
    public ArrayList<Factura> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Factura> l = new ArrayList();
        PreparedStatement ps = con.prepareStatement("select * from Facturacion ");
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Factura f = new Factura();
            f.setPk_idfacturacion(result.getInt("Pk_idfacturacion"));
            f.setFk_idCliente(result.getInt("Fk_idCliente"));
            f.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return l;

    }

    @Override
    public ArrayList<Factura> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Factura> l = new ArrayList();
        PreparedStatement ps = con.prepareStatement("select * from Facturacion "+where);
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Factura f = new Factura();
            f.setPk_idfacturacion(result.getInt("Pk_idfacturacion"));
            f.setFk_idCliente(result.getInt("Fk_idCliente"));
            f.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return l;
    }
    
    
   
}
