package WebService.bl.validator.utente;

import WebService.bl.utente.UtenteBO;

import javax.inject.Named;

//seconda implementazione dell'interfaccia, qui nel costruttore dichiaro un oggetto dell'implementazione precedente in modo da avere un collegamento tra le due
@Named("ValidatorProfanities")
public class ValidatorProfanities implements UtenteValidatorBL {

    private final UtenteValidatorBL validatorBL;

    public ValidatorProfanities(@Named("UtenteFinalValidator") UtenteValidatorBL validatorBL) {
        this.validatorBL = validatorBL;
    }

    @Override
    public boolean validate(UtenteBO utente) {
        if (validatorBL.validate(utente) && !utente.getNome().toLowerCase().contains("cazzo"))
            return true;
        return false;
    }
}
