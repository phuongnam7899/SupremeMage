package game;

import game.gameobject.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class GameWindow extends JFrame {
    //static
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;
    public static boolean isAnyKeyPress;

    //thuoc tinh
    public GamePanel gamePanel; // no - static
    //GamePanel p;
    Player player;
    //ham tao
    public GameWindow() {
        this.setupWindow();
        this.createGamePanel();
        this.hideCursor();
        this.setVisible(true);
    }

    //phuong thuc
//    private void setupMouse() {
//        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
//        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
//                cursorImg, new Point(0, 0), "blank cursor");
//        player.getContentPane().setCursor(blankCursor);
//    }

    private void createGamePanel() {
        this.gamePanel = new GamePanel();
        this.gamePanel.setPreferredSize(new Dimension(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT));
        this.add(this.gamePanel);
        this.pack();
    }

    private void setupWindow() {
//        this.setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        this.setTitle("RiseUp");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setupListener();
    }
    private void setupListener() {
        Insets insets = this.getInsets();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                isAnyKeyPress = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                isAnyKeyPress = false;
            }
        });
    }
    private void hideCursor(){
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        this.getContentPane().setCursor(blankCursor);

    }

}
