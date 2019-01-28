package game.gameobject.powerup;

import game.FrameCounter;
import game.gameobject.GameObject;
import game.gameobject.enemy.Enemy;
import game.physics.Physics;
import game.gameobject.player.Player;
import game.renderer.Animation;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Freeze extends Item implements Physics {
    FrameCounter activeCouter;
    Clip activeSound;

    public Freeze() {
        GameObject.midLayer.add(this);
        this.activeCouter = new FrameCounter(120);
        this.makeAnimation();
        this.activeSound = AudioUtils.loadSound("assets/music/sfx/freeze.wav");
    }

    @Override
    public void run() {
        super.run();
        this.active();
    }

    private void active() {
        Player player = GameObject.findIntersected(Player.class,this.boxColider);
        if (player != null){
            this.activeSound.start();
            ArrayList<Enemy> enemies = GameObject.findObject(Enemy.class);
            for (int i = 0; i < enemies.size() ; i++) {
                Enemy enemy = enemies.get(i);
                enemy.isSlowDown = true;
                }
            this.deactive();
        }
    }
    private void makeAnimation(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/power-up/freeze/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/freeze/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/freeze/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/freeze/4.png"));
        this.renderer = new Animation(images, 20);
    }

    @Override
    public void deactive() {
        super.deactive();
    }

        @Override
        public void reactive() {
            super.reactive();
            this.activeSound = AudioUtils.loadSound("assets/music/sfx/freeze.wav");
    }
}


