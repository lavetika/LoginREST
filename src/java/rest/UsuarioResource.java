/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import datos.Datos;
import entidades.Usuario;
import filtro.FilterJWT;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Alfonso Felix
 */
@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;
   

    /**
     * Retrieves representation of an instance of recursos.RecursoCliente
     * @return an instance of entidades.Cliente
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getClientes() {
        
        return (new Datos()).getLstUsuarios();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public Response postLogin(String json) {
        try{
            return Response.status(200).entity(json).build();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return Response.status(500).entity("Ocurrió un error en el server").build();
        }
    }
    
    
}
