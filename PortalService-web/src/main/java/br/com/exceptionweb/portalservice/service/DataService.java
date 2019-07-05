/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.service;

import br.com.exceptionweb.portalservice.dao.PessoaDAO;
import br.com.exceptionweb.portalservice.model.Autorizacao;
import br.com.exceptionweb.portalservice.model.Pessoa;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author johnny
 */
@Path("/dados")
public class DataService {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDataService(String param) throws SQLException{
        
        ArrayList<Pessoa> cadastro = PessoaDAO.getAll();
        Gson gson = new Gson();
        String jsonRetorno = gson.toJson(cadastro);
        
        
        return Response.ok().header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Credentials", "true")
          .header("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization")
          .header("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
          .entity(jsonRetorno)
          .build();
    }
    
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response persist(String param) throws SQLException{
        
        Gson gson = new Gson();
        Autorizacao aut = gson.fromJson(param, Autorizacao.class);
        
        if(aut != null){
            return Response.ok().header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Credentials", "true")
          .header("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization")
          .header("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
           .entity(param)
          .build();
        }
        else{
            return Response.status(500).build();
        
        
        }
    }
   
    
}
