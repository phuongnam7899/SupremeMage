package game.scene;


import game.GameWindow;
import game.Settings;
import game.gameobject.GameObject;
import game.gameobject.player.Player;
import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver() {
        GameObject.topLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/gameover1.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/gameover2.png"));
        this.renderer = new Animation(images);
        this.position.set(Settings.SCREEN_WIDTH / 2
                , Settings.SCREEN_HEIGHT / 2);

}
    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.GREEN);
        g.setFont(Settings.BIG_SIZE);
        g.drawString("Your score : " + Player.score+"",Settings.BACKGROUND_WIDTH -  260 ,380);
    }

    @Override
    public void run() {
        if (GameWindow.isAnyKeyPress){
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
