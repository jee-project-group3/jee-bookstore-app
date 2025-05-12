package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.AppUser;

/**
 * Facade interface for AppUser entity
 */
@Local
public interface AppUserFacadeLocal {

    void create(AppUser appUser);

    void edit(AppUser appUser);

    void remove(AppUser appUser);

    AppUser find(Object id);

    List<AppUser> findAll();

    List<AppUser> findRange(int[] range);

    int count();
    
     AppUser findByUsername(String username);  // Added method to find user by username

    AppUser findByEmail(String email); 
}
