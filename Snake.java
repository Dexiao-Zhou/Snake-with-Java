public class Snake {
    private int length;
    public static Point[] points; //设置点集成一个数组，这个数组就是蛇的长度
    public static Point[] newPoints;
    private final AudColor color = AudColor.BLUE;
    public final int GROW_AMOUNT = 5;

    Snake(int length, int x, int y) {    //三个参数的构造函数
        if (length <= 0) {
            throw new IllegalArgumentException("The length must be positiv number!");
        }

        points = new Point[length]; //4-a erstellen die Anfangslaenge der Schlange
        for (int i = 1; i < length; i++) {
            points[i - 1] = new Point(x, y);
            points[i] = null;   //4-b
        }

    }

    Snake(int x, int y) {    //两个参数的构造函数
        length = 6;     
        points = new Point[length];    //设置蛇的长度
        for (int i = 1; i < length; i++) {
            points[i - 1] = new Point(x, y);
            points[i] = null;
        }
    }

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

    //next Direction
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    Direction nextDirection = Direction.LEFT;

    public void setNextDirection(Direction D) {
        this.nextDirection = D;
    }

    //Standard-Ausrichtung
    public Direction getNextDirection() {
        return nextDirection;

    }

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

    public boolean collidesWith(GameItem item) {
        for (int i = 0; i < Brick.wall.length; i++) {
            if (Brick.wall[i] != null) {
                if (points[0].getX() == Brick.wall[i].getX()&&points[0].getY() == Brick.wall[i].getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean collidesWithSelf(){
        for (int i = 3; i < points.length; i++) {
            if (points[i] != null) {
                if (points[0].getX() == points[i].getX()&&points[0].getY() == points[i].getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean collidesWith(int x, int y) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] != null) {
                if (Snake.points[i].getX() == x && Snake.points[i].getY() ==y){
                    return true;
                }
            }
        }
        return false;
    }

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