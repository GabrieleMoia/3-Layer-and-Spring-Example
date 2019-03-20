package WebService.dl.appuntamento;

import WebService.dl.utente.IUtenteDL;
import WebService.dl.utente.UtenteDL;
import WebService.persistence.JpaHelper;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Named("AppuntamentoDL")
public class AppuntamentoDLImpl implements IAppuntamentoDL {

    private final IUtenteDL utenteDL;
    private HashMap<Integer, AppuntamentoDL> appuntamenti = new HashMap<Integer, AppuntamentoDL>();
    private final JpaHelper jpaHelper;
    String message;


    public AppuntamentoDLImpl(@Named("utenteDL") IUtenteDL utenteDL, @Named("jpaHelper") JpaHelper jpaHelper) {
        this.utenteDL = utenteDL;
        this.jpaHelper = jpaHelper;
    }

    @Override
    public List<AppuntamentoDL> getAll() {
        EntityManager em = jpaHelper.getEntityManager();
        Query query = em.createQuery("FROM AppuntamentoDL");
        List<AppuntamentoDL> appuntmenti = query.getResultList();
        return appuntmenti;
    }

    @Override
    public AppuntamentoDL addAppuntamento(AppuntamentoDL appuntamentoDL) {
        EntityManager em = jpaHelper.getEntityManager();
        em.getTransaction().begin();
        em.persist(appuntamentoDL);
        em.getTransaction().commit();
        //utenti.put(utente.getId(), utente);
        return appuntamentoDL;
    }

    @Override
    public List<AppuntamentoDL> getAppuntamentiByIdUtente(int idUtente) throws Exception {
        EntityManager em = jpaHelper.getEntityManager();
        Query query = em.createQuery("SELECT a FROM AppuntamentoDL a WHERE a.idUtente=:id");
        query.setParameter("id", idUtente);
        return (List<AppuntamentoDL>) query.getResultList();
    }

    @Override
    public AppuntamentoDL editAppuntamento(AppuntamentoDL appuntamentoDL) throws Exception {
        if (!appuntamenti.containsKey(appuntamentoDL.getId())) {
            throw new Exception("Appuntamento non trovato");
        }
        appuntamenti.put(appuntamentoDL.getId(), appuntamentoDL);
        return appuntamentoDL;
    }

    private AppuntamentoDL getAppuntamentoById(int id) {
        EntityManager em = jpaHelper.getEntityManager();
        Query query = em.createQuery("SELECT a FROM AppuntamentoDL a WHERE a.id=:id");
        query.setParameter("id", id);
        return (AppuntamentoDL) query.getResultList().get(0);
    }

    @Override
    public boolean deleteAppuntamento(int id) throws Exception {
        EntityManager em = jpaHelper.getEntityManager();
        AppuntamentoDL appuntamentoDL = getAppuntamentoById(id);
        em.getTransaction().begin();
        em.remove(appuntamentoDL);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public void writeMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
