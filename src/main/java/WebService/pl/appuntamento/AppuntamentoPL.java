package WebService.pl.appuntamento;

import java.util.Date;

public class AppuntamentoPL {
    private int id;
    private int idUtente;
    private String dataInizio;
    private String dataFine;
    private String descrizione;

    public AppuntamentoPL() {

    }

    public AppuntamentoPL(int id, int idUtente, String dataInizio, String dataFine, String descrizione) {
        this.id = id;
        this.idUtente = idUtente;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.descrizione = descrizione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInzio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
