/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;
import com.organizatulocal.jpa.entities.VentaHasProductoBarra;
import com.organizatulocal.jpa.sessions.VentaHasProductoBarraFacade;
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
@Path("VentaHasProductoBarra")
public class VentaHasProductoBarraRest {
    @EJB
    private VentaHasProductoBarraFacade ejbVentaHasProductoBarraFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<VentaHasProductoBarra>findAll(){
    return ejbVentaHasProductoBarraFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(VentaHasProductoBarra venta_has_producto_barra){
        ejbVentaHasProductoBarraFacade.create(venta_has_producto_barra);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, VentaHasProductoBarra venta_has_producto_barra){
        ejbVentaHasProductoBarraFacade.edit(venta_has_producto_barra);
    }
    
    /*@DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void remove(@PathParam("id")Integer id){
        ejbVentaHasProductoBarraFacade.remove(ejbVentaHasProductoBarraFacade.find(id));
    }*/
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public VentaHasProductoBarra findById(@PathParam("id")Integer id){
        return ejbVentaHasProductoBarraFacade.find(id);
    }
}
