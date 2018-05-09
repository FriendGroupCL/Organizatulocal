/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;

import com.organizatulocal.jpa.entities.Venta;
import com.organizatulocal.jpa.sessions.VentaFacade;
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
@Path("Ventas")
public class VentaRest {
    
    @EJB
    private VentaFacade ejbVentaFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Venta>findAll(){
    return ejbVentaFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Venta venta){
        ejbVentaFacade.create(venta);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, Venta venta){
        ejbVentaFacade.edit(venta);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Venta findById(@PathParam("id")Integer id){
        return ejbVentaFacade.find(id);
    }
}
