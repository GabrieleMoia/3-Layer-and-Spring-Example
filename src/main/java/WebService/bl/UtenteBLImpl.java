package WebService.bl;

import WebService.dl.CountDL;
import WebService.dl.IUtenteDL;
import WebService.dl.UtenteDL;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("utenteBL")
public class UtenteBLImpl implements IUtenteBL {

    private final IUtenteDL dataLayer;
    private final ValidatorBL validatorBL;
    private final CountDL countDL;
    private BLConverterService service = new BLConverterService();

    @Inject
    public UtenteBLImpl(@Named("utenteDL") IUtenteDL dataLayer, @Named("ValidatorNameContent") ValidatorBL validatorBL, @Named("CountDL") CountDL countDL) {
        this.dataLayer = dataLayer;
        this.validatorBL = validatorBL;
        this.countDL = countDL;
    }

    @Override
    public List<UtenteBO> getAll() {
        List<UtenteBO> utenti = new ArrayList<>();
        for (UtenteDL utenteDL : dataLayer.getAll()) {
            UtenteBO utente = service.convertToUtenteBO(utenteDL);
            utenti.add(utente);
        }
        return utenti;
    }

    @Override
    public UtenteBO addUtente(UtenteBO utente) throws Exception {
        UtenteDL utenteDL = service.convertToUtenteDL(utente);
        if (validator(utente)) {
            utente.setEnabled(false);
            UtenteBO utenteBO = service.convertToUtenteBO(dataLayer.addUtente(utenteDL));
            return utenteBO;
        } else {
            throw new Exception("Nome utente non valido");
        }
    }


    @Override
    public UtenteBO getUtenteByID(int id) throws Exception {
        for (UtenteDL utenteDL : dataLayer.getAll()) {
            if (utenteDL.getId() == id) {
                UtenteBO utente = service.convertToUtenteBO(utenteDL);
                return utente;
            }
        }
        throw new Exception("Utente non trovato");
    }

    private boolean validator(UtenteBO utente) {
        return validatorBL.validate(utente);
    }

    @Override
    public String deleteUtente(int id) {
        String result = null;

        boolean deleted = dataLayer.deleteUtente(id);
        if (deleted) {
            result = "Eliminato";
        } else {
            result = "Non trovato";
        }
        return result;
    }

    @Override
    public void abilitaUtente(int id) throws Exception {
        UtenteBO utenteBO = getUtenteByID(id);
        if (utenteBO == null) {
            throw new Exception("Utente non trovato");
        }
        utenteBO.setEnabled(true);
        UtenteDL utenteDL = service.convertToUtenteDL(utenteBO);
        dataLayer.update(utenteDL);
        countDL.incrementEnabled();
    }

    @Override
    public void disabilitaUtente(int id) throws Exception {
        UtenteBO utenteBO = getUtenteByID(id);
        if (utenteBO == null) {
            throw new Exception("Utente non trovato");
        }
        utenteBO.setEnabled(false);
        UtenteDL utenteDL = service.convertToUtenteDL(utenteBO);
        dataLayer.update(utenteDL);
        countDL.decrementEnabled();
    }

    @Override
    public int countEnabled() {
        return countDL.getEnabled();
    }
}
