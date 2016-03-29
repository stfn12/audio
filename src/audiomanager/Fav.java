/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiomanager;
import GUI.*;
import java.io.*;
import java.util.ArrayList;
/**
 * Class that adds a song to the favourite list
 */
public class Fav implements Command{
    public ArrayList<String> favourites=new ArrayList<String>();
    /**
     * Method that adds a song to the favorite list
     * @param path path of the song
     */
    public void addFav(String path){
        favourites.add(path);
    }
    /**
     * Creates the file where the favorite songs will be printed
     */
    public void read() {

        String fileName = "temp.txt";

        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(fileName);
            
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                favourites.add(line);
            }  
            
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"+ fileName + "'");                  
        }
    }
    /**
     * Prints the list of the favorite song in the file created
     */
    public void write() {

        // The name of the file to open.
        String fileName = "temp.txt";

        try {
            FileWriter fileWriter =
                new FileWriter(fileName,false);

            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            for(int i=0;i<favourites.size();i++){
                bufferedWriter.write(favourites.get(i));
                bufferedWriter.newLine();
            }
            
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '" + fileName + "'");
        }
    }
}
