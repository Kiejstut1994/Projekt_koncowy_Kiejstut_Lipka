package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.Ammunition;
import pl.coderslab.classes.Guncovers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class GuncoversDAO {
    @PersistenceContext
    EntityManager entityManager;
    public void saveGuncovers(Guncovers guncovers) {
        entityManager.persist(guncovers);
    }
    public void update(Guncovers guncovers) {
        entityManager.merge(guncovers);
    }
    public Guncovers findById(int id) {
        return entityManager.find(Guncovers.class, id);
    }
    public void delete(Guncovers guncovers) {
        entityManager.remove(entityManager.contains(guncovers) ?
                guncovers : entityManager.merge(guncovers));
    }
}
