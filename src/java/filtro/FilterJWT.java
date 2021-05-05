/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import datos.Datos;
import entidades.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Alfonso Felix
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class FilterJWT implements ContainerRequestFilter {

    private Datos datos = new Datos();

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String metodo = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        if (path.contains("login") && metodo.equals("POST")) {

            try {
                String json = IOUtils.toString(requestContext.getEntityStream(), Charsets.UTF_8);

                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

                Usuario usuario = gson.fromJson(json, Usuario.class);

                System.out.println(usuario);
                
                if (datos.login(usuario.getUsuario(), usuario.getContrasena())) {
                    String token = crearToken(usuario.getUsuario());
                    json = String.format("{\"token\":\"%s\"}", token);
                }else{
                    json = String.format("{\"token\":\"%s\"}", "null");
                }

                requestContext.setEntityStream(IOUtils.toInputStream(json));
                // String token = crearToken("alfonso");

                // System.out.println(token);
            } catch (IOException ex) {
                Logger.getLogger(FilterJWT.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            String token = requestContext.getHeaderString("Autorizacion");
            if (token != null) {
                if (!verificarToken(token)) {
                    throw new WebApplicationException(Response.Status.UNAUTHORIZED);
                }
            } else {
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }
        }
    }

    private boolean verificarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0").build();

            DecodedJWT jwt = verifier.verify(token);

            return true;
        } catch (JWTVerificationException ex) {

            return false;

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    private String crearToken(String user) {
        String token = null;
        try {
            Algorithm algoritmo = Algorithm.HMAC256("secret");
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("usuario", user)
                    .sign(algoritmo);
            return token;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return token;
    }
}
