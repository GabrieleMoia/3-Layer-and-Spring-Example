package WebService.bl;

import javax.inject.Named;

//Prima implementazione dell'interfaccia quindi definisco solo il metodo validate
@Named("ValidatorNameContent")
public class ValidatorNameContent implements ValidatorBL {

    private final ValidatorBL validatorBL;

    public ValidatorNameContent(@Named("ValidatorProfanities") ValidatorBL validatorBL) {
        this.validatorBL = validatorBL;
    }

    @Override
    public boolean validate(UtenteBO utente) {
        return validatorBL.validate(utente) && !utente.getNome().toLowerCase().contains("test");
    }
}
