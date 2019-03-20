package WebService.dl.utente;

import WebService.pl.utente.Utente;

import javax.persistence.*;

@Entity
@Table(name ="utente")
public class UtenteDL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "enabled")
    private boolean enabled;

    /*@OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name="idUtente")
    private List<AppuntamentoDL> appuntamentiDL = new ArrayList<>();*/
    public UtenteDL(){

    }
    public UtenteDL(int id, String nome, boolean enabled) {
        this.id = id;
        this.nome = nome;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
