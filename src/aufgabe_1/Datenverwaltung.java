package aufgabe_1;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;


public class Datenverwaltung {    
  
    private static String verzeichnis = "C:\\Users\\sebastian.heck\\Documents\\NetBeansProjects\\Aufgabe_1\\src\\aufgabe_1\\Datenbank.json";  
    private ArrayList<Mitarbeiter>laufzeit_datenbank = new ArrayList<>(); 
    Konsole_Log log = new Konsole_Log();

    
    //
    //
    //
    //########################################
    private void Datenbank_Update(){
        
        // Oberste Ebene
        JSONObject Jdatenbank = new JSONObject();
        
        // Für jeden Eintrag
        for(int i=1;i<=laufzeit_datenbank.size();i++){
            
            Mitarbeiter ma = laufzeit_datenbank.get(i-1);           
            JSONObject Jmitarbeiter = new JSONObject();
            
            //Name
            Jmitarbeiter.put("Vorname", ma.S_vorname);
            Jmitarbeiter.put("Nachname", ma.S_nachname);
            
            //Geburtstag
            JSONObject Jgeburtstag = new JSONObject();
                Jgeburtstag.put("Tag",ma.geburtstag[0]);
                Jgeburtstag.put("Monat",ma.geburtstag[1]);
                Jgeburtstag.put("Jahr",ma.geburtstag[2]);
            Jmitarbeiter.put("Geburtstag",Jgeburtstag);
            
            //Geschlecht
            Jmitarbeiter.put("Geschlecht", ma.S_geschlecht);
            
            //bisherige Ausbildungen
            JSONObject Jausbildung = new JSONObject();
                for(int j=1;j<=ma.Ls_ausbildung.size();j++){
                    Jausbildung.put(j+"", ma.Ls_ausbildung.get(j-1));
                }
            Jmitarbeiter.put("Ausbildung", Jausbildung);
            
            //Firma
            Jmitarbeiter.put("Beruf",ma.S_beruf);
            Jmitarbeiter.put("Position",ma.S_position);
            Jmitarbeiter.put("Abteilung",ma.S_abteilung);
            Jmitarbeiter.put("Raum",ma.I_raum);
            Jmitarbeiter.put("Sitzplatz",ma.I_platz);
            Jmitarbeiter.put("Gehalt",ma.I_gehalt);
            
            //Angestellt seit
            JSONObject Jeinstellung = new JSONObject();
                Jeinstellung.put("Tag",ma.einstellung[0]);
                Jeinstellung.put("Monat",ma.einstellung[1]);
                Jeinstellung.put("Jahr",ma.einstellung[2]);
            Jmitarbeiter.put("Einstellung",Jeinstellung);
            
            //Kontakt
            Jmitarbeiter.put("EMail",ma.S_email);
            Jmitarbeiter.put("Telefon",ma.I_tel);
            
            //Fähigkeiten
            JSONObject Jfähigkeiten = new JSONObject();
                for(int j=1;j<=ma.Lf_fähigkeiten.size();j++){
                    JSONObject Jf = new JSONObject();
                        Jf.put("Fähigkeit", ma.Lf_fähigkeiten.get(j-1).Fähigkeit);
                        Jf.put("Bewertung", ma.Lf_fähigkeiten.get(j-1).Bewertung);
                    Jfähigkeiten.put(j+"", Jf);
                }
            Jmitarbeiter.put("Fähigkeiten",Jfähigkeiten);
            
            Jdatenbank.put(i+"", Jmitarbeiter);
            
        }
        
        //###########
        try{        
            FileWriter file = new FileWriter(verzeichnis);
            file.write(Jdatenbank.toString(3));
            file.close();
            log.LogNachricht("Speichern erfolgreich");
        }
        catch(Exception e){
            log.LogError("Fehler\n"+e);
        }     
    }
    //########################################
    //
    //
    //
    //########################################
    public void Mitarbeiter_Hinzufügen(Mitarbeiter ma){
        
        laufzeit_datenbank.add(ma);
        Datenbank_Update();
    }
    //########################################
    //
    //
    //
    //########################################
    public List<Mitarbeiter> Liste_Ausgeben(){
        
        return null;
    }
    //########################################
    //
    //
    //
    //########################################
    public List<Mitarbeiter> Name_Suchen(String name){
        
        return null;
    }
    //########################################
    //
    //
    //
    
}
