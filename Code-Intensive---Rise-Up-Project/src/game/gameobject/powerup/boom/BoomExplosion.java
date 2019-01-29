package game.gameobject.powerup.boom;

import game.gameobject.GameObject;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BoomExplosion extends GameObject {
    public BoomExplosion()
    {
        GameObject.midLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion1.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion2.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion3.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion4.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion5.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion6.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion7.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion8.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion9.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion10.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion11.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion12.png"));
        this.renderer = new Animation(images,6,true);
    }

    @Override
    public void reactive() {
        super.reactive();
        GameObject.midLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion1.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion2.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion3.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion4.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion5.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion6.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion7.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion8.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion9.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion10.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion11.png"));
        images.add(SpriteUtils.loadImage("assets/images/explosion-big/explosion12.png"));
        this.renderer = new Animation(images,6,true);
    }
}
