public class Brick extends GameItem{
    private int x;
    private int y;
    public static Point[] wall;

    Brick(){
        createWall();
    }

    Brick(int x, int y){
        this.x = x;
        this.y = y;
    }

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

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

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