/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiomanager;

import java.io.File;
import java.io.FileInputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

/**
 * Class that offers info regarding a song
 */
public class Info implements Command {
    public String[] metadataNames;
    public Metadata metadata = new Metadata();
    /**
     * Sets all the information about the file given
     * @param filePath file path
     */
    public void info(String filePath){
        try {
            //Parser method parameters
            
            final File file = new File(filePath);
            Parser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            FileInputStream inputstream = new FileInputStream(file);
            ParseContext context = new ParseContext();
            parser.parse(inputstream, handler, metadata, context);
            metadataNames = metadata.names();
            
        }
        catch (Exception e){
            System.out.println("Invalid file"); 
        }
    }
    /**
     * Displays all the information about the file
     */
    public void printInfo(){
        for(String name : metadataNames) {		        
            System.out.println(name + ": " + metadata.get(name));
            }
    }
}
