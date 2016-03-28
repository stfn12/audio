/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiomanager;
 
import java.io.File;
 
import java.awt.Desktop;
 
/**
 * Class that implements the methods to playback the song
 */
public class Play implements Command {

    /**
     * Plays the file
     * @param file file name
     */
    void play(File file) {
        try{
            Desktop.getDesktop().open(file);
        } 
        catch (Exception e){
            System.out.println("Invalid file"); 
        }
    }
 
}