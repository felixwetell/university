import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;

public class View extends WindowAdapter
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

    private Control control;

    private FileHandling fileHandling;

    public View()
    {
        control = new Control( this );
        fileHandling = FileHandling.getInstance();

        frame = new JFrame( "Lottery Row" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setPreferredSize( new Dimension(600, 400) );
        frame.addWindowListener(control);

        panel = new JPanel();
        textArea = new JTextArea();

        menuBar = new JMenuBar();
        menu = new JMenu( "Archive" );
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

        textArea.setEditable( false );

        menuBar.add( menu );
        panel.add( textArea );
        frame.setJMenuBar ( menuBar );
        frame.add( panel );

        frame.pack();
        frame.setVisible(true);

        for ( int i = 0 ; i <  menu.getItemCount(); i++ )
        {
            if( i == 4 )
            {
                i = 5;
            }

            JMenuItem item;
            item = menu.getItem( i );
            item.addActionListener(control);
        }
    }

    public static void main( String[] args )
    {
        FileHandling fileHandling = FileHandling.getInstance();
        new View();
    }

    public void printTextArea( String text )
    {
        textArea.append( text + "\n" );
    }

    public void clearTextArea()
    {
        textArea.setText( "" );
    }

    public String fetchText()
    {
        String text = textArea.getText();
        if( !"".equals( text ) )
        {
            return text;
        }
        return null;
    }

}