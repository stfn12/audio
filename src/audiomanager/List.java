
package audiomanager;

import java.io.*;
import java.util.ArrayList;
/**
 *  Class that implements the methods that display the list of songs
 */
public class List {
    public final ArrayList<File> fileList=new ArrayList<File>();
    /**
     * Lists all of the files in the folder given as path
     * @param arg path
     */
    public void listFilesForFolder(final String arg) {
        final File path = new File(arg);
        for (final File fileEntry : path.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry.getAbsolutePath());
            } 
            else {
                if(fileEntry.getName().endsWith(".mp3")||fileEntry.getName().endsWith(".wav")||fileEntry.getName().endsWith(".flac")) {
                    fileList.add(fileEntry);
                }
            }
        }
        
    }
    /**
     *  Prints the file names
     */
    public void printFiles(){
    for (File i : fileList)
            System.out.println(i.getName());
    }
}
