package WebService.persistence;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named("jpaHelper")
public class JpaHelperImpl implements JpaHelper {

    private EntityManager em;
    private EntityManagerFactory emf;

    public JpaHelperImpl() {
        emf = Persistence.createEntityManagerFactory("JPAEXAMPLE");
        em = emf.createEntityManager();

    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
