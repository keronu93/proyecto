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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        CallableStatement cs = con.prepareCall("insert into Detalle(FK_PK_idArticulo,"
                                               + "precioUnitario,Cantidad"
                                               + ",ultUsuario,ultFecha) values "
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
        CallableStatement cs = con.prepareCall("update Detalle set FK_PK_idFacturacion= ?,"
                                                + "precioUnitario=?,Cantidad=?"
                                                + ",ultUsuario=?,ultFecha=curdate()) values "
                                                + "where  FK_PK_idArticulo=?");
        cs.setInt(1, obj.getFK_PK_idFacturacion());
        cs.setDouble(2, obj.getPrecioUnitario());
        cs.setInt(3, obj.getCantidad());
        cs.setString(5, obj.getUltUsuario());
        cs.setInt(6, obj.getFK_PK_idArticulo());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public void eliminar(DetalleFactura obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("delete from Detalle where FK_PK_idFacturacion = ?");
        cs.setInt(1, obj.getFK_PK_idFacturacion());
        cs.executeUpdate();
        con.close();
    }

    @Override
    public DetalleFactura obtenerPorId(DetalleFactura obj) throws SQLException {
        DetalleFactura df = null;
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("select * from Detalle where FK_PK_idFacturacion = ? ");
        cs.setInt(1, obj.getFK_PK_idFacturacion());

        ResultSet result = cs.executeQuery();
        while (result.next()) {
            df = new DetalleFactura();
            df.setFK_PK_idFacturacion(result.getInt("FK_PK_idFacturacion"));
            df.setFK_PK_idArticulo(result.getInt("FK_PK_idArticulo"));
            df.setPrecioUnitario(result.getDouble("PrecioUnitario"));
            df.setCantidad(result.getInt("Cantidad"));
            df.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return df;
    }

    @Override
    public ArrayList<DetalleFactura> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<DetalleFactura> l = new ArrayList();
        PreparedStatement ps = con.prepareStatement("select * from Detalle ");
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            DetalleFactura df = new DetalleFactura();
            df.setFK_PK_idFacturacion(result.getInt("FK_PK_idFacturacion"));
            df.setFK_PK_idArticulo(result.getInt("FK_PK_idArticulo"));
            df.setPrecioUnitario(result.getDouble("PrecioUnitario"));
            df.setCantidad(result.getInt("Cantidad"));
            df.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return l;

    }

    @Override
    public ArrayList<DetalleFactura> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<DetalleFactura> l = new ArrayList();
        PreparedStatement ps = con.prepareStatement("select * from Detalle " + where);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            DetalleFactura df = new DetalleFactura();
            df.setFK_PK_idFacturacion(result.getInt("FK_PK_idFacturacion"));
            df.setFK_PK_idArticulo(result.getInt("FK_PK_idArticulo"));
            df.setPrecioUnitario(result.getDouble("PrecioUnitario"));
            df.setCantidad(result.getInt("Cantidad"));
            df.setUltUsuario(result.getString("UltUsuario"));
        }
        con.close();
        return l;
    }

}
