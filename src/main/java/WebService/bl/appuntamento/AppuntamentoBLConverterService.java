package WebService.bl.appuntamento;

import WebService.dl.appuntamento.AppuntamentoDL;

public class AppuntamentoBLConverterService {

    public AppuntamentoBO convertToAppuntamentoBO(AppuntamentoDL appuntamentoDL){
        AppuntamentoBO appuntamentoBO = new AppuntamentoBO(appuntamentoDL.getId(),appuntamentoDL.getIdUtente(), appuntamentoDL.getDataInizio(), appuntamentoDL.getDataFine(), appuntamentoDL.getDescrizione());
        return appuntamentoBO;
    }

    public AppuntamentoDL convertToAppuntamentoDL(AppuntamentoBO appuntamentoBO){
        AppuntamentoDL appuntamentoDL = new AppuntamentoDL(appuntamentoBO.getId(), appuntamentoBO.getIdUtente(), appuntamentoBO.getDataInizio(), appuntamentoBO.getDataFine(), appuntamentoBO.getDescrizione());
        return appuntamentoDL;
    }
}
