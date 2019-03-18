package WebService.bl.validator.appuntamento;

import WebService.bl.appuntamento.AppuntamentoBO;
import WebService.bl.appuntamento.IAppuntamentoBL;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("ValidatorConcomitance")
public class ValidatorConcomitance implements AppuntamentoValidatorBL {

    private final AppuntamentoValidatorBL validatorBL;
    private final IAppuntamentoBL appuntamentoBL;

    public ValidatorConcomitance(@Named("AppuntamentoBL") IAppuntamentoBL appuntamentoBL, @Named("AppuntamentoFinalValidator") AppuntamentoValidatorBL validatorBL) {
        this.validatorBL = validatorBL;
        this.appuntamentoBL = appuntamentoBL;
    }

    @Override
    public boolean validate(AppuntamentoBO appuntamentoBO) throws Exception {
        List<AppuntamentoBO> appuntamentiBO = appuntamentoBL.getAppuntamentiByIdUtente(appuntamentoBO.getIdUtente());
        List<String> date = getDates(appuntamentiBO);
        if (!date.isEmpty() && validatorBL.validate(appuntamentoBO)) {
            for (AppuntamentoBO appuntamento : appuntamentiBO) {
                for (String data : date) {
                    if (data.equals(appuntamento.getDataInizio()) || data.equals(appuntamento.getDataFine())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private List<String> getDates(List<AppuntamentoBO> appuntamentiBO) {
        List<String> date = new ArrayList<>();
        if (!appuntamentiBO.isEmpty()) {
            for (AppuntamentoBO appuntamento : appuntamentiBO) {
                date.add(appuntamento.getDataFine());
                date.add(appuntamento.getDataInizio());
            }
        }
        return date;
    }
}
