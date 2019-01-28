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

public class Ghost extends Enemy implements Physics {

    public Ghost() {
        midLayer.add(this);
        this.kickedSound = AudioUtils.loadSound("assets/music/sfx/ghostcolide.wav");
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/ghost/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/ghost/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/ghost/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/ghost/4.png"));

        this.renderer = new Animation(images);
        this.boxColider = new BoxColider(this, 30, 30);
        this.velocity.set(0, 1);
    }

    @Override
    public void reactive() {
        super.reactive();
        this.kickedSound = AudioUtils.loadSound("assets/music/sfx/ghostcolide.wav");
    }
}