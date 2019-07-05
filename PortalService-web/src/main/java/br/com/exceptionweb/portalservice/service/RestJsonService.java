/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exceptionweb.portalservice.service;

import com.sun.jersey.api.core.PackagesResourceConfig;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author johnny
 */
@ApplicationPath("/")
public class RestJsonService extends PackagesResourceConfig {
    
    public RestJsonService(){
        super("br.com.exceptionweb.portalservice.service");
    }
    
}
