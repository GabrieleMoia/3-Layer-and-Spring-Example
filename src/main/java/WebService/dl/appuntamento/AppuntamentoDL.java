package WebService.dl.appuntamento;

import java.util.Date;

public class AppuntamentoDL {

    private int id;
    private int idUtente;
    private Date dataInzio;
    private Date dataFine;
    private String descrizione;

    public AppuntamentoDL() {

    }

    public AppuntamentoDL(int id, int idUtente, Date dataInzio, Date dataFine, String descrizione) {
        this.id = id;
        this.idUtente = idUtente;
        this.dataInzio = dataInzio;
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

    public Date getDataInzio() {
        return dataInzio;
    }

    public void setDataInzio(Date dataInzio) {
        this.dataInzio = dataInzio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
