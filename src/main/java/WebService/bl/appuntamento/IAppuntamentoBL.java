package WebService.bl.appuntamento;

import java.util.List;

public interface IAppuntamentoBL {

    List<AppuntamentoBO> getAll();
    AppuntamentoBO addAppuntamento(AppuntamentoBO appuntamentoBO);
    AppuntamentoBO getAppuntamentiByIdUtente(int idUtente);
    AppuntamentoBO editAppuntamento(int id);
    String deleteAppuntamento(int id);

}
