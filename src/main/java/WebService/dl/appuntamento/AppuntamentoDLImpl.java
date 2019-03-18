package WebService.dl.appuntamento;

import WebService.dl.utente.IUtenteDL;
import WebService.dl.utente.UtenteDL;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Named("AppuntamentoDL")
public class AppuntamentoDLImpl implements IAppuntamentoDL {

    private final IUtenteDL utenteDL;
    private HashMap<Integer, AppuntamentoDL> appuntamenti = new HashMap<Integer, AppuntamentoDL>();
    String message;

    public AppuntamentoDLImpl(@Named("utenteDL") IUtenteDL utenteDL) {
        this.utenteDL = utenteDL;
    }

    @Override
    public List<AppuntamentoDL> getAll() {
        return new ArrayList<AppuntamentoDL>(appuntamenti.values());
    }

    @Override
    public AppuntamentoDL addAppuntamento(AppuntamentoDL appuntamentoDL) {
        appuntamenti.put(appuntamentoDL.getId(), appuntamentoDL);
        return appuntamentoDL;
    }

    @Override
    public List<AppuntamentoDL> getAppuntamentiByIdUtente(int idUtente) throws Exception {
        List<AppuntamentoDL> appuntamenti = getAll();
        List<UtenteDL> utenti = utenteDL.getAll();

        List<AppuntamentoDL> appuntamentiByUtente = new ArrayList<>();

        for (AppuntamentoDL appuntamento : appuntamenti) {
            if (appuntamento.getIdUtente() == idUtente) {
                appuntamentiByUtente.add(appuntamento);
            }
        }
        return appuntamentiByUtente;
    }

    @Override
    public AppuntamentoDL editAppuntamento(AppuntamentoDL appuntamentoDL) throws Exception {
        if (!appuntamenti.containsKey(appuntamentoDL.getId())) {
            throw new Exception("Appuntamento non trovato");
        }
        appuntamenti.put(appuntamentoDL.getId(), appuntamentoDL);
        return appuntamentoDL;
    }

    @Override
    public boolean deleteAppuntamento(int id) throws Exception {
        if (!appuntamenti.containsKey(id)) {
            return false;
        }
        appuntamenti.remove(id);
        return true;
    }

    @Override
    public void writeMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
