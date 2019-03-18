package WebService.bl.validator.appuntamento;

import WebService.bl.appuntamento.AppuntamentoBO;

import javax.inject.Named;

@Named("AppuntamentoFinalValidator")
public class FinalValidator implements AppuntamentoValidatorBL{
    @Override
    public boolean validate(AppuntamentoBO appuntamentoBO) throws Exception {
        return true;
    }
}
