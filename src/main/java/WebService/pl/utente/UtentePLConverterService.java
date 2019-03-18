package WebService.pl.utente;

import WebService.bl.utente.UtenteBO;
import WebService.pl.utente.Utente;

public class UtentePLConverterService {

    public Utente convertToUtente(UtenteBO utenteBO) {
        Utente utente = new Utente(utenteBO.getId(), utenteBO.getNome());
        return utente;
    }

    public UtenteBO convertToUtenteBO(Utente utente) {
        UtenteBO utenteBO = new UtenteBO(utente.getId(), utente.getNome(), false);
        return utenteBO;
    }
}
