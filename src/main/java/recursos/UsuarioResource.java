/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import entidades.Usuario;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author angel
 */
@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of recursos.UsuarioResource
     * @return an instance of entidades.Usuario
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getJson() {
        //TODO return proper representation object
        return new Usuario(1, "user", "password");
    }

    /**
     * PUT method for updating or creating an instance of UsuarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void putJson(Usuario content) {
    }
    
    /**
     * PUT method for updating or creating an instance of RecursoCliente
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUsuario(Usuario content) {
        try{
            System.out.println("Esto me llegó " + content);
            return Response.status(200).entity("Todo bien").build();
        }catch(Exception ex){
            return Response.status(500).entity("Ocurrió un error en el server").build();
        }
    }
    
}
