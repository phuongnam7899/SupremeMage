package game.gameobject.enemy;

import game.FrameCounter;
import game.gameobject.enemy.Enemy;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Animation;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Bat extends Enemy implements Physics {


    public Bat() {
        midLayer.add(this);
        this.kickedSound = AudioUtils.loadSound("assets/music/sfx/batcolide.wav");
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/bat/thebat1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bat/thebat2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bat/thebat3.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bat/thebat4.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bat/thebat5.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bat/thebat6.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bat/thebat7.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bat/thebat8.png"));

        this.renderer = new Animation(images);
        this.boxColider = new BoxColider(this, 30, 30);
        this.velocity.set(0, 1);
        this.gravityCounter = new FrameCounter(30);
//        fireCounter = new FrameCounter(20);
    }

    @Override
    public void reactive() {
        super.reactive();
        this.kickedSound = AudioUtils.loadSound("assets/music/sfx/batcolide.wav");
    }
}