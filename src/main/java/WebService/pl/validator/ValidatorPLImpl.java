package WebService.pl.validator;

import WebService.pl.utente.Utente;

import javax.inject.Named;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named("plValidator")
public class ValidatorPLImpl implements ValidatorPL {
    @Override
    public boolean validateNameLength(Utente utente) {
        return utente.getNome().length() > 3;
    }

    @Override
    public boolean validateDateFormat(String data) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = date.parse(data);
        if (parsedDate == null) {
            return false;
        }
        return true;
    }
}
