package WebService.bl.validator.utente;

import WebService.bl.utente.UtenteBO;

import javax.inject.Named;

//validatore finale semplicemente utilizzato per chiudere la catena dei validatori. Anche qui dichiaro nel costruttore un oggetto del validatore precedente.
@Named("UtenteFinalValidator")
public class FinalValidator implements UtenteValidatorBL {

    @Override
    public boolean validate(UtenteBO utente) {
        return true;
    }
}
