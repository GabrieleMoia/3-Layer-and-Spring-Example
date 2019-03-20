package WebService.dl.appuntamento;

import javax.inject.Named;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appuntamento")
public class AppuntamentoDL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idUtente")
    private int idUtente;

    @Column(name = "dataInizio")
    private String dataInizio;

    @Column(name = "dataFine")
    private String dataFine;

    @Column(name = "descrizione")
    private String descrizione;

    public AppuntamentoDL() {

    }

    public AppuntamentoDL(int id, int idUtente, String dataInizio, String dataFine, String descrizione) {
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
