package game.gameobject.powerup;

import game.gameobject.GameObject;
import game.gameobject.enemy.Enemy;
import game.physics.BoxColider;
import game.physics.Physics;
import game.gameobject.player.Player;
import game.renderer.Animation;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Boom extends Item implements Physics {
    Clip explosionSound;

    public Boom() {
        GameObject.midLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/power-up/boom/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/boom/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/boom/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/boom/4.png"));
        this.renderer = new Animation(images, 10);
        this.explosionSound = AudioUtils.loadSound("assets/music/sfx/boomexplosion.wav");
    }
    @Override
    public void run() {
        super.run();
        this.active();
    }
    private void active() {
        Player player = GameObject.findIntersected(Player.class,this.boxColider);
        if( player != null){
            this.boxColider = new BoxColider(this,250,250);
            ArrayList<Enemy> enemies = GameObject.findObject(Enemy.class);
            for (int i = 0; i <enemies.size() ; i++) {
                Enemy enemy = enemies.get(i);
                if (enemy.boxColider.intersected(this.boxColider)){
                    enemy.deactive();
                }
            }
            this.deactive();
        }
    }
    @Override
    public void deactive() {
        super.deactive();
        BoomExplosion explosion  = GameObject.recycle(BoomExplosion.class);
        explosion.position.set(this.position);
        this.explosionSound.start();
    }

    @Override
    public void reactive() {
        super.reactive();
        this.boxColider = new BoxColider(this,32,32);
        this.explosionSound = AudioUtils.loadSound("assets/music/sfx/boomexplosion.wav");
    }
}
