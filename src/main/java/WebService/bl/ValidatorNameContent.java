package WebService.bl;

import javax.inject.Named;

//Prima implementazione dell'interfaccia quindi definisco solo il metodo validate
@Named("ValidatorNameContent")
public class ValidatorNameContent implements ValidatorBL {

    @Override
    public boolean validate(UtenteBO utente) {
       return utente.getNome().toLowerCase().contains("test");
    }
}
