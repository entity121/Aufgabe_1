package aufgabe_1;

public class Logik_Eingeben {
    
    Konsole_Eingeben kon;
    Konsole_Log log;
    Tools tool;
    Datenverwaltung daten;
    
    public Logik_Eingeben(Datenverwaltung d){
        kon = new Konsole_Eingeben();
        log = new Konsole_Log();
        tool = new Tools();
        daten = d;
    }

    //
    //
    //
    //########################################
    public void Vorgang_Starten(){
        
        Mitarbeiter ma = new Mitarbeiter();      
        
        log.LogNachricht("Neuer Mitarbeiter wird angelegt");
        System.out.println("Bitte füllen Sie nacheinander die erforderlichen Felder aus!\n");

        Eingaben_Sammeln(ma);
    }
    //########################################
    //
    //
    //
    //########################################
    private void Eingaben_Sammeln(Mitarbeiter ma){
       
        //Vorname
        ma.S_vorname = kon.Eingabe_String("Vorname");
        log.LogNachricht("Vorname lautet: "+ma.S_vorname);
        //##############
        
        //Nachname
        ma.S_nachname = kon.Eingabe_String("Nachname");
        log.LogNachricht("Nachname lautet: "+ma.S_nachname);
        //##############
        
        //Geburtstag
        
        do{
            ma.geburtstag[0] = kon.Eingabe_Int("Geburtstag (Tag)");
            if(ma.geburtstag[0]<=0 || ma.geburtstag[0]>31){
                log.LogError("Bitte gültigen Tag angeben");
            }
        }
        while(ma.geburtstag[0]<=0 || ma.geburtstag[0]>31);
                
        do{
            ma.geburtstag[1] = kon.Eingabe_Int("Geburtstag (Monat)");
            if(ma.geburtstag[1]<=0 || ma.geburtstag[1]>12){
                log.LogError("Bitte gültigen Monat angeben");
            }
        }
        while(ma.geburtstag[1]<=0 || ma.geburtstag[1]>12);
              
        do{
            ma.geburtstag[2] = kon.Eingabe_Int("Geburtstag (Jahr)");
            if(ma.geburtstag[2]<1000){
                log.LogError("Bitte das Jahr ausschreiben");
            }
        }
        while(ma.geburtstag[2] < 1000);
        log.LogNachricht("Das Geburtsdatum ist: "+tool.Datum_Zahlen(ma.geburtstag[0])+"."+tool.Datum_Zahlen(ma.geburtstag[1])+"."+ma.geburtstag[2]);
        //##############
        
        //Geschlecht      
        do{
            ma.S_geschlecht = kon.Eingabe_String("Geschlecht (m/w)");
            if(ma.S_geschlecht.equalsIgnoreCase("m")){
                log.LogNachricht("Das Geschlecht ist: männlich");
            }
            else if(ma.S_geschlecht.equalsIgnoreCase("w")){
                log.LogNachricht("Das Geschlecht ist: weiblich");
            }
            else{
                ma.S_geschlecht = "0";
                log.LogError("Bitte m für männlich und w für weiblich");
            }
        } 
        while(ma.S_geschlecht.equalsIgnoreCase("0")); 
        //##############
        

        //Bisherige Ausbildung
        int count = 1;
        do
        {           
            ma.Ls_ausbildung.add(kon.Eingabe_String(count+". Ausbildung"));
            log.LogNachricht(count+". Ausbildung: "+ma.Ls_ausbildung.get(count-1));
            
            count++;
            
            if(!tool.Ja_Nein("Möchten Sie eine weitere Ausbildung angeben?)")){
                count=0;
            }
        }
        while(count>0);
        //##############
        
       
        //Berufsbezeichnung
        ma.S_beruf=kon.Eingabe_String("Berufsbezeichnung");
        log.LogNachricht("Der Beruf ist: "+ma.S_beruf);
        //##############
        
        //Position
        ma.S_position = kon.Eingabe_String("Position");
        log.LogNachricht("Die Position ist: "+ma.S_position);
        //##############
        
        //Angestellt seit             
        do{
            ma.einstellung[0] = kon.Eingabe_Int("Angestellt seit (Tag)");
            if(ma.einstellung[0]<=0 || ma.einstellung[0]>31){
                log.LogError("Bitte gültigen Tag angeben");
            }
        }
        while(ma.einstellung[0]<=0 || ma.einstellung[0]>31);
                
        do{
            ma.einstellung[1] = kon.Eingabe_Int("Angestellt seit (Monat)");
            if(ma.einstellung[1]<=0 || ma.einstellung[1]>12){
                log.LogError("Bitte gültigen Monat angeben");
            }
        }
        while(ma.einstellung[1]<=0 || ma.einstellung[1]>12);
            
        do{
            ma.einstellung[2] = kon.Eingabe_Int("Angestellt seit (Jahr)");
            if(ma.einstellung[2]<1000){
                log.LogError("Bitte das Jahr ausschreiben");
            }
        }
        while(ma.einstellung[2] < 1000);     
        log.LogNachricht("Angestellt seit: "+tool.Datum_Zahlen(ma.einstellung[0])+"."+tool.Datum_Zahlen(ma.einstellung[1])+"."+ma.einstellung[2]);
        //##############
        
        //Abteilung
        ma.S_abteilung = kon.Eingabe_String("Abteilung");
        log.LogNachricht("Eingestellt in der Abteilung: "+ma.S_abteilung);
        //##############
        
        //Gehalt
        ma.I_gehalt = kon.Eingabe_Int("Gehalt / Monat");
        log.LogNachricht("Erhält monatlich: "+ma.I_gehalt+"€");
        //##############
        
        //Platznummer
        ma.I_platz = kon.Eingabe_Int("Platz Nummer");
        log.LogNachricht("Platznummer: "+ma.I_platz);
        //##############
        
        //Raumnummer
        ma.I_raum = kon.Eingabe_Int("Raumnummer");
        log.LogNachricht("Raumnummer: "+ma.I_raum);
        //##############
        
        //email
        ma.S_email = kon.Eingabe_String("E-mail");
        log.LogNachricht("Die E-Mail lautet: "+ma.S_email);
        //##############
        
        //Telefon
        ma.I_tel = kon.Eingabe_Long("Telefon Nummer");
        log.LogNachricht("Die Telefonnummer lautet: "+ma.I_tel);
        //##############
        
        //Fähigkeiten
        count = 1;
        //String fäh;
        //int wert; 
        do{
            String fäh = kon.Eingabe_String("Fähigkeit");
            int wert = kon.Eingabe_Int("Bewertung");
            
            ma.Lf_fähigkeiten.add(new Fähigkeit(fäh,wert));
            log.LogNachricht("Die "+count+". Fähigkeit ist: "+fäh+" mit einer Bewertung von "+wert+"/100");

            count++;
            
            if(!tool.Ja_Nein("Möchten Sie eine weitere Fähigkeit angeben?")){
                count=0;
            }
        }
        while(count>0);
        //##############
        
        
        Vorgang_Abschließen(ma);

    }
    //########################################
    //
    //
    //
    //########################################
    private void Vorgang_Abschließen(Mitarbeiter ma){
        
        daten.Mitarbeiter_Hinzufügen(ma);
    }
    //########################################
    //
    //
    //
}
