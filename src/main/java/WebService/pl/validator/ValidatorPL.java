package WebService.pl.validator;

import WebService.pl.utente.Utente;

import java.text.ParseException;

public interface ValidatorPL {
    boolean validateNameLength(Utente utente);
    boolean validateDateFormat(String data) throws ParseException;
}
