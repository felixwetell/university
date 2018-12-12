import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;

public class View extends WindowAdapter
{
    // Creating variables
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem clear;
    private JMenuItem randomise;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem exit;
    private Controller controller;

    /**
     * GUI shown for the user with some buttons in a menu, a frame, a panel and
     * a textarea. The used controller is also defined here.
     */
    public View()
    {
        // Initializing variables
        controller = new Controller( this );

        // Initializing GUI variables
        frame = new JFrame( "Lottery Row" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setPreferredSize( new Dimension(600, 400) );
        frame.addWindowListener(controller);

        panel = new JPanel();
        textArea = new JTextArea();

        menuBar = new JMenuBar();
        menu = new JMenu( "Archive" );
        clear = new JMenuItem( "Clear" );
        randomise = new JMenuItem( "Randomise" );
        open = new JMenuItem( "Open" );
        save = new JMenuItem( "Save" );
        exit = new JMenuItem( "Exit" );

        // Adds buttons to menu
        menu.add(clear);
        menu.add(randomise);
        menu.add(open);
        menu.add(save);
        menu.addSeparator();
        menu.add(exit);

        // Preventing user from editing textarea
        textArea.setEditable( false );

        // Adds all elements to frame
        menuBar.add( menu );
        panel.add( textArea );
        frame.setJMenuBar ( menuBar );
        frame.add( panel );

        // Packing frame and showing it
        frame.pack();
        frame.setVisible(true);

        // Adds listeners to each menu button
        for ( int i = 0 ; i <  menu.getItemCount(); i++ )
        {
            // Skips separator, causing errors
            if( i == 4 )
            {
                i = 5;
            }

            JMenuItem item;
            item = menu.getItem( i );
            item.addActionListener(controller);
        }
    }

    /**
     * Initializes GUI and starting program.
     *
     * @param args
     */
    public static void main( String[] args )
    {
        new View();
    }

    /**
     * Appends text to GUI textarea. Value is fetched from the parameter text.
     *
     * @param text
     */
    // Appends text to textarea
    public void printTextArea( String text )
    {
        textArea.append( text + "\n" );
    }

    /**
     * Clears textarea by setting text to an empty string.
     */
    // Clears textarea
    public void clearTextArea()
    {
        textArea.setText( "" );
    }

    /**
     * Fetches text from textarea on GUI and return the value in the variable text.
     * Method also checks if textarea is empty before fetching the value. If textarea
     * is empty the method return a null value.
     *
     * @return text
     */
    // Fetches text inside textarea
    public String fetchText()
    {
        String text = textArea.getText();
        // Checks if textarea has text
        if( !"".equals( text ) )
        {
            return text;
        }
        return null;
    }

}