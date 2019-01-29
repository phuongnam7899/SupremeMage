package game.gameobject.enemy;

import game.FrameCounter;
import game.gameobject.GameObject;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Animation;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Black extends Enemy implements Physics {
    public Black(){
        GameObject.midLayer.add(this);
        this.kickedSound = AudioUtils.loadSound("assets/music/sfx/blackcolide.wav");
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/black/black1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/black/black2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/black/black3.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/black/black4.png"));
        this.renderer = new Animation(images);
        this.boxColider = new BoxColider(this, 40, 48);
        this.velocity.set(0, 1);
        this.gravityCounter = new FrameCounter(30);
    }

    @Override
    public void reactive() {
        super.reactive();
        this.kickedSound = AudioUtils.loadSound("assets/music/sfx/blackcolide.wav");
    }
}
