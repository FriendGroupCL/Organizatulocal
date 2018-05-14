/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.jpa.sessions;

import com.organizatulocal.jpa.entities.VentaHasProductoBarra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jotac
 */
@Stateless
public class VentaHasProductoBarraFacade extends AbstractFacade<VentaHasProductoBarra> {

    @PersistenceContext(unitName = "com.friendgroupcl_API_ORGANIZATULOCAL_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaHasProductoBarraFacade() {
        super(VentaHasProductoBarra.class);
    }
    
}
