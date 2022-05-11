// It's important to understand that a square is a special type of rectangle, that's why we are using inheritance here.
// Here, instead of extending from "Rectangle", we will be implementing the "Shape" interface since the only method that
// is common to both class is the "computeArea" method, other than that (the other methods) have to be specific for that
// class in order to not violate the Liskov Substitution principle.
public class Square implements Shape
{
    private int side;

    public Square(int side)
    {
        this.side = side;
    }

    public int getSide()
    {
        return side;
    }

    public void setSide(int side)
    {
        this.side = side;
    }

    @Override
    public int computeArea()
    {
        return side * side;
    }

    // Method that was violating the principle.
//    // This method makes sure that whichever value the user set, it will still be a square.
//    public void setSide(int side)
//    {
//        super.setWidth(side);
//        super.setHeight(side);
//    }
}
