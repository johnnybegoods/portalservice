/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.dao;

import br.com.exceptionweb.portalservice.model.Autorizacao;
import br.com.exceptionweb.portalservice.model.Competencia;
import br.com.exceptionweb.portalservice.model.Horas;
import br.com.exceptionweb.portalservice.model.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Collections.list;

/**
 *
 * @author johnny
 */
public class HistoricoDAO {
    
    public static ArrayList<Competencia> getCompetenciasFindResponsavel(Long id) throws SQLException {
        ArrayList<Competencia> list = new ArrayList<Competencia>();

        String query = "select * from competencia where id_responsavel = " + id + " order by situacao, competencia desc";
        Statement stdados = Connection.connection.createStatement(Connection.tipo, Connection.concorrencia);
        ResultSet rsdados = stdados.executeQuery(query);
        while (rsdados.next()) {
            Calendar c = Calendar.getInstance();
            Long idComp = rsdados.getLong("id_comp");
            c.setTime(rsdados.getDate("competencia"));
            Pessoa p = PessoaDAO.getPessoaFindId(rsdados.getLong("id_responsavel"));
            String situacao = rsdados.getString("situacao");
            Competencia comp = new Competencia(idComp, c, p, situacao);
            list.add(comp);
        }
        rsdados.close();
        return list;
    }
    
    public static Competencia getCompetenciaFindId(Long id) throws SQLException {
        Competencia comp = null;

        String query = "select * from competencia where id_comp = " + id;
        Statement stdados = Connection.connection.createStatement(Connection.tipo, Connection.concorrencia);
        ResultSet rsdados = stdados.executeQuery(query);
        while (rsdados.next()) {
            Calendar c = Calendar.getInstance();
            c.setTime(rsdados.getDate("competencia"));
            Pessoa p = PessoaDAO.getPessoaFindId(rsdados.getLong("id_responsavel"));
            String situacao = rsdados.getString("situacao");
            comp = new Competencia(id, c, p, situacao);
        }
        rsdados.close();
        return comp;
    }
    
    public static ArrayList<Competencia> getCompetenciaAberta(Long idResp) throws SQLException {
        ArrayList<Competencia> list = new ArrayList<Competencia>();

        String query = "select * from competencia where id_responsavel = " + idResp + 
                " and situacao = 'ABERTO' order by competencia desc";
        Statement stdados = Connection.connection.createStatement(Connection.tipo, Connection.concorrencia);
        ResultSet rsdados = stdados.executeQuery(query);
        while (rsdados.next()) {
            Calendar c = Calendar.getInstance();
            Long idComp = rsdados.getLong("id_comp");
            c.setTime(rsdados.getDate("competencia"));
            Pessoa p = PessoaDAO.getPessoaFindId(rsdados.getLong("id_responsavel"));
            String situacao = rsdados.getString("situacao");
            Competencia comp = new Competencia(idResp, c, p, situacao);
            list.add(comp);
        }
        rsdados.close();
        return list;
    }
    
    public static ArrayList<Autorizacao> getAutorizacoes(Long idComp) throws SQLException {
        ArrayList<Autorizacao> list = new ArrayList<Autorizacao>();

        String query = "select * from autorizacao where id_comp = " + idComp + " order by data_ocorrencia desc";
        Statement stdados = Connection.connection.createStatement(Connection.tipo, Connection.concorrencia);
        ResultSet rsdados = stdados.executeQuery(query);
        while (rsdados.next()) {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Long id = rsdados.getLong("id");
            Pessoa p = PessoaDAO.getPessoaFindId(rsdados.getLong("id_pessoa"));
            c1.setTime(rsdados.getDate("data_ocorrencia"));
            c2.setTime(rsdados.getDate("data_autorizacao"));
            String just = rsdados.getString("justificativa");
            Pessoa responsavel = PessoaDAO.getPessoaFindId(rsdados.getLong("id_responsavel"));
            Horas horas = new Horas(rsdados.getString("horas"));
            Competencia comp = getCompetenciaFindId(rsdados.getLong("id_comp"));
            Autorizacao aut = new Autorizacao();
            aut.setCompetencia(comp);
            aut.setData_autorizacao(c2);
            aut.setData_ocorrencia(c1);
            aut.setFuncionario(p);
            aut.setHoras(horas);
            aut.setId(id);
            aut.setJustificativa(just);
            aut.setResponsavel(responsavel);
            list.add(aut);
        }
        rsdados.close();
        return list;
    }
    
    public static Autorizacao getAutorizacao(Long id) throws SQLException {
        Autorizacao aut = null;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        String query = "select * from autorizacao where id = " + id;
        Statement stdados = Connection.connection.createStatement(Connection.tipo, Connection.concorrencia);
        ResultSet rsdados = stdados.executeQuery(query);
        while (rsdados.next()) {
            Pessoa funcionario = PessoaDAO.getPessoaFindId(rsdados.getLong("id_pessoa"));
            c1.setTime(rsdados.getDate("data_ocorrencia"));
            c2.setTime(rsdados.getDate("data_autorizacao"));
            String just = rsdados.getString("justificativa");
            Pessoa responsavel = PessoaDAO.getPessoaFindId(rsdados.getLong("id_responsavel"));
            Horas horas = new Horas(rsdados.getString("horas"));
            Competencia comp = getCompetenciaFindId(rsdados.getLong("id_comp"));
            aut = new Autorizacao();
            aut.setCompetencia(comp);
            aut.setData_autorizacao(c2);
            aut.setData_ocorrencia(c1);
            aut.setFuncionario(funcionario);
            aut.setHoras(horas);
            aut.setId(id);
            aut.setJustificativa(just);
            aut.setResponsavel(responsavel);
        }

        rsdados.close();
        return aut;
    }
    
}
