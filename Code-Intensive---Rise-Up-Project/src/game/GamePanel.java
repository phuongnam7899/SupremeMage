package game;

import game.gameobject.*;
import game.gameobject.enemy.*;
import game.gameobject.magician.Magician;
import game.gameobject.player.Player;
import game.gameobject.powerup.Boom;
import game.gameobject.powerup.Freeze;
import game.gameobject.powerup.Shield;
import game.scene.SceneManager;
import game.scene.SceneWelcome;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {


    public GamePanel() {
//        GameObject.recycle(Background.class);
////        GameObject.recycle(Freeze.class);
////        GameObject.recycle(Shield.class);
////        GameObject.recycle(Boom.class);
////        GameObject.recycle(Alien1.class);
////        GameObject.recycle(EnemySummoner.class);
////        GameObject.recycle(Ghost.class);
////        GameObject.recycle(Warrior.class);
////        GameObject.recycle(Player.class);
////        GameObject.recycle(Magician.class);
        SceneManager.signNewScene(new SceneWelcome());

    }


    public void gameLoop() {
        long lastLoop = 0;
        long delay = 1000 / 60;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastLoop > delay) {
                this.runAll();
                this.renderAll();
                lastLoop = currentTime;
            }
        }
    }

    public void runAll() {
        GameObject.runAll();
    }

    public void renderAll() {
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        GameObject.renderAll(g);
    }
}
