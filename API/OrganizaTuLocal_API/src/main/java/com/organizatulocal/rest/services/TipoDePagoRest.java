/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;

import com.organizatulocal.jpa.entities.TipoDePago;
import com.organizatulocal.jpa.sessions.TipoDePagoFacade;
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
@Path("TiposDePago")
public class TipoDePagoRest {
    
    @EJB
    private TipoDePagoFacade ejbTipoDePagoFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoDePago>findAll(){
    return ejbTipoDePagoFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(TipoDePago tipodepago){
        ejbTipoDePagoFacade.create(tipodepago);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, TipoDePago tipodepago){
        ejbTipoDePagoFacade.edit(tipodepago);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public TipoDePago findById(@PathParam("id")Integer id){
        return ejbTipoDePagoFacade.find(id);
    }
}
