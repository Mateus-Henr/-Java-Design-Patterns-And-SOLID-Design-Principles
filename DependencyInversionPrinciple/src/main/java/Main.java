/*  Dependency Inversion Principle

    • The last letter in the SOLID acronym.


    What it tells us
    A. HIGH LEVEL MODULES SHOULD NOT DEPEND UPON LOW LEVEL MODULES. BOTH SHOULD DEPEND UPON ABSTRACTIONS.
    B. ABSTRACTION SHOULD NOT DEPEND UPON DETAILS. DETAILS SHOULD DEPEND UPON ABSTRACTIONS.


    Meaning

    Dependency
    • Dependency is something that we need in order to provide the necessary functionalities to our code.
    Ex: Given the task of printing a string, we can use "System.out.println("Hello!");", in this case our code depends
        on "out" object, that is defined in the "System" class.

    Dependency inversion
    • This sort of tells us to do the opposite that we typically do.
    Ex: Let's say that we are going to create a report and write it out in a file, during this process we need to create
        an object of type "JsonFormatter" to format our data, and an object of type "FileWriter" to write our data our
        in a file. These two objects that we created are tightly coupling our reporter generation.


    When does the problem appear?
    • Suppose that you have to modify any of those objects mentioned above, because they are tightly coupled to one
      another, it's very likely to introduce new issues to code that has already been tested. And in a big project,
      this could become unmaintainable.


    How does it help us?
    • Dependency inversion tells us that instead of tightly coupling our high level modules to low level modules, we
      should depend on abstraction, an interface is an example.
    • High level module is a module that provides/implements some business code (what we write), on the opposite side,
      a low level module is a functionality that is so basic that can be used anywhere (writing to disk is an example).


    How to fix it
    • In the context of this app, by writing our high level code using that interface would solve this problem. So
      instead of creating new objects in or method, we will accept parameters of these particular interfaces.
      In this case, "Formatter" and "Writer".
    • By doing it our code will no longer be tightly coupled to any concrete class.
    • So if in the future any modifications are necessary, the person only have to change the type of "Formatter", or
      "Writer", notice that as we are accepting interfaces as parameters we have an wide range of class that can be
      passed in to the method.


    Conclusion
    It basically says that instead of instantiating dependencies ourselves, let somebody else give us the dependencies.
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
