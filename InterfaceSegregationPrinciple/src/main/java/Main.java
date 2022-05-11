/*  Interface Segregation Principle

    • This is the fourth letter of the SOLID acronym.


    What it tells us
    CLIENTS SHOULD NOT BE FORCED TO DEPEND UPON INTERFACES THAT THEY DO NOT USE.


    Meaning
    • In other words, it says that clients shouldn't depend on methods implemented on interfaces that they don't use.

    Interface pollution
    • This means that interface should have specific methods for a single purpose, related methods.
    • Also, interfaces, in general, should not be large.


    Examples of violation of this principle
    • Classes that have empty method implementation because when implementing an interface, the interface forces us to
      implement those methods.
    • Method implementations that throw "UnsupportedOperationException" (or similar).
    • Method implementations that return null or default/dummy values.
    The points described above are indications that the principle is being violated.


    What we have to fix
    • Basically what we want is to reduce the code of large interfaces by segregating the code to specific interfaces,
      in other words, we want to write highly cohesive interfaces.


    How to fix it
    • One way of solving this problem is to break your interfaces, making them more specific towards a subject.
    • Another solution is that if a method in an interface is applicable only to one single class, we can remove this
      method from the interface and define it only in the class itself. This is the solution that we are going to use
      for this app.
 */

public class Main
{
    public static void main(String[] args)
    {
        // Abstract principle.
    }

}
