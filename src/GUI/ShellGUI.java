package GUI;
import audiomanager.*;
/**
 * Created by genius on 4/1/2016.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Created by edufcknd on 28/03/16.
 */
public class ShellGUI extends JFrame{
    private JTextField textField1;
    private JFrame frame = new JFrame();
    private JButton enter;
    private JTree tree1;
    private JPanel rootPanel;
    private JTextArea outputArea;
    private JFrame mainFrame;
    private String input;
    private JPopupMenu menu = new JPopupMenu();
    private JMenuItem x = new JMenuItem("X");


    public void setInputToNULL(){
        input = null;
    }

    public String getCommand(){
        return input;
    }

    public ShellGUI()
    {
        super("shell");
        menu.add(x);
        //nu merge
        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("xxxx");
            }
        });

        tree1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                if (SwingUtilities.isRightMouseButton(me))
                    menu.show(me.getComponent(),me.getX(),me.getY());
            }
        });
        tree1.setModel(new FileSystemModel(new File("E:/Muzica")));
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        textField1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                input = textField1.getText();
                System.out.println(input);
            }

        });

        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("whatever");
            }
        });
    }

}
