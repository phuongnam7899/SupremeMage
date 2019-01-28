package game.gameobject;

import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Background extends GameObject {
    public Background(){
        super();
        GameObject.botLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/scenes/skybackground1.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/skybackground2.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/skybackground3.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/skybackground4.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/skybackground5.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/skybackground6.png"));
        this.renderer = new Animation(images,10);
        this.position.set(0, (600 - 1000)/2);
        this.velocity.set(0, 0);
        this.anchor.set(0, 0);
    }

    @Override
    public void run() {
        super.run();
        if(this.position.y == 0){
            this.velocity.set(0,0);
        }
    }
}
