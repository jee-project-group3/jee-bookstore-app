package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.OrderItem;

/**
 * Facade interface for OrderItem entity
 */
@Local
public interface OrderItemFacadeLocal {

    void create(OrderItem orderItem);

    void edit(OrderItem orderItem);

    void remove(OrderItem orderItem);

    OrderItem find(Object id);

    List<OrderItem> findAll();

    List<OrderItem> findRange(int[] range);

    int count();
}
