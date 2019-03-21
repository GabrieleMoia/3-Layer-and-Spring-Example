package WebService.dl.utente;

import WebService.dl.count.utente.CountDL;
import WebService.persistence.JpaHelper;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Named("utenteDL")
public class UtenteDLImpl implements IUtenteDL {

    //private HashMap<Integer, UtenteDL> utenti = new HashMap<Integer, UtenteDL>();
    private final CountDL countDL;
    private final JpaHelper jpaHelper;

    public UtenteDLImpl(@Named("CountDL") CountDL countDL, @Named("jpaHelper") JpaHelper jpaHelper) {
        this.countDL = countDL;
        this.jpaHelper = jpaHelper;
    }

    @Override
    public List<UtenteDL> getAll() {
        //return new ArrayList<UtenteDL>(utenti.values());
        EntityManager em = jpaHelper.getEntityManager();
        Query query = em.createQuery("FROM UtenteDL");
        List<UtenteDL> utenti = query.getResultList();
        return utenti;
    }

    @Override
    public UtenteDL addUtente(UtenteDL utente) {
        EntityManager em = jpaHelper.getEntityManager();
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        //utenti.put(utente.getId(), utente);
        return utente;
    }

    @Override
    public UtenteDL getUtenteByID(int id) {
        EntityManager em = jpaHelper.getEntityManager();
        Query query = em.createQuery("SELECT u FROM UtenteDL u WHERE u.id=:id");
        query.setParameter("id", id);
        return (UtenteDL) query.getResultList().get(0);
        /*if (!utenti.containsKey(id)) {
            return null;
        }
        return utenti.get(id);*/
    }

    @Override
    public boolean deleteUtente(int id) {
        EntityManager em = jpaHelper.getEntityManager();
        UtenteDL utente = getUtenteByID(id);
        em.getTransaction().begin();
        em.remove(utente);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public void update(UtenteDL utenteDL) throws Exception {
        /*if (!utenti.containsKey(utenteDL.getId())) {
            throw new Exception("Utente non trovato");
        }
        utenti.put(utenteDL.getId(), utenteDL);*/
    }


}
