import java.io.*;
import java.io.IOException;
import java.nio.file.*;

public class FileHandling
{
    private File lotteryFile;
    private String filePath;
    private static String fileName;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private BufferedWriter bufferedWriter;
    private BufferedReader reader;
    private StringBuilder content;

    private static FileHandling instance = null;


    private FileHandling()
    {
        filePath = "/Users/felix/Documents/Github/university/Java/Labs/lottery/lottery.txt";
        fileName = "lottery.txt";
        lotteryFile = new File( fileName, filePath );
    }

    public static FileHandling getInstance()
    {
        if( instance == null )
        {
            instance = new FileHandling();
        }
        return instance;
    }

    public void save( String lotteryRows )
    {
        System.out.println( lotteryRows );

        try
        {
            // fileWriter = new FileWriter( lotteryFile );
            // fileWriter.write( lotteryRows );
            // fileWriter.close();

            fileWriter = new FileWriter( lotteryFile, true );
            printWriter = new PrintWriter( fileWriter );
            printWriter.println( lotteryRows );
            printWriter.close();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    public String open()
    {
        content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader( new FileReader( filePath ) ) )
        {
            String currentLine;
            while ( ( currentLine = reader.readLine() ) != null )
            {
                content.append( currentLine ).append( "\n" );
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}