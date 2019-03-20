package WebService.persistence;

import javax.inject.Named;
import javax.persistence.EntityManager;

public interface JpaHelper {
    EntityManager getEntityManager();
}
