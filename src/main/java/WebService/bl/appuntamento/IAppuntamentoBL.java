package WebService.bl.appuntamento;

import WebService.bus.MessageConsumer;

import java.util.List;

public interface IAppuntamentoBL{

    List<AppuntamentoBO> getAll() throws Exception;
    void addAppuntamento(AppuntamentoBO appuntamentoBO) throws Exception;
    List<AppuntamentoBO> getAppuntamentiByIdUtente(int idUtente) throws Exception;
    AppuntamentoBO editAppuntamento(int id) throws Exception;
    void deleteAppuntamento(int id) throws Exception;
    String getMessage();
}
