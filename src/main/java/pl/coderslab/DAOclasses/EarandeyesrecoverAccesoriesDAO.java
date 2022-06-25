package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.EarandeyesrecoverAccesories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EarandeyesrecoverAccesoriesDAO {
    @PersistenceContext
    EntityManager entityManager;
    public void saveEarandeyesrecoverAccesories(EarandeyesrecoverAccesories earandeyesrecoverAccesories) {
        entityManager.persist(earandeyesrecoverAccesories);
    }
    public void update(EarandeyesrecoverAccesories earandeyesrecoverAccesories) {
        entityManager.merge(earandeyesrecoverAccesories);
    }
    public EarandeyesrecoverAccesories findById(int id) {
        return entityManager.find(EarandeyesrecoverAccesories.class, id);
    }
    public EarandeyesrecoverAccesories findByType(String type) {
        return entityManager.find(EarandeyesrecoverAccesories.class, type);
    }
    public void delete(EarandeyesrecoverAccesories earandeyesrecoverAccesories) {
        entityManager.remove(entityManager.contains(earandeyesrecoverAccesories) ?
                earandeyesrecoverAccesories : entityManager.merge(earandeyesrecoverAccesories));
    }
}
