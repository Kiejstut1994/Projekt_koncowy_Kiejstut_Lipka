package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.Ammunition;
import pl.coderslab.classes.Weapons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AmmunitionDAO {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAmmunition(Ammunition ammunition) {
        entityManager.persist(ammunition);
    }
    public void update(Ammunition ammunition) {
        entityManager.merge(ammunition);
    }
    public Ammunition findById(int id) {
        return entityManager.find(Ammunition.class, id);
    }
    public Ammunition findByCaliber(String caliber) {
        return entityManager.find(Ammunition.class, caliber);
    }
    public void delete(Ammunition ammunition) {
        entityManager.remove(entityManager.contains(ammunition) ?
                ammunition : entityManager.merge(ammunition));
    }
    public List<Ammunition> findalltype(String type){
        Query query = entityManager.createQuery("SELECT a FROM Ammunition a where a.type=:type");
        query.setParameter("type",type);
        return query.getResultList();
    }
    public List<Ammunition> findall(){
        Query query = entityManager.createQuery("SELECT a FROM Ammunition a");
        List<Ammunition> ammunitions=query.getResultList();
        return ammunitions;
    }
    public List<String> findallammnames(){
        Query query = entityManager.createQuery("SELECT a.name FROM Ammunition a");
        List<String> names=query.getResultList();
        return names;
    }
    public Ammunition findammbyname(String name){
        Query query = entityManager.createQuery("SELECT a FROM Ammunition a where a.name=:name");
        query.setParameter("name",name);
        List<Ammunition> ammunitions=query.getResultList();
        return ammunitions.get(0);
    }
    public int maxid(){
        Query query = entityManager.createQuery("SELECT max(a.id) from Ammunition a");
        List<Integer> id=query.getResultList();
        return id.get(0);
    }
}





