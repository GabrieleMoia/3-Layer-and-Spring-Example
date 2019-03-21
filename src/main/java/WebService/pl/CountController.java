package WebService.pl;

import WebService.bl.count.countUtentiEnabled.CountBL;
import WebService.bl.count.countAppuntamenti.CountAppuntamentiBL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Named;

@Controller
@RequestMapping("/api/simple")
public class CountController {
    public final CountBL businessLayer;
    public final CountAppuntamentiBL businessLayerApp;

    public CountController(@Named("CountBL") CountBL businessLayer, @Named("CountAppuntamentiBL") CountAppuntamentiBL businessLayerApp) {
        this.businessLayer = businessLayer;
        this.businessLayerApp = businessLayerApp;
    }

    @RequestMapping(
            path = "/utente/countEnabled",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Count getEnable() {
        return new Count(businessLayer.countEnabled());
    }

    @RequestMapping(
            path = "/nappuntamenti/{idUtente}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Count getAppuntamentiPerUtente(@PathVariable("idUtente") int idUtente) throws Exception {
        return new Count(businessLayerApp.countAppuntamentiPerUtente(idUtente));
    }
}
