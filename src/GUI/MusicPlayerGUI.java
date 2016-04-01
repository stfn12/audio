package GUI;
import audiomanager.*;
/**
 * Created by genius on 4/1/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;



public class MusicPlayerGUI {
    private JFrame frame = new JFrame("Music Player");
    private JSplitPane splitPane;
    private JTextArea info = new JTextArea();
    private JTree tree = new JTree();

    private void openWebpage(String uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URL(uri).toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public MusicPlayerGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Splitter s = new Splitter();
        info.setSize(250,500);
        tree.setModel(new FileSystemModel(new File("E:\\Muzica")));
        JScrollPane scrollpane = new JScrollPane(tree);
        splitPane=s.split(tree,info);
        frame.getContentPane().add(splitPane, BorderLayout.CENTER);
        frame.setSize(500,500);
        //play on left click

        JMenuItem addFav = new JMenuItem("add to favourites");
        addFav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                String songName=tree.getSelectionPath().toString();
                songName = songName.replaceAll(", ","/");
                songName = songName.replaceAll("\\[","");
                songName = songName.replaceAll("]","");
                System.out.println(songName);
                File f = new File(songName);
                if (f.exists()) {
                    Fav fav = new Fav();
                    //fav.addFav(f);
                    info.setText("file: " + f.getName() + " added to favourites");
                }

            }
        });
        JMenuItem getInfo = new JMenuItem("get info");
        getInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                String songName=tree.getSelectionPath().toString();
                String output;
                songName = songName.replaceAll(", ","/");
                songName = songName.replaceAll("\\[","");
                songName = songName.replaceAll("]","");
                System.out.println(songName);
                File f = new File(songName);
                if (f.exists()) {
                    Info i = new Info();
                    //output = i.extract(f);
                    //info.setText(output);
                }
            }
        });
        JMenuItem searchWeb = new JMenuItem("search on the Web");
        searchWeb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e3) {
                String songName=tree.getSelectionPath().toString();
                String output;
                songName = songName.replaceAll(", ","/");
                songName = songName.replaceAll("\\[","");
                songName = songName.replaceAll("]","");
                String url = "http://www.google.ro/";
                url=url+songName;
                try {
                    openWebpage(url);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        tree.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)){
                    String songName=tree.getSelectionPath().toString();
                    songName = songName.replaceAll(", ","/");
                    songName = songName.replaceAll("\\[","");
                    songName = songName.replaceAll("]","");
                    System.out.println(songName);
                    File f = new File(songName);
                    if (f.exists()){
                        Desktop desktop=Desktop.getDesktop();
                        try {
                            desktop.open(f);
                        } catch (IOException ex){
                            ex.printStackTrace();
                        }
                    }
                }
                if (SwingUtilities.isRightMouseButton(e)){
                    String songName=tree.getSelectionPath().toString();
                    songName = songName.replaceAll(", ","/");
                    songName = songName.replaceAll("\\[","");
                    songName = songName.replaceAll("]","");
                    System.out.println(songName);
                    File f = new File(songName);
                    if (f.exists()) {
                        JPopupMenu popupMenu = new JPopupMenu();
                        popupMenu.add(addFav);
                        popupMenu.add(getInfo);
                        popupMenu.add(searchWeb);
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.setVisible(true);
    }


}
