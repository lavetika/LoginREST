/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import com.sun.javafx.scene.traversal.Algorithm;
import com.auth0.jwt.algorithms.Algorithm;
import java.io.IOException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
import com.auth0.jwt.impl.JWTParser;

/**
 *
 * @author laura
 */
public class FiltroJWT implements ContainerRequestFilter {
    private final String AUTH_HEADER = "Autorizacion";
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String metodo = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        if (path.contains("login") && metodo.equals("POST")){
            
        }
        else {
            String token = requestContext.getHeaderString("Autorizacion");
            if (token != null ) {
                //verificar token
            }
            else{
                throw new WebApplicationException(Status.UNAUTHORIZED);
            }                
        }
    }
    
    private String crearToken(String user){
        String token = null;
        try{
            Algorithm algoritmo = Algorithm.HMAC256("secret");
            token = JWT.create().withIssuer("auth0").withClaim("usr", user).sign(algoritmo);
            
        }catch(JWRCreationException e){
            
        }
        return token;
    }
    
}