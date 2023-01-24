package aufgabe_1;

public class Aufgabe_1 {
    
    
    //
    //
    //
    //#####################################
    public static void main(String[] args){
        
        
        Konsole_Log log = new Konsole_Log(); 
        Tools tool = new Tools();
        
        Datenverwaltung daten = new Datenverwaltung();
        Logik_Eingeben anlegen = new Logik_Eingeben(daten);   
        Logik_Ausgeben ausgeben = new Logik_Ausgeben(daten);
        
        
        log.LogNachricht("Programm Start");
        
        boolean run=true;
        while(run==true){
            
            System.out.flush();
                      
            int auswahl = tool.Auswahl_Treffen("Was möchten Sie tun?", new String[]{"Einen neuen Mitarbeiter anlegen","Vorhandene Mitarbeiter ausgeben","Programm schließen"});
        
            switch(auswahl){
                case 1:
                    anlegen.Vorgang_Starten(); 
                break;
                
                case 2:
                    ausgeben.Vorgang_Starten();
                break;
                
                case 3:
                    run=false;
                break;
            }
        }
        log.LogNachricht("Auf Wiedersehen");  
    }
    
    
}
