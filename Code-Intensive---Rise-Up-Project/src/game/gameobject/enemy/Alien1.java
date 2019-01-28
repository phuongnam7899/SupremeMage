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

public class Alien1 extends Enemy implements Physics {
    public Alien1() {
        midLayer.add(this);
        this.velocity.set(0, 1);
        this.kickedSound = AudioUtils.loadSound("assets/music/sfx/aliencolide.wav");
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/alien1/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/alien1/2.png"));
        this.renderer = new Animation(images, 20);
        this.boxColider = new BoxColider(this, 30, 30);
        this.gravityCounter = new FrameCounter(30);

    }

    @Override
    public void reactive() {
        super.reactive();
        this.kickedSound = AudioUtils.loadSound("assets/music/sfx/aliencolide.wav");
    }
}