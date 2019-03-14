package WebService.bl;

import javax.inject.Named;

@Named("blValidator")
public class ValidatorBLImpl implements ValidatorBL {

    @Override
    public boolean validateNameContent(UtenteBO utente) {
       return utente.getNome().toLowerCase().contains("test");
    }
}
