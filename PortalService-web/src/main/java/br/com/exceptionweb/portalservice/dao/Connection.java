/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author johnny
 */
public class Connection {
    public static java.sql.Connection connection = null;
    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/portalservidor";
    public static final String login = "postgres";
    public static final String passwd = "1234";
    public static final int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
    public static final int concorrencia = ResultSet.CONCUR_UPDATABLE;

    static {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, passwd);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver naro encontrado.");
        } catch (SQLException e) {
            System.err.println("Problemas na conexao com o BD.");
        }
    }
    
}
