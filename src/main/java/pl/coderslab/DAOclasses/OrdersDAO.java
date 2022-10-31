package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.Guncovers;
import pl.coderslab.classes.Orders;
import pl.coderslab.classes.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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
    public List<Orders> allunpaidandnotactive(){
        Query query= entityManager.createQuery("select o from Orders o where (o.paid=false) or (o.active=false )");
                return query.getResultList();
    }
    public Long existsnotpaidnotactive(){
        Query query= entityManager.createQuery("select count(o.id) from Orders o where (o.paid=false) or (o.active=false )");
        List<Long> exist=  query.getResultList();
        return exist.get(0);
    }
    public List<Orders> myordersactiveorpaid(int id){
        Query query= entityManager.createQuery("select o from Orders o where  o.id=:id");
        query.setParameter("id",id);
        return query.getResultList();
    }
    public Long myexistsnotpaidnotactive(int id){
        Query query= entityManager.createQuery("select count(o.id) from Orders o where  o.id=:id");
        query.setParameter("id",id);
        List<Long> exist=  query.getResultList();
        return exist.get(0);
    }
}
