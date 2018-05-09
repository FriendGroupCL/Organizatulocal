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
 * @author JordyEnrique
 */
@Path("VentaHasProductoEspecial")
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
    public void create(VentaHasProductoEspecial venta_has_producto_especial){
        ejbVentaHasProductoEspecialFacade.create(venta_has_producto_especial);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, VentaHasProductoEspecial venta_has_producto_especial){
        ejbVentaHasProductoEspecialFacade.edit(venta_has_producto_especial);
    }
    
    /*@DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void remove(@PathParam("id")Integer id){
        ejbVentaHasProductoEspecialFacade.remove(ejbVentaHasProductoEspecialFacade.find(id));
    }*/
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public VentaHasProductoEspecial findById(@PathParam("id")Integer id){
        return ejbVentaHasProductoEspecialFacade.find(id);
    }
}
