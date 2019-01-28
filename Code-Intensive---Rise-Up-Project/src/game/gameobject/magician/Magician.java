package game.gameobject.magician;

import game.gameobject.GameObject;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Animation;
import game.scene.SceneGameOver;
import game.scene.SceneManager;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Magician extends GameObject implements Physics {
    BoxColider boxColider;
    public boolean immune;
    ActualShield shield;

    public Magician() {
        GameObject.midLayer.add(this);
        ArrayList<BufferedImage> image = new ArrayList<>();
        image.add(SpriteUtils.loadImage("assets/images/mage/mage1.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage2.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage3.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage4.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage5.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage6.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage7.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage8.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage9.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage10.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage11.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage12.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage13.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage14.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage15.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage16.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage17.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage18.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage19.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage20.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage21.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage22.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage23.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage24.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage25.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage26.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage27.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage28.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage29.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage30.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage31.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage32.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage33.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage34.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage35.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage36.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage37.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage38.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage39.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage40.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage41.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage42.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage43.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage44.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage45.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage46.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage47.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage48.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage49.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage50.png"));
        image.add(SpriteUtils.loadImage("assets/images/mage/mage51.png"));

        this.renderer = new Animation(image);
        this.position.set(225, 650);
        this.boxColider = new BoxColider(this, 30, 30);
        this.immune = false;
        this.shield = new ActualShield();

    }

    public void dead() {
        if (this.immune) {
            return;
        } else {
            this.deactive();
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScene(new SceneGameOver());
    }

    public void addShield() {
        this.shield.isActive = true;
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}

