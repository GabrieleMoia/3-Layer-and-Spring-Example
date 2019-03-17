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

    public AppuntamentoDLImpl(@Named("UtenteDL") IUtenteDL utenteDL){
        this.utenteDL=utenteDL;
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
    public List<AppuntamentoDL> getAppuntamentiByIdUtente(int idUtente) {

        List<UtenteDL> utenti = utenteDL.getAll();
        return null;
    }

    @Override
    public void editAppuntamento(AppuntamentoDL appuntamentoDL) throws Exception {
        if (!appuntamenti.containsKey(appuntamentoDL.getId())) {
            throw new Exception("Appuntamento non trovato");
        }
        appuntamenti.put(appuntamentoDL.getId(), appuntamentoDL);
    }

    @Override
    public boolean deleteAppuntamento(int id) throws Exception {
        if (!appuntamenti.containsKey(id)) {
            return false;
        }
        appuntamenti.remove(id);
        return true;
    }
}
