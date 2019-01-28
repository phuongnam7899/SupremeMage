package game.scene;


import game.Settings;
import game.gameobject.GameObject;
import game.gameobject.Score;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver() {
        GameObject.topLayer.add(this);
        BufferedImage image = SpriteUtils.loadImage("assets/images/scenes/scene/gameover.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.SCREEN_WIDTH / 2
                , Settings.SCREEN_HEIGHT / 2);

}
}
