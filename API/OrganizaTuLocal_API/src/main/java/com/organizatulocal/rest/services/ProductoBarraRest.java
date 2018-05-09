/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;

import com.organizatulocal.jpa.entities.ProductoBarra;
import com.organizatulocal.jpa.sessions.ProductoBarraFacade;
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
@Path("ProductosBarras")
public class ProductoBarraRest {
    
    @EJB
    private ProductoBarraFacade ejbProductoBarraFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProductoBarra>findAll(){
    return ejbProductoBarraFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(ProductoBarra productobarra){
        ejbProductoBarraFacade.create(productobarra);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, ProductoBarra productobarra){
        ejbProductoBarraFacade.edit(productobarra);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public ProductoBarra findById(@PathParam("id")Integer id){
        return ejbProductoBarraFacade.find(id);
    }
}
