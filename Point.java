/**
 * This class represents a point with x and y coordinates.
 */
public class Point {
    // Coordinates of the point
    private int x;
    private int y;

    // Array to hold the coordinates of the point
    public int[] point = new int[]{x, y};

    // Constructor with x and y coordinates parameters
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    // Getter for the x-coordinate of the point
    public int getX(){
        return x;
    }

    // Getter for the y-coordinate of the point
    public int getY(){
        return y;
    }
}
