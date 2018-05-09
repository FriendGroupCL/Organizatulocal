/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;

import com.organizatulocal.jpa.entities.ProductoEspecial;
import com.organizatulocal.jpa.sessions.ProductoEspecialFacade;
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
@Path("ProductosEspeciales")
public class ProductoEspecialRest {
    
    @EJB
    private ProductoEspecialFacade ejbProductoEspecialFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProductoEspecial>findAll(){
    return ejbProductoEspecialFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(ProductoEspecial productoespecial){
        ejbProductoEspecialFacade.create(productoespecial);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, ProductoEspecial productoespecial){
        ejbProductoEspecialFacade.edit(productoespecial);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public ProductoEspecial findById(@PathParam("id")Integer id){
        return ejbProductoEspecialFacade.find(id);
    }
}
