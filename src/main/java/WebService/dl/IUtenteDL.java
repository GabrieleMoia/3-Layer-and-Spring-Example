package WebService.dl;

import java.util.List;

public interface IUtenteDL {
    List<UtenteDL> getAll();
    UtenteDL addUtente(UtenteDL utente);
    UtenteDL getUtenteByID(int id);
    boolean deleteUtente(int id);
    void update(UtenteDL utenteDL) throws Exception;
}
