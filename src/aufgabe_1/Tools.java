package aufgabe_1;

import java.util.Scanner;

public class Tools {
    
    Scanner scan = new Scanner(System.in);
    Konsole_Log log = new Konsole_Log();
    //
    //
    //
    //################################
    public String Datum_Zahlen(int i){
       
       if(i<10){
           String s = "0"+i;
           return s;
       }
       else{
           String s = ""+i;
           return s;
       }
   }
    //################################
    //
    //
    //
    //################################
    public boolean Ja_Nein(String frage){
        
        frage += "\n" + "( 0=Nein , 1=Ja )";
                        
        do{              
            System.out.println(frage);
            
            String ein = scan.nextLine();      
            
            if(ein.equalsIgnoreCase("0")){
                System.out.println("\n");
                return false;
            }
            else if(ein.equalsIgnoreCase("1")){
                System.out.println("\n");
                return true;
            }
            
            log.LogError("Bitte 0 für Nein und 1 für Ja");             
        }
        while(frage=="");
        
        return false;    
    }
    //################################
    //
    //
    //
    //################################
    public int Auswahl_Treffen(String frage,String[]auswahl){
        
        String s = frage + "\n";
        
        for(int i=0;i<auswahl.length;i++){
            s+=(i+1)+": "+auswahl[i]+"\n";
        }
        s+="----------";
           
        do{
            System.out.println(s);
            
            String erg = scan.nextLine();
            
            for(int i=1;i<=auswahl.length;i++){
                
                if(erg.equalsIgnoreCase(i+"")){
                    return i;
                }              
            }
            
            log.LogError("Bitte eine gültige Auswahl treffen"); 
        }
        while(s!="");
               
        return 0;
    }
    //################################
    //
    //
    //
}
