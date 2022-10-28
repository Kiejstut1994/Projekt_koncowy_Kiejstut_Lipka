package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.Ammunition;
import pl.coderslab.classes.Guncovers;
import pl.coderslab.classes.OpticAccesories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OpticAccesoriesDAO {
    @PersistenceContext
    EntityManager entityManager;
    public void saveOpticAccesories(OpticAccesories opticAccesories) {
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
    public List<OpticAccesories> findalloptics(){
        Query query = entityManager.createQuery("SELECT o FROM OpticAccesories o");
        List<OpticAccesories> opticAccesories=query.getResultList();
        return opticAccesories;
    }
    public List<String> findallopticsnames(){
        Query query = entityManager.createQuery("SELECT o.name FROM OpticAccesories o");
        List<String> names=query.getResultList();
        return names;
    }
    public OpticAccesories findopticsbyname(String name){
        Query query = entityManager.createQuery("SELECT o FROM OpticAccesories o where o.name=:name");
        query.setParameter("name",name);
        List<OpticAccesories> opticAccesories=query.getResultList();
        return opticAccesories.get(0);
    }

    public List<OpticAccesories> findalltype(String type) {
        Query query=entityManager.createQuery("SELECT o FROM OpticAccesories o where o.type=:type");
        query.setParameter("type",type);
        List<OpticAccesories> opticAccesories=query.getResultList();
        return opticAccesories;
    }

    public int maxopt() {
        Query query = entityManager.createQuery("SELECT max(o.id) FROM OpticAccesories o ");
        List<Integer> opticAccesories=query.getResultList();
        return opticAccesories.get(0);
    }
}
