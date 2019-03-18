package WebService.bl.appuntamento;

import WebService.bl.validator.appuntamento.AppuntamentoValidatorBL;
import WebService.dl.appuntamento.AppuntamentoDL;
import WebService.dl.appuntamento.IAppuntamentoDL;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("AppuntamentoBL")
public class AppuntamentoBLImpl implements IAppuntamentoBL {

    private final IAppuntamentoDL dataLayer;
    AppuntamentoBLConverterService service = new AppuntamentoBLConverterService();
    private final AppuntamentoValidatorBL validatorBL;


    public AppuntamentoBLImpl(@Named("AppuntamentoDL") IAppuntamentoDL dataLayer, @Named("ValidatorUserExist") AppuntamentoValidatorBL validatorBL) {
        this.dataLayer = dataLayer;
        this.validatorBL = validatorBL;
    }

    @Override
    public List<AppuntamentoBO> getAll() throws Exception {
        List<AppuntamentoBO> appuntamenti = new ArrayList<>();
        for (AppuntamentoDL appuntamentoDL : dataLayer.getAll()) {
            AppuntamentoBO appuntamentoBO = service.convertToAppuntamentoBO(appuntamentoDL);
            appuntamenti.add(appuntamentoBO);
        }
        return appuntamenti;
    }

    @Override
    public AppuntamentoBO addAppuntamento(AppuntamentoBO appuntamentoBO) throws Exception {
        AppuntamentoDL appuntamentoDL = service.convertToAppuntamentoDL(appuntamentoBO);
        if (validator(appuntamentoBO) && checkConcomitance(appuntamentoBO)) {
            dataLayer.addAppuntamento(appuntamentoDL);
            return appuntamentoBO;
        } else {
            throw new Exception("Utente non esistente o orario già occupato da appuntamento");
        }
    }

    @Override
    public List<AppuntamentoBO> getAppuntamentiByIdUtente(int idUtente) throws Exception {
        List<AppuntamentoDL> appuntamentiDL = dataLayer.getAppuntamentiByIdUtente(idUtente);
        List<AppuntamentoBO> appuntamentiBO = new ArrayList<>();
        for (AppuntamentoDL appuntamentoDL : appuntamentiDL) {
            AppuntamentoBO appuntamentoBO = service.convertToAppuntamentoBO(appuntamentoDL);
            appuntamentiBO.add(appuntamentoBO);
        }
        return appuntamentiBO;
    }

    @Override
    public AppuntamentoBO editAppuntamento(int id) throws Exception {
        for (AppuntamentoBO appuntamentoBO : getAll()) {
            if (appuntamentoBO.getId() == id) {
                AppuntamentoDL appuntamentoDL = service.convertToAppuntamentoDL(appuntamentoBO);
                AppuntamentoDL appuntamentoEdited = dataLayer.editAppuntamento(appuntamentoDL);
                AppuntamentoBO appuntamento = service.convertToAppuntamentoBO(appuntamentoEdited);
                return appuntamento;
            }
        }
        throw new Exception("Nessun utente trovato");
    }

    @Override
    public String deleteAppuntamento(int id) throws Exception {
        String result = null;

        boolean deleted = dataLayer.deleteAppuntamento(id);
        result = deleted ? "Eliminato" : "Non trovato";
        return result;
    }

    private boolean checkConcomitance(AppuntamentoBO appuntamentoBO) throws Exception {
        List<AppuntamentoBO> appuntamentiBO = getAppuntamentiByIdUtente(appuntamentoBO.getIdUtente());
        List<String> date = getDates(appuntamentoBO);
        if (!appuntamentiBO.isEmpty()) {
            if (!date.isEmpty()) {
                for (AppuntamentoBO appuntamento : appuntamentiBO) {
                    for (String data : date) {
                        if (data.equals(appuntamento.getDataInizio()) || data.equals(appuntamento.getDataFine())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private List<String> getDates(AppuntamentoBO appuntamentoBO) {
        List<String> date = new ArrayList<>();
        date.add(appuntamentoBO.getDataFine());
        date.add(appuntamentoBO.getDataInizio());
        return date;
    }

    private boolean validator(AppuntamentoBO appuntamentoBO) throws Exception {
        return validatorBL.validate(appuntamentoBO);
    }
}
