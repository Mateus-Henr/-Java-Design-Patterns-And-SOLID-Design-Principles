/*  Liskov Substitution Principle

    • This consists of the third letter of the SOLID acronym.


    What it tells us
    WE SHOULD BE ABLE TO USE SUBSTITUTE BASE CLASS OBJECTS WITH CHILD CLASS OBJECTS AND THIS SHOULD NOT ALTER
    THE BEHAVIOUR/CHARACTERISTICS OF THE PROGRAM.


    Meaning
    • If a base class is offering a behaviour, and that base class was replaced by a child class (derived), that
      behaviour should not be altered. In other words, suppose that you have a method that calculate a sum in the base
      class, if after some time we replace that base class by a base's derived class, the child should still offer that
      same behaviour.


    The problem (in the context of this app)
    • Notice that in this app, the "Square" class is modifying the behaviour that is expected from the "Rectangle"
      class. This happens because, we expect the "Rectangle" class to set width and height separately, but the "Square"
      class sets both together. To put it more simply, we are violating the behaviour of the "Rectangle" class through
      the methods in the "Square" class.
    OBS: The example of this app is commonly used in interviews.


    How to fix it
    • In this app, it's necessary to break the inheritance, this happens because even though we can look at a square as
      a special type of rectangle, by using inheritance here, we would be violating the behaviour that a rectangle has
      that allows us to set a width and a height separately.


    More on this
    • Liskov's substitution principle can be simplified as saying, if we use child class object in-place where base
      class object was used, the change should be seamless. This can be achieved if we do not change the expected
      behavior of methods we are overriding.
    • To put it more concisely, child class method should behave as base class method. This does not mean that we
      cannot override it.


    Another example
    • Take a method that prints a report. Expected behavior of this method in base class is it prints report on printer.
      We can override this method in child class and make it print to a file/memory or print in different layout than
      base class.
    • Here even if we are overriding the method and changing how printing is happening, the expected behavior of
      printing is still followed.
    • This principle is violated if we change the "expected behavior" altogether. e.g. In above example if child class
      print method started modifying DB tables or throwing exceptions which client is not expecting then it violates the
      principle.
 */

public class Main
{
    public static void main(String[] args)
    {

        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println(rectangle.computeArea());

        Square square = new Square(10);
        System.out.println(square.computeArea());

        useRectangle(rectangle);

        // After the modifications, we have to create a method that tests a square separately.
//        useRectangle(square);
    }

    // We could use a "Rectangle" as a parameter because a "Square" is also a "Rectangle" (a "Rectangle"'s child).
    private static void useRectangle(Rectangle rectangle)
    {
        rectangle.setHeight(20);
        rectangle.setWidth(30);


        // This will fail with our square.
        if (rectangle.getHeight() != 20)
        {
            throw new AssertionError("Height Not equal to 20");
        }

        if (rectangle.getWidth() != 30)
        {
            throw new AssertionError("Width Not equal to 30");
        }
    }

}
