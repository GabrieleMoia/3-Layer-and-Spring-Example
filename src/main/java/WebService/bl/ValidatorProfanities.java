package WebService.bl;

import javax.inject.Named;

//seconda implementazione dell'interfaccia, qui nel costruttore dichiaro un oggetto dell'implementazione precedente in modo da avere un collegamento tra le due
@Named("ValidatorProfanities")
public class ValidatorProfanities implements ValidatorBL {

    private final ValidatorBL validatorBL;

    public ValidatorProfanities(@Named("FinalValidator") ValidatorBL validatorBL) {
        this.validatorBL = validatorBL;
    }

    @Override
    public boolean validate(UtenteBO utente) {
        if (validatorBL.validate(utente) && !utente.getNome().toLowerCase().contains("cazzo"))
            return true;
        return false;
    }
}
