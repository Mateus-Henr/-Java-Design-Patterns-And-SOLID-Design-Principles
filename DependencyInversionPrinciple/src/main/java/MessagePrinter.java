import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter
{
    // Writes message to a file.
    public void writeMessage(Message msg, String fileName) throws IOException
    {
        // Creates formatter.
        Formatter formatter = new JSONFormatter();

        // Creates print writer.
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName)))
        {
            // Formats and writes message.
            writer.println(formatter.format(msg));
            writer.flush();
        }
    }

}
