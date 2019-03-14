package WebService.bl;

import WebService.dl.UtenteDL;
import WebService.pl.Utente;

public class BLConverterService {

    public UtenteDL convertToUtenteDL (UtenteBO utenteBO){
        UtenteDL utenteDL = new UtenteDL(utenteBO.getId(), utenteBO.getNome(), utenteBO.isEnabled());
        return utenteDL;
    }

    public UtenteBO convertToUtenteBO(UtenteDL utenteDL){
        UtenteBO utenteBO = new UtenteBO(utenteDL.getId(), utenteDL.getNome(), utenteDL.isEnabled());
        return utenteBO;
    }
}
