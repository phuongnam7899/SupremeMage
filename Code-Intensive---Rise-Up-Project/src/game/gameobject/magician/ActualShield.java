package game.gameobject.magician;

import game.FrameCounter;
import game.gameobject.GameObject;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Animation;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ActualShield extends GameObject implements Physics {
    BoxColider boxColider;
    FrameCounter velocityChangeCounter;
    Clip breakSound;

    public ActualShield(){
        GameObject.midLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/actual1.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/actual2.png"));
        this.renderer = new Animation(images,5);
        this.isActive = false;
        this.position.set(275,575);
        this.boxColider = new BoxColider(this,180,170);
        this.breakSound = AudioUtils.loadSound("assets/music/sfx/shield-hit.wav");
    }


    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }

    @Override
    public void deactive() {
        super.deactive();
        this.breakSound.start();
    }

    @Override
    public void reactive() {
        super.reactive();
        this.breakSound = AudioUtils.loadSound("assets/music/sfx/shield-hit.wav");
    }
}