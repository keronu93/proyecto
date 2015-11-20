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
public class FacturaDao implements IBaseDao<Factura> {

    private final MySQLConexion conexion;

    /**
     *
     */
    public FacturaDao() {
        conexion = new MySQLConexion();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insertar(Factura obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("insert into Facturacion(FK_idCliente, Fecha, total ,ult_Usuario,ult_Fecha) values "
                                                + "(?,?,?,?,curdate())");
        cs.setInt(1, obj.getFk_idCliente());
        cs.setString(2, obj.getFecha());
        cs.setDouble(3, obj.getTotal());
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
    public void modificar(Factura obj) throws SQLException {
        Connection con = conexion.getConexion();
        CallableStatement cs = con.prepareCall("update Facturacion set PK_idFacturacion= ?,"
                                               + "Fk_idCliente=?,"
                                               + "Fecha=?"
                                               + "ult_Usuario=?,"
                                               + "ult_Fecha = curdate()"
                                                + "where Pk_idfacturacion=? ");
        cs.setInt(1, obj.getFk_idCliente());
        cs.setString(2, obj.getFecha());
        cs.setString(3, obj.getUltUsuario());
        cs.setInt(4, obj.getPk_idfacturacion());
        cs.executeUpdate();
        con.close();

    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void eliminar(Factura obj) throws SQLException {
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("delete from Facturacion where Pk_idfacturacion = ?");
        cs.setInt(1, obj.getPk_idfacturacion());

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
    public Factura obtenerPorId(Factura obj) throws SQLException {
        Factura f = null;
        Connection con = conexion.getConexion();

        CallableStatement cs = con.prepareCall("select * from Facturacion where Pk_idfacturacion = ? ");
        cs.setInt(1, obj.getPk_idfacturacion());

        ResultSet result = cs.executeQuery();
        while (result.next()) {
            f = new Factura();
            f.setPk_idfacturacion(result.getInt("Pk_idfacturacion"));
            f.setFk_idCliente(result.getInt("Fk_idCliente"));
            f.setFecha(result.getString("Fecha"));
            f.setTotal(result.getDouble("total"));
            f.setUltUsuario(result.getString("ult_Usuario"));
        }
        con.close();
        return f;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Factura> obtenerTodos() throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Factura> l = new ArrayList();
        PreparedStatement ps = con.prepareStatement("select * from Facturacion ");
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Factura f = new Factura();
            f.setPk_idfacturacion(result.getInt("Pk_idfacturacion"));
            f.setFk_idCliente(result.getInt("Fk_idCliente"));
            f.setFecha(result.getString("Fecha"));
            f.setTotal(result.getDouble("total"));
            f.setUltUsuario(result.getString("ult_Usuario"));
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
    public ArrayList<Factura> obtenerConWhere(String where) throws SQLException {
        Connection con = conexion.getConexion();
        ArrayList<Factura> l = new ArrayList();
        PreparedStatement ps = con.prepareStatement("select * from Facturacion " + where);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Factura f = new Factura();
            f.setPk_idfacturacion(result.getInt("Pk_idfacturacion"));
            f.setFk_idCliente(result.getInt("Fk_idCliente"));
            f.setFecha(result.getString("Fecha"));
            f.setTotal(result.getDouble("total"));
            f.setUltUsuario(result.getString("ult_Usuario"));
        }
        con.close();
        return l;
    }

}
