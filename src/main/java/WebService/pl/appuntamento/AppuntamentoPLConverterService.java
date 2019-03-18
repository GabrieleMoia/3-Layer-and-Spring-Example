package WebService.pl.appuntamento;

import WebService.bl.appuntamento.AppuntamentoBO;

public class AppuntamentoPLConverterService {

    public AppuntamentoBO convertToAppuntamentoBO(AppuntamentoPL appuntamentoPL) {
        AppuntamentoBO appuntamentoBO = new AppuntamentoBO(appuntamentoPL.getId(), appuntamentoPL.getIdUtente(), appuntamentoPL.getDataInizio(), appuntamentoPL.getDataFine(), appuntamentoPL.getDescrizione());
        return appuntamentoBO;
    }

    public AppuntamentoPL convertToAppuntamentoPL(AppuntamentoBO appuntamentoBO) {
        AppuntamentoPL appuntamentoPL = new AppuntamentoPL(appuntamentoBO.getId(), appuntamentoBO.getIdUtente(), appuntamentoBO.getDataInizio(), appuntamentoBO.getDataFine(), appuntamentoBO.getDescrizione());
        return appuntamentoPL;
    }
}
