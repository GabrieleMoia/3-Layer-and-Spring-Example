package WebService.bl.appuntamento;

import java.util.List;

public interface IAppuntamentoBL {

    List<AppuntamentoBO> getAll() throws Exception;
    AppuntamentoBO addAppuntamento(AppuntamentoBO appuntamentoBO) throws Exception;
    List<AppuntamentoBO> getAppuntamentiByIdUtente(int idUtente) throws Exception;
    AppuntamentoBO editAppuntamento(int id) throws Exception;
    String deleteAppuntamento(int id) throws Exception;

}
