package WebService.bl.validator.appuntamento;

import WebService.bl.appuntamento.AppuntamentoBLConverterService;
import WebService.bl.appuntamento.AppuntamentoBO;
import WebService.bl.appuntamento.IAppuntamentoBL;
import WebService.dl.appuntamento.AppuntamentoDL;
import WebService.dl.appuntamento.IAppuntamentoDL;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("ValidatorConcomitance")
public class ValidatorConcomitance implements AppuntamentoValidatorBL {

    private final AppuntamentoValidatorBL validatorBL;
    private final IAppuntamentoDL dataLayer;

    AppuntamentoBLConverterService service = new AppuntamentoBLConverterService();

    public ValidatorConcomitance(@Named("AppuntamentoDL") IAppuntamentoDL dataLayer, @Named("AppuntamentoFinalValidator") AppuntamentoValidatorBL validatorBL) {
        this.validatorBL = validatorBL;
        this.dataLayer = dataLayer;
    }

    @Override
    public boolean validate(AppuntamentoBO appuntamentoBO) throws Exception {
        AppuntamentoDL appuntamentoDL = service.convertToAppuntamentoDL(appuntamentoBO);
        List<AppuntamentoDL> appuntamentiDL = dataLayer.getAppuntamentiByIdUtente(appuntamentoDL.getIdUtente());
        List<String> date = getDates(appuntamentoDL);
        if (!date.isEmpty() && validatorBL.validate(appuntamentoBO)) {
            for (AppuntamentoDL appuntamento : appuntamentiDL) {
                for (String data : date) {
                    if (data.equals(appuntamento.getDataInizio()) || data.equals(appuntamento.getDataFine())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private List<String> getDates(AppuntamentoDL appuntamentoDL) {
        List<String> date = new ArrayList<>();
        date.add(appuntamentoDL.getDataFine());
        date.add(appuntamentoDL.getDataInizio());
        return date;
    }
}
