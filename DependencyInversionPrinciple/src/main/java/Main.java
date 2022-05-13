/*  Dependency Inversion Principle

    • The last letter in the SOLID acronym.


    What it tells us
    A. HIGH LEVEL MODULES SHOULD NOT DEPEND UPON LOW LEVEL MODULES. BOTH SHOULD DEPEND UPON ABSTRACTIONS.
    B. ABSTRACTION SHOULD NOT DEPEND UPON DETAILS. DETAILS SHOULD DEPEND UPON ABSTRACTIONS.

 */

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        Message msg = new Message("This is a message again");
        MessagePrinter printer = new MessagePrinter();

        printer.writeMessage(msg, "test_msg.txt");
    }

}
