public class Point {
    private int x;
    private int y;
    public int[] point = new int[]{x, y};

    Point (int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}