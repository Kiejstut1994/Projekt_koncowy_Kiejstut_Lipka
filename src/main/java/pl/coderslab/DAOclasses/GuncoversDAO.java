package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Repository;
import pl.coderslab.classes.Ammunition;
import pl.coderslab.classes.Guncovers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Guncovers> findallguncovs() {
        Query query=entityManager.createQuery("select g from Guncovers g");
        return query.getResultList();
    }

    public List<String> findallguncovernames() {
        Query query=entityManager.createQuery("select g.name from Guncovers g");
        List<String> names=query.getResultList();
        return names;
    }


    public Guncovers findguncovsbyname(String name) {
        Query query= entityManager.createQuery("select g from Guncovers g where g.name=:name");
        query.setParameter("name",name);
        List<Guncovers> guncovers=query.getResultList();
        return guncovers.get(0);
    }

    public int maxgcov() {
        Query query= entityManager.createQuery("select max(g.id) from Guncovers g");
        List<Integer> guncovers=query.getResultList();
        return guncovers.get(0);
    }
}
