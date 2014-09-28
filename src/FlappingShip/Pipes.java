package FlappingShip;
import java.awt.Rectangle;



public class Pipes {

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;

    public Pipes(int x, int y, int w, int h) {
        visible = true;
        width = w;
        height = h;
        this.x = x;
        this.y = y;
    }


    public void move() {
        if (x < 0)
            x = 400;
        x -= 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight(){
        return height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}