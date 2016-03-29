/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiomanager;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;



import GUI.*;

/**
Class that creates the favorite list
*/
 
public class Report {
     
    public void genReport(Fav favor, String arg) {
         
        //Freemarker configuration object
        Configuration cfg = new Configuration();
        try {
            //Load template from source folder
            Template template = cfg.getTemplate("src/favourites.ftl");
             
            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("message", "favourite");
 
            //List parsing 
            List<String> songs = new ArrayList<String>();
            for (String i : favor.favourites) {
                songs.add(i);
            }
            data.put("songs", songs);
 
             
            // Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();
 
            // File output
            Writer file = new FileWriter (new File(arg));
            template.process(data, file);
            file.flush();
            file.close();
             
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
