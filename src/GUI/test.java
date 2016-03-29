package GUI;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import audiomanager.*;

/**
 * Created by genius on 3/29/2016.
 */
public class test extends JFrame{
    private JTree tree1;
    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode folders;
    private DefaultMutableTreeNode favourite;
    public test()
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Muzica");

        DefaultMutableTreeNode folders = new DefaultMutableTreeNode("Folders");
        DefaultMutableTreeNode favourite = new DefaultMutableTreeNode("Favourite");

        root.add(folders);
        root.add(favourite);
        tree1 = new JTree(root);
        add(tree1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");
        this.pack();
        this.setVisible(true);
    }

    public void addFavorite(String name)
    {
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(name);
        favourite.add(newNode);
    }
}
