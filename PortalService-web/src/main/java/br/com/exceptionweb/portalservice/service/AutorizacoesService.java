/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.exceptionweb.portalservice.service;

import br.com.exceptionweb.portalservice.dao.HistoricoDAO;
import br.com.exceptionweb.portalservice.model.Autorizacao;
import br.com.exceptionweb.portalservice.model.Competencia;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author johnny
 */
@Path("/autorizacoes")
public class AutorizacoesService {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDataService(@QueryParam("competencia") Long comp) throws SQLException{
        Gson gson = new Gson();
        
        
        ArrayList<Autorizacao> lista = HistoricoDAO.getAutorizacoes(comp);
        
        String jsonRetorno = gson.toJson(lista);
        
        
        return Response.ok().header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Credentials", "true")
          .header("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization")
          .header("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
          .entity(jsonRetorno)
          .build();
    }
    
}
