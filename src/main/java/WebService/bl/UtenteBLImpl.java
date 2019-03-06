package WebService.bl;

import WebService.pl.Utente;

import javax.inject.Named;

@Named("utenteBL")
public class UtenteBLImpl implements UtenteBL {

    @Override
    public UtenteBO insertUtente(UtenteBO utente) {
        return utente;
    }

    @Override
    public UtenteBO getUtente(int id) {
        UtenteBO utente = new UtenteBO();
        utente.setId(id);
        utente.setNome("Gabriele");
        return utente;
    }

    @Override
    public String deleteUtente(int id) {
        return "delete utente" + id;
    }
}
