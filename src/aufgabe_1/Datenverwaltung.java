package aufgabe_1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;


public class Datenverwaltung {    
  
    private static String verzeichnis = "Datenbank.json";  
    private ArrayList<Mitarbeiter>laufzeit_datenbank; 
    Konsole_Log log = new Konsole_Log();

    
    public Datenverwaltung(){
        this.laufzeit_datenbank = Datenbank_Laden();
    }
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
    public ArrayList<Mitarbeiter> Datenbank_Laden(){
        
        File datei = new File(verzeichnis);
        String inhalt = "";
        ArrayList <Mitarbeiter> L_mitarbeiter = new ArrayList<>();
        
        //###########
        try{
            FileReader reader = new FileReader(datei);
            
            int ascii = reader.read();
            while(ascii!=-1){
                inhalt+=(char)ascii;
                ascii = reader.read();
            }
        }
        catch(Exception e){
            log.LogError("Fehler:\n"+e);
        }
        //###########
        
        
        //###########
        int ID = 1;
        JSONObject datenbank = new JSONObject(inhalt);
        
        do{
            
            if(datenbank.has(ID+"")){
                
                Mitarbeiter ma = new Mitarbeiter();
                JSONObject Jmitarbeiter = datenbank.getJSONObject(ID+"");
                
                
                ma.S_vorname = Jmitarbeiter.get("Vorname").toString();
                ma.S_nachname = Jmitarbeiter.get("Nachname").toString();
                
                JSONObject Jgeburtstag = Jmitarbeiter.getJSONObject("Geburtstag");
                ma.geburtstag[0] = Jgeburtstag.getInt("Tag");
                ma.geburtstag[1] = Jgeburtstag.getInt("Monat");
                ma.geburtstag[2] = Jgeburtstag.getInt("Jahr");
                
                ma.S_geschlecht = Jmitarbeiter.getString("Geschlecht");
                
                JSONObject Jausbildung = Jmitarbeiter.getJSONObject("Ausbildung");
                int index = 1;
                do{
                    if(Jausbildung.has(index+"")){
                        ma.Ls_ausbildung.add(Jausbildung.get(index+"").toString());
                        index+=1;
                    }
                    else{
                        index=0;
                    }
                }
                while(index>0);
                
                ma.S_beruf = Jmitarbeiter.get("Beruf").toString();
                ma.S_position = Jmitarbeiter.get("Position").toString();
                ma.S_abteilung = Jmitarbeiter.get("Abteilung").toString();

                ma.I_platz = Jmitarbeiter.getInt("Sitzplatz");
                ma.I_raum = Jmitarbeiter.getInt("Raum");
                ma.I_gehalt = Jmitarbeiter.getInt("Gehalt");
                
                JSONObject Jeinstellung = Jmitarbeiter.getJSONObject("Einstellung");
                ma.einstellung[0] = Jeinstellung.getInt("Tag");
                ma.einstellung[1] = Jeinstellung.getInt("Monat");
                ma.einstellung[2] = Jeinstellung.getInt("Jahr");
                
                ma.S_email = Jmitarbeiter.get("EMail").toString();
                ma.I_tel = Jmitarbeiter.getInt("Telefon");
                        
                JSONObject Jfähigkeiten = Jmitarbeiter.getJSONObject("Fähigkeiten");
                index = 1;
                do{
                    if(Jfähigkeiten.has(index+"")){
                        
                        JSONObject fäh = Jfähigkeiten.getJSONObject(index+"");
                        Fähigkeit f = new Fähigkeit(fäh.get("Fähigkeit").toString(),fäh.getInt("Bewertung"));
                        ma.Lf_fähigkeiten.add(f);

                        index+=1;
                    }
                    else{
                        index=0;
                    }
                }
                while(index>0);
                
                L_mitarbeiter.add(ma);
                        
               ID+=1; 
            }
            else{
                ID=0;
            }
        }
        while(ID>0);
        
        return L_mitarbeiter;
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
    public ArrayList<Mitarbeiter> Liste_Ausgeben(){
        
        return laufzeit_datenbank;
    }
    //########################################
    //
    //
    //
    //########################################
    public void Liste_Update(){
        
        Datenbank_Update();
    }
    //########################################
    //
    //
    //
    
}
