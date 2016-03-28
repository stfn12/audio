
package audiomanager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.lang.StringUtils;
import org.apache.tika.exception.TikaException;

import org.xml.sax.SAXException;

/**
 * Class that contains all of the commands
 */
public class SelectCommand {
    private String commarg;
    private String command;
    private String arg;
    private String[] parts;
    CD p =new CD();
    public Fav favourite= new Fav();
    
    /**
    Method that allows the selection of a command from the console
    */
    public void selectCommand() {
        try{
            favourite.read();
            boolean exit=false;
            while(!exit){
                Scanner scan= new Scanner(System.in);
                System.out.println("Introduceti o comanda");
                commarg=scan.nextLine();
                if(commarg.equals("list")){
                    command="list";
                }
                else if(!commarg.equals("exit")){
                    parts=StringUtils.split(commarg);
                    command=parts[0];
                    arg=parts[1];
                }
                else command="exit";
                switch(command){
                    case "cd": cd(arg);
                    break;
                    case "list": list(arg);
                    break;
                    case "play": play(arg);
                    break;
                    case "info": info(arg);
                    break;
                    case "find": find(arg);
                    break;
                    case "fav": fav(arg);
                    break;
                    case "report": report(arg);
                    break;
                    case "exit": exit=true;
                    break;
                    default: System.out.println("Comanda gresita.");
                }
            }
        }
        catch (Exception e){
            System.out.println("Comanda gresita.");
        }
    }
    /**
     * Sets the current directory
     * @param arg directory
     */
    public void cd(String arg){
        p.cd(arg);
        System.out.println(arg+" a fost setat ca director curent.");
    }
    /**
     * Lists all of the songs
     * @param arg Path of the file list
     */
    public void list(String arg){
        List l=new List();
        if (arg.isEmpty())
            l.printFiles();
        else{
        l.listFilesForFolder(arg);
        l.printFiles();
    }
    }
    /**
     * Method that plays the audio file
     * @param arg Name of the song
     * @throws IOException Non-existent file
     */
    public void play(String arg) throws IOException{
        String filePath;
        filePath=p.path+arg;
        Play x= new Play();
        final File file = new File(filePath);
        x.play(file);
    }
    /**
     * Method that prints information about the song
     * @param arg
     * @throws IOException
     * @throws TikaException
     * @throws SAXException 
     */
    public void info(String arg) throws IOException, TikaException, SAXException{
        String filePath;
        filePath=p.path+arg;
        Info i=new Info();
        i.info(filePath);
        i.printInfo();
    }
    /**
     *  Method that finds the song given
     * @param arg song name
     * @throws IOException 
     */
    public void find(String arg) throws IOException{
        String filePath;
        Find f= new Find();
        f.find(p,arg);
    }
    /**
     * Method that adds a song to the favorite list
     * @param arg song name
     */
    public void fav(String arg){
        favourite.addFav(arg);
        favourite.write();
    }
    /**
     * method that generates a report
     * @param arg path for the report
     */
    public void report(String arg){
        Report rep=new Report();
        rep.genReport(favourite, arg);
    }

}
