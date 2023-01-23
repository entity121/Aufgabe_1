package aufgabe_1;

import java.util.Scanner;



public class Konsole_Eingeben {
    
    Scanner scan = new Scanner(System.in); 
    Konsole_Log log = new Konsole_Log();
    //
    //
    //
    //############################
    public String Eingabe_String(String feld){
     
        System.out.println(feld);
        
        String s = scan.next();    
        
        return s;
    }
    //############################
    //
    //
    //
    //############################
    public int Eingabe_Int(String feld){
        
        int i = 0;
        boolean check=false;
        
        while(check==false){
            
            try{
                System.out.println(feld);
                i = scan.nextInt();
                
                check=true;
            }
            catch(Exception e){
                log.LogError("Bitte nur Zahlen eingeben!");
                scan = new Scanner(System.in);
            }
                       
        }
             
        return i;
    }
    //############################
    //
    //
    //
    //############################
    public long Eingabe_Long(String feld){
        
        long i = 0;
        boolean check=false;
        
        while(check==false){
            
            try{
                System.out.println(feld);
                i = scan.nextLong();
                
                check=true;
            }
            catch(Exception e){
                log.LogError("Bitte nur Zahlen eingeben!");
                scan = new Scanner(System.in);
            }
                       
        }
             
        return i;
        
    }
    //############################
    //
    //
    //
}
