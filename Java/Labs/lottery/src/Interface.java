import javax.swing.*;
import java.awt.Frame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.*;

public class Interface extends WindowAdapter
{
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem clear;
    private JMenuItem randomize;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem exit;

    private Listener listener;

    public static void main( String[] args )
    {
        new Interface();
    }

    public Interface()
    {
        frame = new JFrame( "Lottery Row" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setPreferredSize( new Dimension(600, 400) );

        panel = new JPanel();
        textArea = new JTextArea();

        menuBar = new JMenuBar();
        menu = new JMenu( "Arkiv" );
        clear = new JMenuItem( "Clear" );
        randomize = new JMenuItem( "Randomize" );
        open = new JMenuItem( "Open" );
        save = new JMenuItem( "Save" );
        exit = new JMenuItem( "Exit" );

        menu.add(clear);
        menu.add(randomize);
        menu.add(open);
        menu.add(save);
        menu.addSeparator();
        menu.add(exit);

        menuBar.add( menu );
        panel.add( textArea );
        frame.setJMenuBar ( menuBar );
        frame.add( panel );

        frame.pack();
        frame.setVisible(true);

        for ( int i = 0 ; i <  menu.getItemCount(); i++ )
        {
            JMenuItem item = menu.getItem(i);
            item.addActionListener( listener );
        }
    }

    public static void main ()
    {
        new Interface();
    }
}