/**
 * This class represents an apple in the game.
 */
public class Apple extends GameItem{
    // Coordinates of the apple
    private static int x;
    private static int y;

    // Position of the apple
    public static Point applePosition = new Point(x,y);

    // Value of the apple
    public static int VALUE = 0;

    // Default constructor increments the value of the apple
    Apple(){
        VALUE++;
    }

    // Constructor with coordinates parameters, sets the position and increments the value of the apple
    Apple(int x, int y){
        Apple.x = x;
        Apple.y = y;
        VALUE++;
    }

    // Method to paint the apple on the screen
    @Override
    public void paint(AudGraphics g) {
        g.setColor(AudColor.RED);
        g.drawRoundRect(x,y,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE);
        g.fillRoundRect(x,y,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE);
    }

    // Setter for the value of the apple
    public static void setVALUE(int VALUE) {
        Apple.VALUE = VALUE;
    }

    // Getter for the value of the apple
    public static int getVALUE() {
        return VALUE;
    }

    // Setter for the x-coordinate of the apple
    public static void setX(int x) {
        Apple.x = x;
    }

    // Setter for the y-coordinate of the apple
    public static void setY(int y){
        Apple.y= y;
    }

    // Getter for the x-coordinate of the apple
    public int getX(){
        return Apple.x;
    }

    // Getter for the y-coordinate of the apple
    public int getY(){
        return Apple.y;
    }

    // Getter for the position of the apple
    public Point getApplePosition() {
        return applePosition;
    }
}
