import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public abstract class Listener extends WindowAdapter implements ActionListener
{
    private Interface event;
    private Controller controller;

    public Listener( Interface eventIn )
    {
        event = eventIn;
        controller = new Controller();
    }

    public void actionPerformed( ActionEvent e )
    {

    }

}
