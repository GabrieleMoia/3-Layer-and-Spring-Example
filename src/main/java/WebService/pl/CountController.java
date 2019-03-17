package WebService.pl;

import WebService.bl.utente.CountBL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Named;

@Controller
@RequestMapping("/api/simple")
public class CountController {
    public final CountBL businessLayer;

    public CountController(@Named("CountBL") CountBL businessLayer) {
        this.businessLayer = businessLayer;
    }

    @RequestMapping(
            path = "/utente/countEnabled",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Count getEnable() {
        return new Count(businessLayer.countEnabled());
    }
}
