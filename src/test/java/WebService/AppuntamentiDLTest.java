package WebService;

import WebService.dl.appuntamento.AppuntamentoDL;
import WebService.dl.appuntamento.AppuntamentoDLImpl;
import WebService.dl.appuntamento.IAppuntamentoDL;
import WebService.dl.utente.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;
import java.util.List;
@RunWith(JUnit4.class)
public class AppuntamentiDLTest {

    private CountDL countDL= new CountDLImpl();
    private IUtenteDL utenteDL1 = new UtenteDLImpl(countDL);
    private AppuntamentoDLImpl appuntamentoDL1 = new AppuntamentoDLImpl(utenteDL1);

    /*@Test
    public void getApppuntamentiByUtente() throws Exception {
        UtenteDL utenteDL = new UtenteDL(1,"Gabriele", false);
        UtenteDL utenteDL2 = new UtenteDL(2,"Gabriele", false);
        AppuntamentoDL appuntamentoDL = new AppuntamentoDL(1,2,new Date(), new Date(), "Cisaone");
        AppuntamentoDL appuntamentoDL2 = new AppuntamentoDL(2,2,new Date(), new Date(), "Cisaone");

        utenteDL1.addUtente(utenteDL);
        utenteDL1.addUtente(utenteDL2);
        appuntamentoDL1.addAppuntamento(appuntamentoDL);
        appuntamentoDL1.addAppuntamento(appuntamentoDL2);

        List<AppuntamentoDL> appuntamenti =appuntamentoDL1.getAppuntamentiByIdUtente(2);

        for (AppuntamentoDL appuntamento: appuntamenti) {
            System.out.println(appuntamento.getId());
        }
    }

    @Test
    public void editAppuntamento() throws Exception {
        AppuntamentoDL appuntamentoDL2 = new AppuntamentoDL(2,2,new Date(), new Date(), "Cisaone");
        AppuntamentoDL appuntamentoDL3 = new AppuntamentoDL(2,4,new Date(), new Date(), "Cisaone");

        appuntamentoDL1.addAppuntamento(appuntamentoDL2);
        AppuntamentoDL appuntamentoDL= appuntamentoDL1.editAppuntamento(appuntamentoDL3);

        System.out.println(appuntamentoDL.getIdUtente());
    }*/
}
