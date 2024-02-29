/**
 * This class represents a brick or wall in the game.
 */
public class Brick extends GameItem{
    // Coordinates of the brick
    private int x;
    private int y;

    // Array to hold the points of the wall
    public static Point[] wall;

    // Default constructor to create the wall
    Brick(){
        createWall();
    }

    // Constructor with coordinates parameters
    Brick(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Method to paint the brick on the screen
    @Override
    public void paint(AudGraphics g) {
        g.setColor(AudColor.YELLOW);
        for (int i = 0; i < wall.length; i++) {
            if (wall[i]!=null) {
                x = wall[i].getX();
                y = wall[i].getY();
                g.fillRect(SnakeGame.SQUARE_SIZE * x, SnakeGame.SQUARE_SIZE * y, SnakeGame.SQUARE_SIZE, SnakeGame.SQUARE_SIZE);
            }
        }
    }

    // Getter for the x-coordinate of the brick
    public int getX(){
        return x;
    }

    // Getter for the y-coordinate of the brick
    public int getY(){
        return y;
    }

    // Method to create the wall
    public void createWall(){ //创建墙的方法
        wall = new Point[SnakeGame.height *2 + SnakeGame.width * 2 +4];
        for (int i = 0; i <= SnakeGame.height; i++){
            if(wall!=null){
                wall[i] = new Point(0, i);
                wall[SnakeGame.height+1 + i] = new Point(SnakeGame.width-1, i);
            }
        }

        for (int i = 1; i < SnakeGame.width - 1; i++){
            if(wall!=null) {
                wall[2 * (SnakeGame.height + 1) + i] = new Point(i, 0);
                wall[2 * (SnakeGame.height + 1) + SnakeGame.width - 1 + i] = new Point(i, SnakeGame.height);
            }
        }
    }
}
