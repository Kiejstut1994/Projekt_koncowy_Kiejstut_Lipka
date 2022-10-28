package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.EarandeyesrecoverAccesories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<EarandeyesrecoverAccesories> findallbytype(String type) {
        Query query= entityManager.createQuery("select e from EarandeyesrecoverAccesories e where e.type=:type");
        query.setParameter("type",type);
    return query.getResultList();
    }

    public List<EarandeyesrecoverAccesories> findallearandeyesrecoverAccesories() {
        Query query=entityManager.createQuery("select e from EarandeyesrecoverAccesories e");
        return query.getResultList();
    }

    public EarandeyesrecoverAccesories findearandeyesrecoverAccesoriesbyname(String name) {
        Query query= entityManager.createQuery("select e from EarandeyesrecoverAccesories e where e.name=:name");
        query.setParameter("name",name);
        List<EarandeyesrecoverAccesories> earandeyesrecoverAccesories= query.getResultList();
        return earandeyesrecoverAccesories.get(0);
    }


    public int maxideae() {
        Query query = entityManager.createQuery("SELECT max(e.id) from EarandeyesrecoverAccesories e");
        List<Integer> id=query.getResultList();
        return id.get(0);
    }
}
