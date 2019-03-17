package WebService.dl.utente;

public class UtenteDL {

    private int id;
    private String nome;
    private boolean enabled;

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
