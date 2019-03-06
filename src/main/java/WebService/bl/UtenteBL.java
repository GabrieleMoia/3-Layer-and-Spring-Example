package WebService.bl;

import WebService.pl.Utente;

public interface UtenteBL {
    UtenteBO insertUtente(UtenteBO utente);
    UtenteBO getUtente(int id);
    String deleteUtente(int id);
}
