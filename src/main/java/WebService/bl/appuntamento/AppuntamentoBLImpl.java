package WebService.bl.appuntamento;

import javax.inject.Named;
import java.util.List;

@Named("AppuntamentoBL")
public class AppuntamentoBLImpl implements IAppuntamentoBL {

    @Override
    public List<AppuntamentoBO> getAll() {
        return null;
    }

    @Override
    public AppuntamentoBO addAppuntamento(AppuntamentoBO appuntamentoBO) {
        return null;
    }

    @Override
    public AppuntamentoBO getAppuntamentiByIdUtente(int idUtente) {
        return null;
    }

    @Override
    public AppuntamentoBO editAppuntamento(int id) {
        return null;
    }

    @Override
    public String deleteAppuntamento(int id) {
        return null;
    }
}
