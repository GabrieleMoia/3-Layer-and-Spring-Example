package WebService.bl.validator.appuntamento;

import WebService.bl.appuntamento.AppuntamentoBO;
import WebService.bl.utente.IUtenteBL;
import WebService.bl.utente.UtenteBO;

import javax.inject.Named;

@Named("ValidatorUserExist")
public class ValidatorUserExist implements AppuntamentoValidatorBL {

    private final IUtenteBL businessLayer;
    private final AppuntamentoValidatorBL validatorBL;

    public ValidatorUserExist(@Named("utenteBL") IUtenteBL businessLayer, @Named("AppuntamentoFinalValidator") AppuntamentoValidatorBL validatorBL) {
        this.businessLayer = businessLayer;
        this.validatorBL = validatorBL;
    }

    @Override
    public boolean validate(AppuntamentoBO appuntamentoBO) throws Exception {
        if (validatorBL.validate(appuntamentoBO)) {
            for (UtenteBO utenteBO : businessLayer.getAll()) {
                if (appuntamentoBO.getIdUtente() == utenteBO.getId()) {
                    return true;
                }
            }
        }
        return false;
    }
}
