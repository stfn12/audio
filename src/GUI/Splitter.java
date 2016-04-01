package GUI;
import audiomanager.*;

/**
 * Created by genius on 4/1/2016.
 */
import javax.swing.*;
public class Splitter {
    public JSplitPane split(JTree T, JTextArea TA){
        JSplitPane s = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(T), new JScrollPane(TA));
        return s;
    }
}