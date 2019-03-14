package WebService.pl;

import WebService.bl.IUtenteBL;;
import WebService.bl.UtenteBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/simple")
public class UtenteController {

    private final IUtenteBL businessLayer;
    private final ValidatorPL validatorPL;
    private PLConverterService service = new PLConverterService();

    @Inject
    public UtenteController(@Named("utenteBL") IUtenteBL businessLayer, @Named("plValidator") ValidatorPL validatorPL) {
        this.businessLayer = businessLayer;
        this.validatorPL = validatorPL;
    }

    @RequestMapping(
            path = "/utente",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<Utente> getAll() {
        List<Utente> utenti = new ArrayList<>();
        for (UtenteBO utenteBO : businessLayer.getAll()) {
            Utente utente = service.convertToUtente(utenteBO);
            utenti.add(utente);
        }
        return utenti;
    }

    @RequestMapping(
            path = "/utente",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public String addUtente(@RequestBody Utente utente) throws Exception {
        UtenteBO utenteBO = service.convertToUtenteBO(utente);
        if ((validatorPL.validateNameLength(utente))) {
            UtenteBO newUtente = businessLayer.addUtente(utenteBO);
            Utente result = service.convertToUtente(newUtente);
            return String.valueOf(result.getId());
        }else{
            return "Nome utente non valido. Il nome deve contenere almeno 3 caratteri e non deve contenere la parola 'test'";
        }
    }


    @RequestMapping(
            path = "/enable/{id}",
            method= RequestMethod.PUT,
            produces="application/json")
    @ResponseBody
    public void enableUtente (@PathVariable("id") int idUtente) throws Exception {
        businessLayer.abilitaUtente(idUtente);
    }

    @RequestMapping(
            path = "/disable/{id}",
            method= RequestMethod.PUT,
            produces="application/json")
    @ResponseBody
    public void disableUtente (@PathVariable("id") int idUtente) throws Exception {
        businessLayer.disabilitaUtente(idUtente);
    }

    @RequestMapping(
            path = "/utente/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Utente getUtente(@PathVariable("id") int id) throws Exception {
        UtenteBO utenteBO = businessLayer.getUtenteByID(id);
        Utente utente = service.convertToUtente(utenteBO);
        return utente;
    }

    @RequestMapping(
            path = "/countEnabled",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Count getEnable() {
        return new Count(businessLayer.countEnabled());
    }

    @RequestMapping(
            path = "/utente/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @ResponseBody
    public String deleteUtente(@PathVariable("id") int id) {
        System.out.println(id);
        String result = businessLayer.deleteUtente(id);
        return result;
    }
}
