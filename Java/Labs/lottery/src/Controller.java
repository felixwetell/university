import java.awt.event.*;

/**
 * Controller class that extends WindowAdapter and implements ActionListener.
 */
public class Controller extends WindowAdapter implements ActionListener
{
    private View view;
    private Model model;

    /**
     * Controller that handles actions between GUI, model and file handler.
     * Initilizes some variables and confirm that new model is created.
     *
     * @param viewIn
     */
    public Controller(View viewIn )
    {
        // Initializing variables
        view = viewIn;
        model = new Model();
        System.out.println( "New model created" );
    }

    /**
     * Handles actions from GUI with a switch. Gets the text from the pressed button
     * and saves the value in a variable. Switch handles what button is pressed.
     * Cases range from, Clear, Randomise, Open, Save and Exit.
     *
     * Clear, clears textarea on GUI.
     * Randomise, adds an array with 7 randomised values to string lotteryRow.
     * Open, clear textarea on GUI, creates an instance of FileHandling, gets values from file
     * and puts them on the GUI textarea.
     * Save, save text from textarea, creates an instance of FileHandling and saves
     * text in file.
     * Exit, exits the program.
     *
     * @param e is an incoming event
     */
    // Handles actions from GUI
    public void actionPerformed( ActionEvent e )
    {
        // Gets button text
        String command = e.getActionCommand();

        // Checks which button is pressed
        switch ( command )
        {
            // Clears textarea
            case "Clear":

                view.clearTextArea();
                break;

            // Randomises values and puts in array
            case "Randomise":

                String lotteryRow = model.randomise();
                view.printTextArea( lotteryRow );
                break;

            // Clears text area and adds text from file
            case "Open":

                view.clearTextArea();
                String fileContent = FileHandling.getInstance().open();
                view.printTextArea( fileContent );
                break;

            // Saves current text in textarea to file
            case "Save":

                String text = view.fetchText();
                FileHandling.getInstance().save( text );
                break;

            // Exits the program
            case "Exit":

                System.exit( 0 );
                break;


            default:
                System.out.println( "Unknown command" );
                break;
        }
    }
}
