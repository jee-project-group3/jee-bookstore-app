/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entities.AppUser;
import za.ac.tut.entities.Order;

/**
 *
 * @author Zoey
 */
@Stateless
public class OrderFacade extends AbstractFacade<Order> implements OrderFacadeLocal {
    @PersistenceContext(unitName = "BookManagerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderFacade() {
        super(Order.class);
    }
    @Override
public List<Order> findByUser(AppUser user) {
    return em.createQuery("SELECT o FROM Order o WHERE o.appUser = :user", Order.class)
             .setParameter("user", user)
             .getResultList();
}
}
