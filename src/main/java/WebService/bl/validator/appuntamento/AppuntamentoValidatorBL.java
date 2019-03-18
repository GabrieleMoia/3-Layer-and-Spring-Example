package WebService.bl.validator.appuntamento;

import WebService.bl.appuntamento.AppuntamentoBO;
import WebService.bl.appuntamento.IAppuntamentoBL;

public interface AppuntamentoValidatorBL {
    boolean validate(AppuntamentoBO appuntamentoBO) throws Exception;
}
