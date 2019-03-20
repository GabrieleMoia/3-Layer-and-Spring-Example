package WebService.bl.validator.appuntamento;

import WebService.bl.appuntamento.AppuntamentoBO;
import WebService.bl.utente.IUtenteBL;
import WebService.bl.utente.UtenteBO;
import WebService.dl.utente.IUtenteDL;
import WebService.dl.utente.UtenteDL;

import javax.inject.Named;

@Named("ValidatorUserExist")
public class ValidatorUserExist implements AppuntamentoValidatorBL {

    private final IUtenteDL dataLayer;
    private final AppuntamentoValidatorBL validatorBL;

    public ValidatorUserExist(@Named("utenteDL") IUtenteDL dataLayer, @Named("ValidatorConcomitance") AppuntamentoValidatorBL validatorBL) {
        this.dataLayer = dataLayer;
        this.validatorBL = validatorBL;
    }

    @Override
    public boolean validate(AppuntamentoBO appuntamentoBO) throws Exception {
        if (validatorBL.validate(appuntamentoBO)) {
            for (UtenteDL utenteDL : dataLayer.getAll()) {
                if (appuntamentoBO.getIdUtente() == utenteDL.getId()) {
                    return true;
                }
            }
        }
        return false;
    }
}
