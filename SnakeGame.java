/**
 * This class represents the Snake game.
 */
public class SnakeGame extends AudGameWindow{
    // Static variables for game parameters
    public static int score = 0;
    public static final int SQUARE_SIZE = 16;
    public static int height;
    public static int width;

    // Objects for game elements
    Snake snake;
    Brick brick;
    static Apple apple;

    // Constant for controlling the speed of the snake
    public static final int STEP_TIME = 100; //change the speed of the snake

    // Variable to track the time of the first snake update
    long firstSnakeUpdate;

    // Constructor to initialize the game
    SnakeGame(){
        setTitle("AuD-Snake - Score:"+ score);
        height = getGameAreaHeight()/SQUARE_SIZE;
        width = getGameAreaWidth()/SQUARE_SIZE;
        snake = new Snake(width/2,height/2);
        brick = new Brick();
        firstSnakeUpdate = System.currentTimeMillis();
        createNewApple();
    }

    // Method to update the game state
    @Override
    public void updateGame(long time) {
        time = System.currentTimeMillis() + STEP_TIME;
        long lastSnakeUpdate = System.currentTimeMillis();
        while (time > lastSnakeUpdate) {
            lastSnakeUpdate = System.currentTimeMillis();
        }

        snake.step();
        if (checkCollisions()) {
            showDialog("Your Score is " + score);
            stop();
        } else if (snake.collidesWithSelf()) {
            showDialog("Your Score is " + score);
            stop();
        }

        height = getGameAreaHeight()/SQUARE_SIZE;
        width = getGameAreaWidth()/SQUARE_SIZE;
        if (Snake.points[0].getX() == Apple.applePosition.getX() && Snake.points[0].getY() == Apple.applePosition.getY()) {
            snake.grow((height - 1) * (width - 1));

            for (int i = 0; i< snake.GROW_AMOUNT; i++) {
                Snake.points[Snake.points.length - snake.GROW_AMOUNT + i] = Snake.points[Snake.points.length- snake.GROW_AMOUNT-1];
            }
            score=Apple.VALUE-1;
            setTitle("AuD-Snake - Score:"+ score);
        }
    }

    // Method to paint the game elements
    @Override
    public void paintGame(AudGraphics g) {
        snake.paint(g);
        brick = new Brick();
        brick.paint(g);
        apple.paint(g);
    }

    // Method to handle user input
    @Override
    public void handleInput(int keyCode) {
        switch (keyCode){
            case KeyEvent.VK_LEFT:
                if(snake.getNextDirection()!= Snake.Direction.RIGHT){
                    snake.setNextDirection(Snake.Direction.LEFT);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(snake.getNextDirection()!= Snake.Direction.LEFT) {
                    snake.setNextDirection(Snake.Direction.RIGHT);
                }
                break;
            case KeyEvent.VK_UP:
                if(snake.getNextDirection()!= Snake.Direction.DOWN) {
                    snake.setNextDirection(Snake.Direction.UP);
                }
                break;
            case KeyEvent.VK_DOWN:
                if(snake.getNextDirection()!= Snake.Direction.UP) {
                    snake.setNextDirection(Snake.Direction.DOWN);
                }
                break;
            default:
                break;
        }
    }

    // Method to check for collisions
    public boolean checkCollisions(){
        return snake.collidesWith(brick);
    }

    // Method to create a new apple
    public static void createNewApple(){
        int x = (int)(Math.random()*(width-2)) + 1;
        int y = (int)(Math.random()*(height-2)) + 1;

        while (Snake.collidesWith(x, y)) {
            x = (int)(Math.random()*(width-2)) + 1;
            y = (int)(Math.random()*(height-2)) + 1;
        }
        Apple.applePosition = new Point(x,y);
        apple = new Apple(x * SQUARE_SIZE,y * SQUARE_SIZE);
    }

    // Main method to start the game
    public static void main(String[] args){
        SnakeGame SnakeGame1 = new SnakeGame();
        SnakeGame1.start();
    }
}
