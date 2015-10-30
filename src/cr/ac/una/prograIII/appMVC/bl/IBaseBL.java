/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIII.appMVC.bl;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chgari
 */
public interface IBaseBL<T> {
    public void insertar(T obj) throws SQLException;
    public void modificar(T obj) throws SQLException;
    public void eliminar(T obj) throws SQLException;
    public T obtenerPorId(T obj) throws SQLException;
    public ArrayList<T> obtenerTodos() throws SQLException;
    //public ArrayList<T> obtenerConWhere() throws SQLException;
}
