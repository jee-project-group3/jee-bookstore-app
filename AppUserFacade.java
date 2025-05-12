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
import javax.persistence.TypedQuery;
import za.ac.tut.entities.AppUser;

/**
 *
 * @author Zoey
 */
@Stateless
public class AppUserFacade extends AbstractFacade<AppUser> implements AppUserFacadeLocal {
    @PersistenceContext(unitName = "BookManagerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppUserFacade() {
        super(AppUser.class);
    }

   @Override
    public AppUser findByUsername(String username) {
        TypedQuery<AppUser> query = em.createQuery("SELECT u FROM AppUser u WHERE u.username = :username", AppUser.class);
        query.setParameter("username", username);
        List<AppUser> users = query.getResultList();
        if (users != null && !users.isEmpty()) {
            return users.get(0);  // Return the first user with this username
        }
        return null;  // Return null if no user found
    }

    @Override
    public AppUser findByEmail(String email) {
        TypedQuery<AppUser> query = em.createQuery("SELECT u FROM AppUser u WHERE u.email = :email", AppUser.class);
        query.setParameter("email", email);
        List<AppUser> users = query.getResultList();
        if (users != null && !users.isEmpty()) {
            return users.get(0);  // Return the first user with this email
        }
        return null;  // Return null if no user found
    }
    
}
