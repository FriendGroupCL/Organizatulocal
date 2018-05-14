/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.rest.services;

import com.organizatulocal.jpa.entities.Usuario;
import com.organizatulocal.jpa.sessions.UsuarioFacade;
import static com.organizatulocal.rest.services.Encriptacion.sr;
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
@Path("Usuarios")
public class UsuarioRest {
    
    @EJB
    private UsuarioFacade ejbUsuarioFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario>findAll(){
    return ejbUsuarioFacade.findAll();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Usuario usuario){
        
        System.out.println("CLAVE QUE VIENE DESDE ANGULARJS "+usuario.getClave());
        String clave = "FooBar1234567890"; // 128 bit
        byte[] iv = new byte[16];
        sr.nextBytes(iv);
        String claveEncriptada = Encriptacion.encriptar(clave, iv, usuario.getClave());
        System.out.println("CLAVE ENCRIPTADA  "+claveEncriptada);
        usuario.setClave(claveEncriptada);
        String desencriptar = Encriptacion.decriptar(clave, iv, claveEncriptada);
        System.out.println("CLAVE DESENCRIPTADA DESDE HASH "+desencriptar);
        /*String clave = "FooBar1234567890"; // 128 bit
        byte[] iv = new byte[16];
        sr.nextBytes(iv);
        String encriptado = encriptar(clave, iv, usuario.getClave());
        usuario.setClave(encriptado);
        System.out.println("Usuario"+usuario);*/
        //ejbUsuarioFacade.create(usuario);
        System.out.println("USUARIO CREADO CON CLAVE HASHEADA "+ usuario.getClave()+" "+usuario.getCorreo()+" "+usuario.getNombre()+" "+usuario.getLocalId()+" "+usuario.getRolId()+" ESTADO "+usuario.getEstado());
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public void edit(@PathParam("id")Integer id, Usuario usuario){
        ejbUsuarioFacade.edit(usuario);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Usuario findById(@PathParam("id")Integer id){
        return ejbUsuarioFacade.find(id);
    }
}
