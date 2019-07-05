/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.dao;

import static br.com.exceptionweb.portalservice.dao.Connection.concorrencia;
import static br.com.exceptionweb.portalservice.dao.Connection.connection;
import static br.com.exceptionweb.portalservice.dao.Connection.tipo;
import br.com.exceptionweb.portalservice.model.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author johnny
 */
public class PessoaDAO {
    
    public static ArrayList<Pessoa> getAll() throws SQLException {
        ArrayList<Pessoa> cadastro = new ArrayList<Pessoa>();
        String query = "select * from pessoa order by nome";
        Statement stdados = connection.createStatement(Connection.tipo, Connection.concorrencia);
        ResultSet rsdados = stdados.executeQuery(query);
        while (rsdados.next()) {
            Long id = rsdados.getLong("id");
            String nome = rsdados.getString("nome");
            String cpf = rsdados.getString("cpf");
            Pessoa p = new Pessoa();
            p.setId(id);
            p.setNome(nome);
            p.setCpf(cpf);

            cadastro.add(p);
        }
        rsdados.close();
        return cadastro;
    }
    
    
    public static Pessoa getPessoaFindId(Long id) throws SQLException {
        Pessoa p = new Pessoa();
        String query = "select * from pessoa where id = "+id;
        Statement stdados = Connection.connection.createStatement(Connection.tipo, Connection.concorrencia);
        ResultSet rsdados = stdados.executeQuery(query);
        while (rsdados.next()) {
            String nome = rsdados.getString("nome");
            String cpf = rsdados.getString("cpf");
            p.setId(id);
            p.setNome(nome);
            p.setCpf(cpf);
        }
        rsdados.close();
        return p;
    }
    
    
    public static Pessoa getPessoaFindId(String cpf) throws SQLException {
        Pessoa p = new Pessoa();
        String query = "select * from pessoa where cpf = "+cpf;
        Statement stdados = Connection.connection.createStatement(Connection.tipo, Connection.concorrencia);
        ResultSet rsdados = stdados.executeQuery(query);
        while (rsdados.next()) {
            String nome = rsdados.getString("nome");
            Long id = rsdados.getLong("id");
            p.setId(id);
            p.setNome(nome);
            p.setCpf(cpf);
        }
        rsdados.close();
        return p;
    }
    
}
