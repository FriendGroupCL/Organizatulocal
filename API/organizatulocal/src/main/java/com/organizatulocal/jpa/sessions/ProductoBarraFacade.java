/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.jpa.sessions;

import com.organizatulocal.jpa.entities.ProductoBarra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JordyEnrique
 */
@Stateless
public class ProductoBarraFacade extends AbstractFacade<ProductoBarra> {

    @PersistenceContext(unitName = "com.mycompany_organizatulocal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoBarraFacade() {
        super(ProductoBarra.class);
    }
    
}
