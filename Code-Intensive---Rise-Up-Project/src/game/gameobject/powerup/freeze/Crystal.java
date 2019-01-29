package game.gameobject.powerup.freeze;

import game.gameobject.GameObject;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Crystal extends GameObject {
    public Crystal(){
        GameObject.topLayer.add(this);
        BufferedImage image = SpriteUtils.loadImage("assets/images/power-up/freeze/crystal.png");
        this.renderer = new SingleImageRenderer(image);
    }
}
