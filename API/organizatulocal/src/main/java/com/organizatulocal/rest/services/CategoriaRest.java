/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;
import com.organizatulocal.jpa.entities.Categoria;
import com.organizatulocal.jpa.sessions.CategoriaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author JordyEnrique
 */
@Path("Categoria")
public class CategoriaRest {
    @EJB
    private CategoriaFacade ejbCategoriaFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Categoria>findAll(){
    return ejbCategoriaFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Categoria categoria){
        ejbCategoriaFacade.create(categoria);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, Categoria categoria){
        ejbCategoriaFacade.edit(categoria);
    }
    
    /*@DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void remove(@PathParam("id")Integer id){
        ejbCategoriaFacade.remove(ejbCategoriaFacade.find(id));
    }*/
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Categoria findById(@PathParam("id")Integer id){
        return ejbCategoriaFacade.find(id);
    }
}
