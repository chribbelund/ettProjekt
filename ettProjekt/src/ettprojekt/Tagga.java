package ettprojekt;

import static ettprojekt.EttProjekt.idb;
import java.util.ArrayList;
import javax.swing.JComboBox;
import oru.inf.InfException;

public class Tagga {

    public void cboxTagg(JComboBox cboxtagg) throws InfException {
        String fraga = "SELECT TAGG FROM TAGGAR";

        ArrayList<String> taggar = idb.fetchColumn(fraga);
        cboxtagg.removeAllItems();
        for (String currentTagg : taggar) {
            cboxtagg.addItem(currentTagg);
        }

    }

    public boolean harVarde(String tagg) throws InfException {
        boolean hittad = false;
        String svar = null;
        String namn = "SELECT TAGG FROM TAGGAR WHERE TAGG = '" + tagg + "';";
        svar = idb.fetchSingle(namn);
        if (svar == null) {
            String id = idb.getAutoIncrement("TAGGAR", "TAGG_ID");
            idb.insert("INSERT INTO TAGGAR VALUES('" + tagg + "', '" + id + "';)");
            hittad = true;
        }
        return hittad;
    }

    public void inlaggTagg(String id) throws InfException {
        String fraga = ("SELECT INLAGG_ID FROM INLAGG_TAGG WHERE TAGG_ID = '" + id + "';");
        ArrayList<String> inlagg = idb.fetchColumn(fraga);
        String fragan = "SELECT TEXT FROM INLAGG JOIN INLAGG_TAGG ON INLAGG.INLAGG_ID = INLAGG_TAGG.INLAGG_ID WHERE TAGG_ID = " + id + ";";
        ArrayList<String> texter = idb.fetchColumn(fragan);
        System.out.println(texter);

        fragan = "SELECT TITEL FROM INLAGG JOIN INLAGG_TAGG ON INLAGG.INLAGG_ID = INLAGG_TAGG.INLAGG_ID WHERE TAGG_ID = " + id + ";";
        ArrayList<String> titlar = idb.fetchColumn(fragan);
        System.out.println(titlar);
        for (String currentInlagg : inlagg) {

        }
    }

}
