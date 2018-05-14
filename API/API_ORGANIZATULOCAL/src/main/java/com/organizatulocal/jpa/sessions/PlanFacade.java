/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organizatulocal.jpa.sessions;

import com.organizatulocal.jpa.entities.Plan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jotac
 */
@Stateless
public class PlanFacade extends AbstractFacade<Plan> {

    @PersistenceContext(unitName = "com.friendgroupcl_API_ORGANIZATULOCAL_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanFacade() {
        super(Plan.class);
    }
    
}
