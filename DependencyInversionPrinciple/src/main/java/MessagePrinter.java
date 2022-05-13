import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter
{
    // Writes message to a file.
    //
    // Issues
    // - If we wanted to print the message on the console, we would have to change the method, or create a new one.
    // - If we wanted to change the format of the data, we would run on the same problems as described above.
    // OBS: Notice that the issues above happen because we are using concrete classes in our method, consequently, we
    //      have to know what the concrete class are (tightly coupling between our objects and our method).
    //
    // Fix it: Start depending on abstraction. And leave the caller do the job of instantiating classes.
    // We no longer need the file name here since it was just a parameter for the PrintWriter object.
    public void writeMessage(Message msg, Formatter formatter, PrintWriter writer) throws IOException
    {
//        // Creates formatter (dependency).
//        Formatter formatter = new JSONFormatter();

//        // Creates print writer (dependency).
//        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName)))

        // Formats and writes message.
        writer.println(formatter.format(msg));
        writer.flush();
    }

}
