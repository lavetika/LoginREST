/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author angel
 */
@Provider
public class FiltroJWT2 implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        
        String metodo = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        if (path.contains("login") && metodo.equals("POST")){
            MultivaluedMap<String, String> pathparam = requestContext.getUriInfo().getPathParameters();
            
            crearToken("usuario");
        }
        else {
            String token = requestContext.getHeaderString("Autorizacion");
            if (token != null ) {
                //verificar token
            }
            else{
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }                
        }
        
    }
    
    private String crearToken(String usuario) {
        String token = null;
        
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create().withIssuer("auth0")
                    .withClaim("usuario", usuario)
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }
        return token;
    }
    
    private void verificarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0").build();
            
            DecodedJWT jwt = verifier.verify(token);
        } catch (JWTVerificationException exception) {
            
        }
    }
    
}
