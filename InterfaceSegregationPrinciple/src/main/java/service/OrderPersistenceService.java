package service;

import entity.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderPersistenceService implements PersistenceService<Order>
{
    private static final Map<Long, Order> ORDERS = new HashMap<>();

    @Override
    public void save(Order entity)
    {
        synchronized (ORDERS)
        {
            ORDERS.put(entity.getId(), entity);
        }
    }

    @Override
    public void delete(Order entity)
    {
        synchronized (ORDERS)
        {
            ORDERS.remove(entity.getId());
        }
    }

    @Override
    public Order findById(Long id)
    {
        return ORDERS.get(id);
    }

    // The method below has been removed from the interface so that we can avoid dummy method implementation.
//    // This method violates the Interface Segregation principle once the order object doesn't have a field for a name.
//    // This method doesn't make sense for this class.
//    @Override
//    public List<Order> findByName(String name)
//    {
//        throw new UnsupportedOperationException("Find by name is not supported.");
//    }

}
