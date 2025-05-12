package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.AppUser;
import za.ac.tut.entities.Order;

/**
 * Facade interface for Order entity
 */
@Local
public interface OrderFacadeLocal {

    void create(Order order);

    void edit(Order order);

    void remove(Order order);

    Order find(Object id);

    List<Order> findAll();

    List<Order> findRange(int[] range);

    int count();
    
    List<Order> findByUser(AppUser user);

}
