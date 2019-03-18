package WebService.bl.validator.utente;

import WebService.bl.utente.UtenteBO;

import javax.inject.Named;

//Prima implementazione dell'interfaccia quindi definisco solo il metodo validate
@Named("ValidatorNameContent")
public class ValidatorNameContent implements UtenteValidatorBL {

    private final UtenteValidatorBL validatorBL;

    public ValidatorNameContent(@Named("ValidatorProfanities") UtenteValidatorBL validatorBL) {
        this.validatorBL = validatorBL;
    }

    @Override
    public boolean validate(UtenteBO utente) {
        return validatorBL.validate(utente) && !utente.getNome().toLowerCase().contains("test");
    }
}
