/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.dao;

import br.com.exceptionweb.portalservice.model.Autorizacao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author johnny
 */
public class AutorizacaoDAO {
    
    public final static String INSERT = "insert into autorizacao(id_pessoa, data_ocorrencia, "
            + "data_autorizacao, id_responsavel, justificativa, horas, id_comp, tipo) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?,)";
    
    
    public final static String UPDATE = "update autorizacao set id_pessoa = ?, data_ocorrencia = ?, "+
            "data_autorizacao = ?, id_responsavel = ?, justificativa = ?, horas = ?, id_comp = ?"+
            "tipo = ? where id = ?";
    
    
    public final static String DELETE = "delete from autorizacao where id = ?";
    
    
    public static int persist(Autorizacao aut) throws SQLException{
        int result = 0;
        
        PreparedStatement pstdados = Connection.connection.prepareStatement(INSERT, 
                Connection.tipo, Connection.concorrencia);
        pstdados.setLong(1, aut.getFuncionario().getId());
        pstdados.setDate(2, new Date(aut.getData_ocorrencia().getTimeInMillis()));
        pstdados.setDate(3, new Date(aut.getData_autorizacao().getTimeInMillis()));
        pstdados.setLong(4, aut.getResponsavel().getId());
        pstdados.setString(5, aut.getJustificativa());
        pstdados.setString(6, aut.getHoras().getHoras());
        pstdados.setLong(7, aut.getCompetencia().getId());
        pstdados.setString(8, aut.getTipo());
        result = pstdados.executeUpdate();
        pstdados.close();
        
        return result;
    }
    
    
    public static int update(Autorizacao aut) throws SQLException{
        int result = 0;
        
        PreparedStatement pstdados = Connection.connection.prepareStatement(UPDATE, 
                Connection.tipo, Connection.concorrencia);
        
        pstdados.setLong(1, aut.getFuncionario().getId());
        pstdados.setDate(2, new Date(aut.getData_ocorrencia().getTimeInMillis()));
        pstdados.setDate(3, new Date(aut.getData_autorizacao().getTimeInMillis()));
        pstdados.setLong(4, aut.getResponsavel().getId());
        pstdados.setString(5, aut.getJustificativa());
        pstdados.setString(6, aut.getHoras().getHoras());
        pstdados.setLong(7, aut.getCompetencia().getId());
        pstdados.setString(8, aut.getTipo());
        pstdados.setLong(9, aut.getId());
        result = pstdados.executeUpdate();
        pstdados.close();
        
        
        return result;
    }
    
    
    public static int delete(Autorizacao aut) throws SQLException{
        int result = 0;
        
        PreparedStatement pstdados = Connection.connection.prepareStatement(DELETE, 
                Connection.tipo, Connection.concorrencia);
        
        pstdados.setLong(1, aut.getId());
        result = pstdados.executeUpdate();
        pstdados.close();
        
        
        return result;
    }
    
}
