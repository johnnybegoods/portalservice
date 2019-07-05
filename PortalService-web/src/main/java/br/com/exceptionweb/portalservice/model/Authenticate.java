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
public class Authenticate {
    private String login;
    private String token;
    private boolean authenticate;

    public Authenticate(String login, String token, boolean authenticate) {
        this.login = login;
        this.token = token;
        this.authenticate = authenticate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        this.authenticate = authenticate;
    }
    
    
    
}
