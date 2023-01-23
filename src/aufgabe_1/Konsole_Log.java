package aufgabe_1;

public class Konsole_Log {
    //
    //
    //
    //#############################
    public void LogNachricht(String n){
        
        String log = "\n------------------------------\nLOG: "+n+"\n------------------------------\n";
        System.out.println(log);
    }
    //
    //
    //
    //#############################
    public void LogError(String e){
        String log = "\n!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\nFEHLER: "+e+"\n!_!_!_!_!_!_!_!_!_!_!_!_!_!_!_!\n";
        System.out.println(log);
    }
    //#############################
    //
    //
    //
}
