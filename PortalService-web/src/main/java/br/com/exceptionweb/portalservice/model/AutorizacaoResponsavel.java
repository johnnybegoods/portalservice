/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.model;

/**
 *
 * @author johnny
 */
public class AutorizacaoResponsavel extends Autorizacao {
    private boolean autorizaco = false;
    public AutorizacaoResponsavel(){
        super();
    }

    public boolean isAutorizaco() {
        return autorizaco;
    }

    public void setAutorizaco(boolean autorizaco) {
        this.autorizaco = autorizaco;
    }
    
    
}
