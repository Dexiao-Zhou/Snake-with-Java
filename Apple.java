public class Apple extends GameItem{
    private static int x;
    private static int y;
    public static Point applePosition = new Point(x,y);
    public static int VALUE = 0;

    Apple(){
        VALUE++;
    }

    Apple(int x, int y){
        Apple.x = x;
        Apple.y = y;
        VALUE++;
    }

    @Override
    public void paint(AudGraphics g) {
        g.setColor(AudColor.RED);
        g.drawRoundRect(x,y,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE);
        g.fillRoundRect(x,y,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE,SnakeGame.SQUARE_SIZE);
    }

    public static void setVALUE(int VALUE) {
        Apple.VALUE = VALUE;
    }

    public static int getVALUE() {
        return VALUE;
    }

    public static void setX(int x) {
        Apple.x = x;
    }

    public static void setY(int y){
        Apple.y= y;
    }

    public int getX(){
        return Apple.x;
    }

    public int getY(){
        return Apple.y;
    }

    public Point getApplePosition() {
        return applePosition;
    }
}