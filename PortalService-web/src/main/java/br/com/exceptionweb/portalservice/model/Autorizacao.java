/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.model;

import br.com.exceptionweb.portalservice.util.Calendario;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author johnny
 */
public class Autorizacao {
    private Long id;
    Pessoa funcionario;
    private Calendar data_ocorrencia;
    private Calendar data_autorizacao;
    private String justificativa;
    private Pessoa responsavel;
    private Horas horas;
    private Competencia competencia;
    private String data_ocorrencia_;
    private String data_autorizacao_;
    private String horas_;
    private String tipo;

    public Autorizacao() {}

    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    public Calendar getData_ocorrencia() {
        return data_ocorrencia;
    }

    public void setData_ocorrencia(Calendar data_ocorrencia) {
        this.data_ocorrencia = data_ocorrencia;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.data_ocorrencia_ = df.format(new Date(this.data_ocorrencia.getTimeInMillis()));
    }

    public Calendar getData_autorizacao() {
        return data_autorizacao;
    }

    public void setData_autorizacao(Calendar data_autorizacao) {
        this.data_autorizacao = data_autorizacao;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.data_autorizacao_ = df.format(new Date(this.data_autorizacao.getTimeInMillis()));
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public Horas getHoras() {
        return horas;
    }

    public void setHoras(Horas horas) {
        this.horas = horas;
        this.horas_ = this.horas.getHoras();
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public String getData_ocorrencia_() {
        return data_ocorrencia_;
    }

    public void setData_ocorrencia_(String data_ocorrencia_) {
        this.data_ocorrencia_ = data_ocorrencia_;
    }

    public String getData_autorizacao_() {
        return data_autorizacao_;
    }

    public void setData_autorizacao_(String data_autorizacao_) {
        this.data_autorizacao_ = data_autorizacao_;
    }

    public String getHoras_() {
        return horas_;
    }

    public void setHoras_(String hroas_) {
        this.horas_ = hroas_;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
