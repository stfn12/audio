/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiomanager;
import GUI.*;
/**
 * Class that gets called to change directories
 */
public class CD implements Command {
    public String path=new String();
    
    /**
     * Sets the current directory
     * @param path
     */
    public void cd(String path){
        this.path= path;
    }
}

