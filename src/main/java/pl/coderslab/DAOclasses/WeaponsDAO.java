package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.Guncovers;
import pl.coderslab.classes.Weapons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WeaponsDAO {
    @PersistenceContext
    EntityManager entityManager;
    public void saveWeapons(Weapons weapons) {
        entityManager.persist(weapons);
    }

    public void update(Weapons weapons) {
        entityManager.merge(weapons);
    }
    public Weapons findById(int id) {
        return entityManager.find(Weapons.class, id);
    }
    public void delete(Weapons weapons) {
        entityManager.remove(entityManager.contains(weapons) ?
                weapons : entityManager.merge(weapons));
    }
    public List<Weapons> findalltype(String type){
        Query query = entityManager.createQuery("SELECT w FROM Weapons w where w.type=:type");
        query.setParameter("type",type);
        return query.getResultList();
    }
    public List<String> findallname(){
        Query query = entityManager.createQuery("SELECT w.name FROM Weapons w ");
        List<String> names=query.getResultList();
        return names;
    }
    public List<Weapons> findall(){
        Query query = entityManager.createQuery("SELECT w FROM Weapons w ");
        return query.getResultList();
    }
    public Weapons findbyname(String name){
        Query query = entityManager.createQuery("SELECT w FROM Weapons w where w.name=:name");
       query.setParameter("name",name);
       List<Weapons> weapons=query.getResultList();
        return weapons.get(0);
    }

}
