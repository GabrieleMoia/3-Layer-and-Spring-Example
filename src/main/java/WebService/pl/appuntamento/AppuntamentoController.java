package WebService.pl.appuntamento;

import WebService.bl.appuntamento.AppuntamentoBO;
import WebService.bl.appuntamento.IAppuntamentoBL;

import WebService.pl.validator.ValidatorPL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/simple")
public class AppuntamentoController {
    private final IAppuntamentoBL businessLayer;
    private final ValidatorPL validatorPL;
    AppuntamentoPLConverterService service = new AppuntamentoPLConverterService();

    @Inject
    public AppuntamentoController(@Named("AppuntamentoBL") IAppuntamentoBL businessLayer, @Named("plValidator") ValidatorPL validatorPL) {
        this.businessLayer = businessLayer;
        this.validatorPL = validatorPL;
    }

    @RequestMapping(
            path = "/appuntamento",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<AppuntamentoPL> getAll() throws Exception {
        List<AppuntamentoPL> appuntamenti = new ArrayList<>();
        for (AppuntamentoBO appuntamentoBO : businessLayer.getAll()) {
            AppuntamentoPL appuntamentoPL = service.convertToAppuntamentoPL(appuntamentoBO);
            appuntamenti.add(appuntamentoPL);
        }
        return appuntamenti;
    }

    @RequestMapping(
            path = "/appuntamento",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public String addAppuntamento(@RequestBody AppuntamentoPL appuntamentoPL) throws Exception {
        AppuntamentoBO appuntamentoBO = service.convertToAppuntamentoBO(appuntamentoPL);
        if (!validatorPL.validateDateFormat(appuntamentoBO.getDataInizio()) && validatorPL.validateDateFormat(appuntamentoBO.getDataFine())) {
            throw new Exception("Date format not valid -- yyyy-MM-dd HH:mm:ss");
        }
        businessLayer.addAppuntamento(appuntamentoBO);
        return businessLayer.getMessage();
    }

    @RequestMapping(
            path = "/appuntamento/{idUtente}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<AppuntamentoPL> getAppuntamentiByIdUtente(@PathVariable("idUtente") int idUtente) throws Exception {
        List<AppuntamentoBO> appuntamentiBO = businessLayer.getAppuntamentiByIdUtente(idUtente);
        List<AppuntamentoPL> appuntamentiPL = new ArrayList<>();
        for (AppuntamentoBO appuntamentoBO : appuntamentiBO) {
            appuntamentiPL.add(service.convertToAppuntamentoPL(appuntamentoBO));
        }
        return appuntamentiPL;
    }

    @RequestMapping(
            path = "/appuntamento/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @ResponseBody
    public String deleteAppuntamento(@PathVariable("id") int id) throws Exception {
        businessLayer.deleteAppuntamento(id);
        return businessLayer.getMessage();
    }
}
