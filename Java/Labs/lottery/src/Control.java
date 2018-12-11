import java.awt.event.*;

public class Control extends WindowAdapter implements ActionListener
{
    private View view;
    private Model model;

    public Control( View viewIn )
    {
        view = viewIn;
        model = new Model();
        System.out.println( "New model created" );
    }

    public void actionPerformed( ActionEvent e )
    {
        String command = e.getActionCommand();

        switch ( command )
        {
            case "Clear":

                view.clearTextArea();
                break;

            case "Randomize":

                String lotteryRow = model.randomize();
                view.printTextArea( lotteryRow );
                break;

            case "Open":

                view.clearTextArea();
                String fileContent = FileHandling.getInstance().open();
                view.printTextArea( fileContent );
                break;

            case "Save":
                String text = view.fetchText();
                FileHandling.getInstance().save( text );
                break;

            case "Exit":

                System.exit( 0 );
                break;


            default:
                break;
        }

        System.out.println( command );
    }
}
