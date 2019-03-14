package WebService.pl;

import javax.inject.Named;

@Named("plValidator")
public class ValidatorPLImpl implements ValidatorPL {
    @Override
    public boolean validateNameLength(Utente utente) {
        return utente.getNome().length() > 3;
    }
}
