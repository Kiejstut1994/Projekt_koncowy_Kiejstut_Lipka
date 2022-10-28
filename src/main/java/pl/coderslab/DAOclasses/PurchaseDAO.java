package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.coderslab.classes.Purchaser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PurchaseDAO {
    @PersistenceContext
        EntityManager entityManager;
    public void savePurchaser(Purchaser purchase) {
        entityManager.persist(purchase);
    }
    public void update(Purchaser purchase) {
        entityManager.merge(purchase);
    }
        public Purchaser findById(int id) {
        return entityManager.find(Purchaser.class, id);
    }
    public Purchaser findByPesel(String PESEL) {
        Query query = entityManager.createQuery("SELECT p FROM Purchaser p where p.PESEL=:PESEL");
        query.setParameter("PESEL", PESEL);
        List<Purchaser> wyniki= query.getResultList();
        return wyniki.get(0);
    }
    public List<String> findAllPesel() {
        Query query = entityManager.createQuery("SELECT p.PESEL FROM Purchaser p");
        List<String> wyniki= query.getResultList();
        return wyniki;
    }
    public List<String> findAllEmail() {
        Query query = entityManager.createQuery("SELECT p.email FROM Purchaser p");
        List<String> wyniki= query.getResultList();
        return wyniki;
    }
    public void delete(Purchaser purchase) {
        entityManager.remove(entityManager.contains(purchase) ?
                purchase : entityManager.merge(purchase));
    }


}