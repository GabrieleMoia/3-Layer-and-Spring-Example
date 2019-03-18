package WebService.bl.utente;

import WebService.dl.utente.UtenteDL;

public class UtenteBLConverterService {

    public UtenteDL convertToUtenteDL (UtenteBO utenteBO){
        UtenteDL utenteDL = new UtenteDL(utenteBO.getId(), utenteBO.getNome(), utenteBO.isEnabled());
        return utenteDL;
    }

    public UtenteBO convertToUtenteBO(UtenteDL utenteDL){
        UtenteBO utenteBO = new UtenteBO(utenteDL.getId(), utenteDL.getNome(), utenteDL.isEnabled());
        return utenteBO;
    }
}
