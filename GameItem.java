/**
 * This class represents a generic game item.
 */
public abstract class GameItem {  //Why can't it extend "SnakeGame"?
    // Coordinates of the game item
    private static int x;
    private static int y;

    // Point object to hold the position of the game item
    public Point position = new Point(x, y); // This is saved as a point at a specific position

    // Color of the game item
    private final AudColor color = AudColor.YELLOW;

    // Default constructor
    GameItem() {
    }

    // Constructor with coordinates parameters
    GameItem(int x, int y) {
        GameItem.x = x;
        GameItem.y = y;
    }

    // Getter for the position of the game item
    public Point getPosition() {
        return position;
    }

    // Abstract method to paint the game item on the screen
    public abstract void paint(AudGraphics g);
}
