package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.Guncovers;
import pl.coderslab.classes.OpticAccesories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Repository
@Transactional
public class OpticAccesoriesDAO {
    @PersistenceContext
    EntityManager entityManager;
    public void saveGuncovers(OpticAccesories opticAccesories) {
        entityManager.persist(opticAccesories);
    }
    public void update(OpticAccesories opticAccesories) {
        entityManager.merge(opticAccesories);
    }
    public OpticAccesories findById(int id) {
        return entityManager.find(OpticAccesories.class, id);
    }
    public void delete(OpticAccesories opticAccesories) {
        entityManager.remove(entityManager.contains(opticAccesories) ?
                opticAccesories : entityManager.merge(opticAccesories));
    }
}
