/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiomanager;

/**
 * Custom exceptions
 */
public class CommandException extends Exception{
    
  public CommandException() { super(); }
  public CommandException(String message) { super(message); }
  public CommandException(String message, Throwable cause) { super(message, cause); }
  public CommandException(Throwable cause) { super(cause); }

}
