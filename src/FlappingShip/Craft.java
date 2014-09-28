package FlappingShip;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Craft {

    private String craft = "images/craft.png";

    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;


    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        x = 40;
        y = 60;
    }


    public void move() {

        y += dy;

        if (y < 1) {
            y = 1;
        }

        if (y > 250) {
            y = 249;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            ;
        }

        if (key == KeyEvent.VK_LEFT) {
            ;
        }

        if (key == KeyEvent.VK_RIGHT) {
            ;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            ;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            ;
        }

        if (key == KeyEvent.VK_RIGHT) {
            ;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 1;
        }

        if (key == KeyEvent.VK_DOWN) {
            ;
        }
    }
}