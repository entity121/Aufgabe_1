package aufgabe_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Logik_Ausgeben {
    
 
    Tools tool;
    Konsole_Log log;
    Datenverwaltung daten;
    Konsole_Ausgeben konAus = new Konsole_Ausgeben();
    Konsole_Eingeben konEin = new Konsole_Eingeben();
    String trennlinie = "\n\n####################################################################################\n\n";
    int aktuelle_seite;
    List<Mitarbeiter>L_ma;

    public Logik_Ausgeben(Datenverwaltung d){
        tool = new Tools();
        log = new Konsole_Log();
        daten = d;
        
        
        
    }
    //
    //
    //
    //############################
    public void Vorgang_Starten(){        
        
        
        if(daten.Liste_Ausgeben().size()>0){
            log.LogNachricht("Zugriff auf Mitarbeiter Datenbank");        
            Datensätze_Anzeigen(1);
        }
        else{
            log.LogNachricht("Die Mitarbeiterdatenbank ist leer");
        }
    }   
    //############################
    //
    //
    //
    //############################
    private void Datensätze_Anzeigen(int seite){
        
        aktuelle_seite=seite;
        
        System.out.println(trennlinie); 
        
        L_ma = daten.Liste_Ausgeben();
        

        int index = ((seite-1)*10);
        int max;
        if(index + 10 <= L_ma.size()){
            max = index+10;
        }
        else{
            max=L_ma.size();
        }

        for(int i=index;i<max;i++){

            String row = (i+1)+": "+L_ma.get(i).S_vorname+" "+L_ma.get(i).S_nachname+"\n";

            System.out.println(row);        
        }
     
        
        Optionsmenü();

    }
    //############################
    //
    //
    //
    //############################
    private void Optionsmenü(){
        
        
        int erg;
           
        do{
            System.out.println(trennlinie);
            erg = tool.Auswahl_Treffen("Was möchten Sie tun?", new String[]{"Eintrag anzeigen","Nächste Seite","Vorherige Seite","Zurück zum Hauptmenü"});
        
            switch(erg){
                case 1:
                    Eintrag_Anzeigen();
                    break;
                case 2:
                    Seite_Wechseln(1);
                    break;
                case 3:
                    Seite_Wechseln(-1);
                    break;
                case 4:
                    System.out.println(trennlinie);
                    log.LogNachricht("Zurück zum Hauptmenü");
        }       
        }
        while(erg!=4);   
    }
    //############################
    //
    //
    //
    //############################
    private void Seite_Wechseln(int i){
        
        if(i==1){
            
            int seite = aktuelle_seite+1;
            if((seite-1)*10<L_ma.size()){
                log.LogNachricht("Nächste Seite");
                Datensätze_Anzeigen(seite);
            }
            else{
                log.LogError("Keine weiteren Einträge vorhanden");
            }          
        }
        else{
            
            if(aktuelle_seite-1>=1){
                log.LogNachricht("Vorherige Seite");
                Datensätze_Anzeigen(aktuelle_seite-1);
            }
            else{
                log.LogError("Es gibt keine vorgehende Seite");
            }         
        }       
    }
    //############################
    //
    //
    //
    //############################
    private void Eintrag_Anzeigen(){
             
        int id = konEin.Eingabe_Int("\nGeben Sie die Nummer des Mitarbeiters an den Sie anzeigen möchten");
        
        if(id<=L_ma.size()){
            
            log.LogNachricht("Eintrag "+id+" gewählt");
            
            Mitarbeiter ma = L_ma.get(id-1);
        
            System.out.println(trennlinie);
            String anzeige = "";

            anzeige+= "(1) Vorname:\n   "+ma.S_vorname+"\n\n";
            anzeige+= "(2) Nachname:\n   "+ma.S_nachname+"\n\n";
            anzeige+= "(3) Geburtstag:\n   "+ma.geburtstag[0]+"."+ma.geburtstag[1]+"."+ma.geburtstag[2]+"\n\n";
            anzeige+= "(4) Geschlecht:\n   "+ma.S_geschlecht+"\n\n";
            anzeige+= "(5) Ausbildung:\n   ";        
            for(int i=0;i<ma.Ls_ausbildung.size();i++){
                anzeige+=ma.Ls_ausbildung.get(i)+"\n   ";
            }anzeige+="\n";
            anzeige+= "(6) Beruf:\n   "+ma.S_beruf+"\n\n";
            anzeige+= "(7) Position:\n   "+ma.S_position+"\n\n";
            anzeige+= "(8) Abteilung:\n   "+ma.S_abteilung+"\n\n";
            anzeige+= "(9) Sitzplatz:\n   "+ma.I_platz+"\n\n";
            anzeige+= "(10) Raum:\n   "+ma.I_raum+"\n\n";
            anzeige+= "(11) Gehalt:\n   "+ma.I_gehalt+"\n\n";
            anzeige+= "(12) Angestellt seit:\n   "+ma.einstellung[0]+"."+ma.einstellung[1]+"."+ma.einstellung[2]+"\n\n";
            anzeige+= "(13) E-Mail:\n   "+ma.S_email+"\n\n";
            anzeige+= "(14) Telefon:\n   "+ma.I_tel+"\n\n";
            anzeige+= "(15) Fähigkeiten:\n   ";        
            for(int i=0;i<ma.Lf_fähigkeiten.size();i++){
                anzeige+=ma.Lf_fähigkeiten.get(i).Fähigkeit+": "+ma.Lf_fähigkeiten.get(i).Bewertung+"/100\n";
            }anzeige+="\n";
            
            System.out.println(anzeige);
            
            Anzeigemenü(id-1);
        }
        else{
            log.LogError("Bitte existierenden Datensatz wählen");
        }     
    }
    //############################
    //
    //
    //
    //############################
    private void Anzeigemenü(int id){
        
        int erg;
           
        do{
            System.out.println(trennlinie);
            erg = tool.Auswahl_Treffen("Was möchten Sie tun?", new String[]{"Mitarbeiter bearbeiten","Mitarbeiter löschen","Zurück"});
        
            switch(erg){
                case 1:
                    //Bearbeiten();
                    break;
                case 2:
                    Löschen(id);
                    break;
                case 3:
                    System.out.println(trennlinie);
                    log.LogNachricht("Zurück");
        }       
        }
        while(erg!=3); 
    }
    //############################
    //
    //
    //
    //############################
    
    //############################
    //
    //
    //
    //############################
    private void Löschen(int id){
        
        if(tool.Ja_Nein("Sind Sie sicher, dass Sie "+L_ma.get(id).S_vorname+" "+L_ma.get(id).S_nachname+" löschen möchten?")){

            
            L_ma.remove(id);
            daten.Liste_Update();
            Datensätze_Anzeigen(1);
        }
        else{
            log.LogNachricht("Löschen abgebrochen");
        }
    
    }
    //############################
    //
    //
    //
    
    
}
