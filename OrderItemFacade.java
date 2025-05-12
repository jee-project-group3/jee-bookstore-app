/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entities.OrderItem;

/**
 *
 * @author Zoey
 */
@Stateless
public class OrderItemFacade extends AbstractFacade<OrderItem> implements OrderItemFacadeLocal {
    @PersistenceContext(unitName = "BookManagerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderItemFacade() {
        super(OrderItem.class);
    }
    
}
