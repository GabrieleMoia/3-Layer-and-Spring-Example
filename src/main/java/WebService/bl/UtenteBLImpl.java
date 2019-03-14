package WebService.bl;

import WebService.dl.IUtenteDL;
import WebService.dl.UtenteDL;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("utenteBL")
public class UtenteBLImpl implements IUtenteBL {

    private final IUtenteDL utenteDL;
    private final ValidatorBL validatorBL;
    private BLConverterService service = new BLConverterService();

    @Inject
    public UtenteBLImpl(@Named("utenteDL") IUtenteDL utenteDL, @Named("blValidator") ValidatorBL validatorBL) {
        this.utenteDL = utenteDL;
        this.validatorBL = validatorBL;
    }

    @Override
    public List<UtenteBO> getAll() {
        List<UtenteBO> utenti = new ArrayList<>();
        for (UtenteDL utenteDL : utenteDL.getAll()) {
            UtenteBO utente = service.convertToUtenteBO(utenteDL);
            utenti.add(utente);
        }
        return utenti;
    }

    @Override
    public UtenteBO addUtente(UtenteBO utente) {
        UtenteDL utenteDataLayer = service.convertToUtenteDL(utente);
        if(validator(utente)) {
            UtenteBO utenteBO = service.convertToUtenteBO(utenteDL.addUtente(utenteDataLayer));
            return utenteBO;
        }
        else{
            return null;
        }
    }

    @Override
    public UtenteBO getUtenteByID(int id) {
        for (UtenteDL utenteDL : utenteDL.getAll()) {
            if (utenteDL.getId() == id) {
                UtenteBO utente = service.convertToUtenteBO(utenteDL);
                return utente;
            }
        }
        return null;
    }

    private boolean validator(UtenteBO utente) {
        return validatorBL.validate(utente);
    }

    @Override
    public String deleteUtente(int id) {
        String result = null;

        boolean deleted = utenteDL.deleteUtente(id);
        if (deleted) {
            result = "Eliminato";
        } else {
            result = "Non trovato";
        }
        return result;
    }
}
