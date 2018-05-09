/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;

import com.organizatulocal.jpa.entities.Permiso;
import com.organizatulocal.jpa.sessions.PermisoFacade;
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
 * @author jotac
 */
@Path("Permisos")
public class PermisoRest {
    
    @EJB
    private PermisoFacade ejbPermisoFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Permiso>findAll(){
    return ejbPermisoFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Permiso permiso){
        ejbPermisoFacade.create(permiso);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, Permiso permiso){
        ejbPermisoFacade.edit(permiso);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Permiso findById(@PathParam("id")Integer id){
        return ejbPermisoFacade.find(id);
    }
}
