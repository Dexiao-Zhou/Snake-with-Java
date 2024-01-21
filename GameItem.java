public abstract class GameItem {  //Warum kann es "SnakeGame" nicht extends?
    private static int x;
    private static int y;
    public Point position = new Point(x, y); //die als Point-Objekt in einem Attribut position gespeichert werden.
    private final AudColor color = AudColor.YELLOW;

    GameItem() {
    }

    GameItem(int x, int y) {
        GameItem.x = x;
        GameItem.y = y;
    }

    public Point getPosition() {
        return position;
    }

    public abstract void paint(AudGraphics g);
}