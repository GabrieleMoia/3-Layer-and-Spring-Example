package WebService.dl;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("utenteDL")
public class UtenteDLImpl implements IUtenteDL {

    List<UtenteDL> utenti = new ArrayList<>();

    @Override
    public List<UtenteDL> getAll() {
        return utenti;
    }

    @Override
    public UtenteDL addUtente(UtenteDL utente) {
        utenti.add(utente);
        return utente;
    }

    @Override
    public UtenteDL getUtenteByID(int id) {
        for (UtenteDL utenteDL : utenti) {
            if (utenteDL.getId() == id) {
                return utenteDL;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUtente(int id) {
        for (UtenteDL utenteDL : utenti) {
            if (utenteDL.getId() == id) {
                utenti.remove(utenteDL);
                return true;
            }
        }
        return false;
    }


}
