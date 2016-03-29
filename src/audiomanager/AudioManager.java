/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiomanager;


/**
 * Main class
 */
import java.util.Scanner;
import GUI.*;
public class AudioManager {

    static Scanner scan= new Scanner(System.in);
    
    public static void main(String[] args) throws Exception
    {
        new test();
        SelectCommand selCom=new SelectCommand();
        selCom.selectCommand();
    }

}
