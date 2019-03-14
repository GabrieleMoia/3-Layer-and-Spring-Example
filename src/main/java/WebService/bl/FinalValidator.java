package WebService.bl;

import javax.inject.Named;

//validatore finale semplicemente utilizzato per chiudere la catena dei validatori. Anche qui dichiaro nel costruttore un oggetto del validatore precedente.
@Named("FinalValidator")
public class FinalValidator implements ValidatorBL {

    private final ValidatorProfanities validator;

    public FinalValidator(@Named("ValidatorProfanities") ValidatorProfanities validator) {
        this.validator = validator;
    }

    @Override
    public boolean validate(UtenteBO utente) {
        return true;
    }
}
