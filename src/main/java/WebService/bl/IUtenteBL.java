package WebService.bl;

import java.util.List;

public interface IUtenteBL {
    List<UtenteBO> getAll();
    UtenteBO addUtente(UtenteBO utente);
    UtenteBO getUtenteByID(int id);
    String deleteUtente(int id);
}
