package WebService.pl;

import WebService.bl.UtenteBL;;
import WebService.bl.UtenteBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;

@Controller
@RequestMapping("/api/simple")
public class UtenteController {

    private final UtenteBL utenteBl;

    @Inject
    public UtenteController(@Named("utenteBL") UtenteBL utenteBl) {
        this.utenteBl = utenteBl;
    }

    @RequestMapping(
            path = "/utente",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public UtenteBO insertUtente(@RequestBody UtenteBO utente) {
       utente = utenteBl.insertUtente(utente);
       return utente;
    }

    @RequestMapping(
            path = "/utente/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public UtenteBO getUtente(@PathVariable("id") int id) {
        UtenteBO utente = utenteBl.getUtente(id);
        return  utente;
    }

    @RequestMapping(
            path = "/utente/{id}",
            method= RequestMethod.PUT,
            produces="application/json")
    @ResponseBody
    public Utente putUtente(@RequestBody Utente utente) {
        return utente;
    }

    @RequestMapping(
            path = "/utente/{id}",
            method = RequestMethod.DELETE,
            produces = "text/html")
    @ResponseBody
    public String deleteUtente(@PathVariable("id") int id) {
        return utenteBl.deleteUtente(id);
    }
}
