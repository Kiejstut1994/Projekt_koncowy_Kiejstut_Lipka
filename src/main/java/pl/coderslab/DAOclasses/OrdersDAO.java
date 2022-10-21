package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.Guncovers;
import pl.coderslab.classes.Orders;
import pl.coderslab.classes.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OrdersDAO {
    @PersistenceContext
    EntityManager entityManager;
    public Orders findById(int id) {
        return entityManager.find(Orders.class, id);
    }
    public void saveOrders(Orders orders) {
        entityManager.persist(orders);
    }
    public void updateorders(Orders orders) {
        entityManager.merge(orders);
    }
}
