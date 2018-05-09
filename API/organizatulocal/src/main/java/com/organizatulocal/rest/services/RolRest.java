/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;

import com.organizatulocal.jpa.entities.Rol;
import com.organizatulocal.jpa.sessions.RolFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author JordyEnrique
 */
@Path("Rol")
public class RolRest {
    @EJB
    private RolFacade ejbRolFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Rol>findAll(){
    return ejbRolFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Rol rol){
        ejbRolFacade.create(rol);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, Rol rol){
        ejbRolFacade.edit(rol);
    }
    
    /*@DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void remove(@PathParam("id")Integer id){
        ejbRolFacade.remove(ejbRolFacade.find(id));
    }*/
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Rol findById(@PathParam("id")Integer id){
        return ejbRolFacade.find(id);
    }
}
