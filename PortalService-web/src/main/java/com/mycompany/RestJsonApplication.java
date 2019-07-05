/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.sun.jersey.api.core.PackagesResourceConfig;
import javax.ws.rs.ApplicationPath;
 
@ApplicationPath("/teste")
public class RestJsonApplication extends PackagesResourceConfig {
 
    public RestJsonApplication() {
        super("com.mycompany");
    }
}