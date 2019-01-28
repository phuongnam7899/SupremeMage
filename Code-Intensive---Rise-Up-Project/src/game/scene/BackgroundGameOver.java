package game.scene;


import game.Settings;
import game.gameobject.GameObject;
import game.gameobject.player.Player;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver() {
        GameObject.topLayer.add(this);
        BufferedImage image = SpriteUtils.loadImage("assets/images/scenes/scene/gameover.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.SCREEN_WIDTH / 2
                , Settings.SCREEN_HEIGHT / 2);

}
    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.GREEN);
        g.setFont(Settings.BIG_SIZE);

        g.drawString("Your score : " + Player.score+"",Settings.BACKGROUND_WIDTH -  260 ,570);
    }
}
