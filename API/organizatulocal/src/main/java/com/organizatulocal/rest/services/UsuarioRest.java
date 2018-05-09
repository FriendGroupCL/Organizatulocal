/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;

import com.organizatulocal.jpa.entities.Usuario;
import com.organizatulocal.jpa.sessions.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("Usuario")
public class UsuarioRest {
    @EJB
    private UsuarioFacade ejbUsuarioFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario>findAll(){
    return ejbUsuarioFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Usuario user){
        ejbUsuarioFacade.create(user);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, Usuario user){
        ejbUsuarioFacade.edit(user);
    }
    
    /*@DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void remove(@PathParam("id")Integer id){
        ejbUsuarioFacade.remove(ejbUsuarioFacade.find(id));
    }*/
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Usuario findById(@PathParam("id")Integer id){
        return ejbUsuarioFacade.find(id);
    }
}
