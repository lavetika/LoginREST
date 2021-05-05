/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
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
 * @author cubiculo de la sac lleno de hormigas
 */
@Path("cliente")
public class RecursoCliente {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RecursoCliente
     */
    public RecursoCliente() {
    }

    /**
     * Retrieves representation of an instance of recursos.RecursoCliente
     * @return an instance of entidades.Cliente
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            clientes.add(new Cliente(i,"cliente"+i,"123123123"+i));
        }        
        return clientes;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Cliente getCliente(@PathParam("id")int id){
        return new Cliente(123,"Yo mero","QWER122334");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/{nombre}")
    public Response getClienteNombre(@PathParam("id")int id,
        @PathParam("nombre")String nombre){        
        Cliente c =  new Cliente(123,"Yo mero","QWER122334");
        return Response.ok(c).build();
    }   
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("query")
    public Response getClienteQuery(@QueryParam("id")int id,
        @QueryParam("nombre")String nombre){
        Cliente c = new Cliente(435,"Yo vengo del query param","QWER122334");
        return Response.status(200).entity(c).build();
    }   

    /**
     * PUT method for updating or creating an instance of RecursoCliente
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCliente(Cliente content) {
        try{
            System.out.println("Esto me llegó " + content);
            return Response.status(200).entity("Todo bien").build();
        }catch(Exception ex){
            return Response.status(500).entity("Ocurrió un error en el server").build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateCliente(@PathParam("id")int id, Cliente content) {
        try{
            System.out.println("Esto me llegó " + content);
            return Response.status(200).entity("Todo bien").build();
        }catch(Exception ex){
            return Response.status(500).entity("Ocurrió un error en el server").build();
        }
    }    
}
