package WebService.dl.appuntamento;

public interface CountAppuntamentiDL {
    void incrementNAppuntamenti(int idUtente) throws Exception;
    void decrementNAppuntamenti(int idUtente);
    int getNAppuntamenti(int idUtente);
}
