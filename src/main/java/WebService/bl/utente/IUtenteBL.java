package WebService.bl.utente;

import java.util.List;

public interface IUtenteBL {
    List<UtenteBO> getAll();
    UtenteBO addUtente(UtenteBO utente) throws Exception;
    UtenteBO getUtenteByID(int id) throws Exception;
    String deleteUtente(int id);
    void abilitaUtente(int id) throws Exception;
    void disabilitaUtente(int idUtente) throws Exception;
}
