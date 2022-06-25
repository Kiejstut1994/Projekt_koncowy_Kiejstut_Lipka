package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Component;
import pl.coderslab.classes.Address;
import pl.coderslab.classes.Purchaser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class AddressDAO {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAddress(Address address) {
        entityManager.persist(address);
    }
    public void update(Address address) {
        entityManager.merge(address);
    }
    public Address findById(int id) {
        return entityManager.find(Address.class, id);
    }
    public void delete(Address address) {
        entityManager.remove(entityManager.contains(address) ?
                address : entityManager.merge(address));
    }
}
