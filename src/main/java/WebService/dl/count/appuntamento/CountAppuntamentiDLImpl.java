package WebService.dl.count.appuntamento;

import WebService.dl.appuntamento.AppuntamentoDL;
import WebService.dl.appuntamento.IAppuntamentoDL;
import WebService.dl.count.appuntamento.CountAppuntamentiDL;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;

@Named("CountAppuntamentiDL")
public class CountAppuntamentiDLImpl implements CountAppuntamentiDL {

    private final IAppuntamentoDL appuntamentoDL;
    private List<AppuntamentoDL> appuntamentiDl;
    public CountAppuntamentiDLImpl(@Named("AppuntamentoDL") IAppuntamentoDL appuntamentoDL){
        this.appuntamentoDL=appuntamentoDL;
    }

    @Override
    public int getNAppuntamenti(int id) throws Exception {
        return appuntamentoDL.getAppuntamentiByIdUtente(id).size();
    }
}
