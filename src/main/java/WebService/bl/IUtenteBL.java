package WebService.bl;

import java.util.List;

public interface IUtenteBL {
    List<UtenteBO> getAll();
    UtenteBO addUtente(UtenteBO utente);
    UtenteBO getUtenteByID(int id);
    boolean validator(String nome);
    String deleteUtente(int id);
}
