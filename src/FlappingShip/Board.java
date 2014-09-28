package FlappingShip;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private ArrayList pipes;
    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;

    private int[][] pos = { //Using this to generate pipes, make random.
            {700, 50},{600, 180},{500, 150},{400, 100}
    };

    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        ingame = true;

        setSize(400, 300);

        craft = new Craft();

        initPipes();

        timer = new Timer(5, this);
        timer.start();
    }

    public void addNotify() {
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();
    }

    public void initPipes() {
        pipes = new ArrayList();

        for (int i=0; i<pos.length; i++ ) {
            pipes.add(new Pipes(pos[i][0], 0, 10, pos[i][1]));
            pipes.add(new Pipes(pos[i][0], pos[i][1]+100, 10, pos[i][1]));
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (ingame) {

            Graphics2D g2d = (Graphics2D)g;

            if (craft.isVisible())
                g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);

            for (int i = 0; i < pipes.size(); i++) {
                Pipes a = (Pipes) pipes.get(i);
                if (a.isVisible())
                    g2d.drawRect(a.getX(), a.getY(), 10, a.getHeight());
            }

            g2d.setColor(Color.WHITE);

        } else {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2,
                    B_HEIGHT / 2);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < pipes.size(); i++) {
            Pipes a = (Pipes) pipes.get(i);
            if (a.isVisible())
                a.move();
            else pipes.remove(i);
        }

        craft.move();
        checkCollisions();
        repaint();
    }

    public void checkCollisions() {

        Rectangle r3 = craft.getBounds();

        for (int j = 0; j< pipes.size(); j++) {
            Pipes a = (Pipes) pipes.get(j);
            Rectangle r2 = a.getBounds();

            if (r3.intersects(r2)) {
                craft.setVisible(false);
                a.setVisible(false);
                ingame = false;
            }
        }
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }
}