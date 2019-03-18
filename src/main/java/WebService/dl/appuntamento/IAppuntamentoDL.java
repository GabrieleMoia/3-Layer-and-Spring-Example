package WebService.dl.appuntamento;

import java.util.List;

public interface IAppuntamentoDL {
    List<AppuntamentoDL> getAll();
    AppuntamentoDL addAppuntamento(AppuntamentoDL appuntamentoDL);
    List<AppuntamentoDL> getAppuntamentiByIdUtente(int idUtente) throws Exception;
    AppuntamentoDL editAppuntamento(AppuntamentoDL appuntamentoDL) throws Exception;
    boolean deleteAppuntamento(int id) throws Exception;
}
