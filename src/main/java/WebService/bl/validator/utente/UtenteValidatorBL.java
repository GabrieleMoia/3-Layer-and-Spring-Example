package WebService.bl.validator.utente;

import WebService.bl.utente.UtenteBO;

//interfaccia per la validazione
public interface UtenteValidatorBL {
    boolean validate(UtenteBO utente);
}
