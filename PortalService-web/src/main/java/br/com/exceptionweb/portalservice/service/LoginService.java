/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exceptionweb.portalservice.service;

import br.com.exceptionweb.portalservice.model.Authenticate;
import br.com.exceptionweb.portalservice.model.Credencial;
import com.google.gson.Gson;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.Date;
import java.util.Calendar;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author johnny
 */
@Path("/login")
public class LoginService {
    private final static String FRASE_SEGREDO =  "portalservicejwttokenwebservice";
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response index(String jsonString) {
       
        try {
            Gson gson = new Gson();
            Credencial c = gson.fromJson(jsonString, Credencial.class);
            validarCrendenciais(c);
            String token = gerarToken(c.getLogin(),30);
            //Authenticate auth = new Authenticate(c.getLogin(), token, true);
            Gson authJson = new Gson();
            String respJson = authJson.toJson(token);
            return Response.ok().header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Credentials", "true")
          .header("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization")
          .header("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
          .entity(respJson)
          .build();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Status.UNAUTHORIZED).header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Credentials", "true")
          .header("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization")
          .header("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
        }
        
           
        
        /*
        return Response
          .status(200)
          .header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Credentials", "true")
          .header("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization")
          .header("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
          .entity("")
          .build(); */
    }
    
    
    private void validarCrendenciais(Credencial crendencial) throws Exception {
        try {
            if(!crendencial.getLogin().equals("05309262962") || !crendencial.getSenha().equals("123")){
                throw new Exception("Crendencias não válidas!");
                
            }
            

        } catch (Exception e) {
                throw e;
        }

    }
    
    
    private  String gerarToken(String login,Integer expiraEmMinutos ){
	Calendar hoje = Calendar.getInstance();
        Calendar expira = Calendar.getInstance();
        expira.add(Calendar.MINUTE, expiraEmMinutos);
        
        //Defini qual vai ser o algotirmo da assinatura no caso vai ser o HMAC SHA512
		SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;
		//Data atual que data que o token foi gerado
		java.util.Date agora = new java.util.Date();
		//Define até que data o token é pelo quantidade de dias que foi passo pelo parametro expiraEmDias
		//Encoda a frase sergredo pra base64 pra ser usada na geração do token 
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(FRASE_SEGREDO);
		SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritimoAssinatura.getJcaName());
		//E finalmente utiliza o JWT builder pra gerar o token
		JwtBuilder construtor = Jwts.builder()
				.setIssuedAt(agora)//Data que o token foi gerado
				.setIssuer(login)//Coloca o login do usuario mais podia qualquer outra informação
				.signWith(algoritimoAssinatura, key)//coloca o algoritimo de assinatura e frase segredo ja encodada
				.setExpiration(expira.getTime());// coloca até que data que o token é valido

		return construtor.compact();//Constroi o token retorando a string dele
    }
    
}
