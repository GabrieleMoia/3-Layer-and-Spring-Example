package WebService.pl;

import WebService.bl.UtenteBO;
import WebService.dl.UtenteDL;

public class PLConverterService {

    public Utente convertToUtente (UtenteBO utenteBO){
        Utente utente = new Utente(utenteBO.getId(), utenteBO.getNome());
        return utente;
    }

    public UtenteBO convertToUtenteBO(Utente utente){
        UtenteBO utenteBO = new UtenteBO(utente.getId(), utente.getNome());
        return utenteBO;
    }
}
