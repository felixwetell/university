import java.io.*;
import java.io.IOException;

/**
 * A singleton called FileHandling. The class handles the file, writing
 * and reading from the file.
 */
public class FileHandling
{
    private File lotteryFile;
    private String filePath;
    private static String fileName;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private BufferedReader reader;
    private StringBuilder content;

    private static FileHandling instance = null;

    /**
     * Sets file path, file name and creates the file.
     */
    private FileHandling()
    {
        filePath = "/Users/felix/Documents/Github/university/Java/Labs/lottery/lottery.txt";
        fileName = "lottery.txt";
        lotteryFile = new File( fileName, filePath );
    }

    /**
     * Creates FileHandling instance if instance is null, like defined in the top of
     * the class.
     *
     * @return instance
     */
    public static FileHandling getInstance()
    {
        if( instance == null )
        {
            instance = new FileHandling();
        }
        return instance;
    }

    /**
     * Method for saving text to file. The string LotteryRows contains the text
     * to be saved. The method tries to write text to the file by first creating a file writer and
     * the a print writer. If this is successful the continues by printing the text in to the file
     * and then closing the file.
     *
     * If it fails a catch is placed to catch any IO errors and printing them to the console.
     *
     * @param lotteryRows
     */
    public void save( String lotteryRows )
    {
        try
        {
            fileWriter = new FileWriter( lotteryFile, true );
            printWriter = new PrintWriter( fileWriter );
            printWriter.println( lotteryRows );
            printWriter.close();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }

    /**
     * Method for fetching text from file. The method tries to create a reader with several classes.
     * If it successful, the file is read line by line until it finds the end of the file. The text found
     * (line by line) is put in to a variable and later converted to a string format for better formatting.
     *
     * If it fails a catch is placed to catch any IO errors, printing them to the console and returning
     * the error.
     *
     * @return content and error as a string.
     */
    public String open()
    {
        content = new StringBuilder();
        try
        {
            reader = new BufferedReader( new FileReader( filePath ) );
            String currentLine;
            while ( ( currentLine = reader.readLine() ) != null )
            {
                content.append( currentLine ).append( "\n" );
            }
            return content.toString();
        }
        catch( IOException e )
        {
            e.printStackTrace();
            return e.toString();
        }
    }
}