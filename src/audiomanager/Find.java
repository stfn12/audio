/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiomanager;
import GUI.*;
import java.io.File;
import org.apache.tika.metadata.Metadata;

/**
 * Class that finds a song 
 */
public class Find implements Command{
    /**
     * Searches using the path and the keyword for the song
     * @param path path of the file
     * @param keyWord part of the name of the song
     */
    public void find(CD path,String keyWord){
        List files=new List();
        files.listFilesForFolder(path.path);
        for (File i : files.fileList){
            Info fileInfo= new Info();
            fileInfo.info(i.getAbsolutePath());
            if(isFound(keyWord, fileInfo.metadataNames, fileInfo.metadata))
                System.out.println(i.getAbsolutePath());
        }
    } 
    /**
     * Checks if the file is found
     * @param keyWord
     * @param metadataNames
     * @param metadata
     * @return 
     */
    public boolean isFound(String keyWord, String[] metadataNames, Metadata metadata){
        for (String metadataName : metadataNames) {
            if (metadata.get(metadataName).toLowerCase().contains(keyWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
