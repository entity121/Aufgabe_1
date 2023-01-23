package aufgabe_1;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Logik_Ausgeben {
    
 
    Tools tool;
    Konsole_Log log;
    String[]Menüoptionen;
    Datenverwaltung daten;
    Konsole_Ausgeben konAus = new Konsole_Ausgeben();
    Konsole_Eingeben konEin = new Konsole_Eingeben();

    public Logik_Ausgeben(Datenverwaltung d){
        tool = new Tools();
        log = new Konsole_Log();
        Menüoptionen = new String[]{"Alles Ausgeben","Nach Name Suchen"};
        daten = d;
    }
    //
    //
    //
    //############################
    public void Vorgang_Starten(){        
        
        log.LogNachricht("Zugriff auf Mitarbeiter Datenbank");
        
        int auswahl = tool.Auswahl_Treffen("Was möchten Sie tun?", Menüoptionen);   
        
        switch(auswahl){
            case 1:
                Alles_Suchen();
                break;
            case 2:
                //Name_Suchen();
                break;
        }
        
    }   
    //############################
    //
    //
    //
    //############################
    public void Ausgeben(List<Mitarbeiter> list){
                
        String line="\n....................\n";
        String ausgabe=line;
        
        for(int i=0;i<list.size();i++){
            ausgabe += (i+1)+": "+list.get(i).S_vorname+" "+list.get(i).S_nachname;
            ausgabe += line;
        }
        
        konAus.Daten_Darstellen(ausgabe);
    }
    //############################
    //
    //
    //
    //############################
    /*public void Name_Suchen(){
        
        String name = konEin.Eingabe_String("Nach welchem Namen Suchen Sie?");
        
        List<Mitarbeiter> ma = daten.Name_Suchen(name);
        
        if(ma.size() >= 1){
            Ausgeben(ma);
        }
        else{
            log.LogNachricht("Kein Mitarbeiter mit diesem Namen");
        }
        
    }*/
    //############################
    //
    //
    //
    //############################
    public void Alles_Suchen(){
        
        List<Mitarbeiter> list = daten.Liste_Ausgeben();
        Ausgeben(list);
        
    }
    //############################
    //
    //
    //
    
    
    
}
