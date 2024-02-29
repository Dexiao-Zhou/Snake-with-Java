/**
 * This class represents the snake in the game.
 */
public class Snake {
    // Length of the snake
    private int length;

    // Array to hold the points representing the snake's body
    public static Point[] points; // Array representing the snake's length

    // Array to hold new points for the snake's body when it grows
    public static Point[] newPoints;

    // Color of the snake
    private final AudColor color = AudColor.BLUE;

    // Amount the snake grows by when it eats an apple
    public final int GROW_AMOUNT = 5;

    // Constructor with three parameters
    Snake(int length, int x, int y) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length must be a positive number!");
        }

        points = new Point[length]; // Initially create the length of the snake
        for (int i = 1; i < length; i++) {
            points[i - 1] = new Point(x, y);
            points[i] = null;
        }
    }

    // Constructor with two parameters
    Snake(int x, int y) {
        length = 8;
        points = new Point[length]; // Set the length of the snake
        for (int i = 1; i < length; i++) {
            points[i - 1] = new Point(x, y);
            points[i] = null;
        }
    }

    // Method to paint the snake on the screen
    public void paint(AudGraphics g) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] != null) {
                int truePointX = SnakeGame.SQUARE_SIZE * Snake.points[i].getX();
                int truePointY = SnakeGame.SQUARE_SIZE * Snake.points[i].getY();
                g.setColor(color);
                g.fillRect(truePointX, truePointY, SnakeGame.SQUARE_SIZE, SnakeGame.SQUARE_SIZE);
            }
        }
    }

    // Enumeration representing the directions the snake can move
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    // Next direction the snake will move
    Direction nextDirection = Direction.LEFT;

    // Setter for the next direction of the snake
    public void setNextDirection(Direction D) {
        this.nextDirection = D;
    }

    // Getter for the next direction of the snake
    public Direction getNextDirection() {
        return nextDirection;
    }

    // Method to move the snake one step
    public void step() {
        switch (nextDirection) {
            case UP:
                System.arraycopy(points, 0, points, 1, points.length - 1);
                points[0] = new Point(points[0].getX(), points[0].getY() - 1);
                break;

            case DOWN:
                System.arraycopy(points, 0, points, 1, points.length - 1);
                points[0] = new Point(points[0].getX(), points[0].getY() + 1);
                break;

            case LEFT:
                System.arraycopy(points, 0, points, 1, points.length - 1);
                points[0] = new Point(points[0].getX() - 1, points[0].getY());
                break;

            case RIGHT:
                System.arraycopy(points, 0, points, 1, points.length - 1);
                points[0] = new Point(points[0].getX() + 1, points[0].getY());
                break;

            default:
                break;
        }
    }

    // Method to check if the snake collides with another game item
    public boolean collidesWith(GameItem item) {
        for (int i = 0; i < Brick.wall.length; i++) {
            if (Brick.wall[i] != null) {
                if (points[0].getX() == Brick.wall[i].getX() && points[0].getY() == Brick.wall[i].getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to check if the snake collides with itself
    public static boolean collidesWithSelf(){
        for (int i = 3; i < points.length; i++) {
            if (points[i] != null) {
                if (points[0].getX() == points[i].getX() && points[0].getY() == points[i].getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to check if the snake collides with a specific point
    public static boolean collidesWith(int x, int y) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] != null) {
                if (Snake.points[i].getX() == x && Snake.points[i].getY() == y){
                    return true;
                }
            }
        }
        return false;
    }

    // Method to make the snake grow
    public void grow(int areaSize){
        if (areaSize <= 500) {
            throw new IllegalArgumentException("The area is too small!");
        }
            newPoints = new Point[points.length + GROW_AMOUNT];
            newPoints[0] = new Point(Apple.applePosition.getX(), Apple.applePosition.getY()) ;

            for (int i=0; i < points.length; i++){
                newPoints[i] = points[i];
            }
            points = new Point[newPoints.length];
            for (int i=0;i<points.length;i++){
                points[i] = newPoints[i];
            }
            SnakeGame.createNewApple();
        }
    }
