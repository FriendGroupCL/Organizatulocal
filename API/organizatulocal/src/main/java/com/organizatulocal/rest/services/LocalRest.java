/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;
import com.organizatulocal.jpa.entities.Local;
import com.organizatulocal.jpa.sessions.LocalFacade;
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
@Path("Local")
public class LocalRest {
    @EJB
    private LocalFacade ejbLocalFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Local>findAll(){
    return ejbLocalFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Local local){
        ejbLocalFacade.create(local);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, Local local){
        ejbLocalFacade.edit(local);
    }
    
    /*@DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void remove(@PathParam("id")Integer id){
        ejbLocalFacade.remove(ejbLocalFacade.find(id));
    }*/
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Local findById(@PathParam("id")Integer id){
        return ejbLocalFacade.find(id);
    }
    
}
