/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author johnny
 */
public class Competencia{
    private Long id;
    private Calendar competencia;
    private Pessoa responsavel;
    private String situacao;
    private String competencia_;

    public Competencia(Long id, Calendar competencia, Pessoa responsavel, String situacao) {
        SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
        this.id = id;
        this.competencia = competencia;
        this.responsavel = responsavel;
        this.situacao = situacao;
        this.competencia_ = df.format(this.competencia.getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Calendar competencia) {
        this.competencia = competencia;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    
    
}
