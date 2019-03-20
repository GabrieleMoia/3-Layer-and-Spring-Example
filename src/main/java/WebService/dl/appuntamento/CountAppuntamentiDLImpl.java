package WebService.dl.appuntamento;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Named("CountAppuntamentiDL")
public class CountAppuntamentiDLImpl implements CountAppuntamentiDL{

    HashMap<Integer, Integer> appuntamentiPerUtente = new HashMap<Integer, Integer>();

    private final IAppuntamentoDL appuntamentoDL;

    public CountAppuntamentiDLImpl(@Named("AppuntamentoDL") IAppuntamentoDL appuntamentoDL){
        this.appuntamentoDL=appuntamentoDL;
    }

    @Override
    public void incrementNAppuntamenti(int idUtente) throws Exception {
        List<AppuntamentoDL> appuntamenti= appuntamentoDL.getAppuntamentiByIdUtente(idUtente);

    }

    @Override
    public void decrementNAppuntamenti(int idUtente) {

    }

    @Override
    public int getNAppuntamenti(int idUtente) {
        return 0;
    }
}
