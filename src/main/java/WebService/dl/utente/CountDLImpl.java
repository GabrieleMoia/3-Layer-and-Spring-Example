package WebService.dl.utente;

import javax.inject.Named;

@Named("CountDL")
public class CountDLImpl implements CountDL {
    int enabled = 0;

    @Override
    public void incrementEnabled() {
        enabled++;
    }

    @Override
    public void decrementEnabled() {
        enabled--;
    }

    @Override
    public int getEnabled() {
        return enabled;
    }
}
