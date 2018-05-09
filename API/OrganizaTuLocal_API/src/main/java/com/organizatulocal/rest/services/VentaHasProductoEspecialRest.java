/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;

import com.organizatulocal.jpa.entities.VentaHasProductoEspecial;
import com.organizatulocal.jpa.sessions.VentaHasProductoEspecialFacade;
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
@Path("Ventas_ProductoEspecial")
public class VentaHasProductoEspecialRest {
    
    @EJB
    private VentaHasProductoEspecialFacade ejbVentaHasProductoEspecialFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<VentaHasProductoEspecial>findAll(){
    return ejbVentaHasProductoEspecialFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(VentaHasProductoEspecial ventahasproductoespecial){
        ejbVentaHasProductoEspecialFacade.create(ventahasproductoespecial);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, VentaHasProductoEspecial ventahasproductoespecial){
        ejbVentaHasProductoEspecialFacade.edit(ventahasproductoespecial);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public VentaHasProductoEspecial findById(@PathParam("id")Integer id){
        return ejbVentaHasProductoEspecialFacade.find(id);
    }
}
