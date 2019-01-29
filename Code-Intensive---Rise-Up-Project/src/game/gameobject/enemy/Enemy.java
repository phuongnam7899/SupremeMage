package game.gameobject.enemy;

import game.FrameCounter;
import game.Vector2D;
import game.gameobject.GameObject;
import game.gameobject.magician.Magician;
import game.gameobject.magician.ActualShield;
import game.gameobject.powerup.freeze.CrystalGenerate;
import game.physics.BoxColider;
import game.physics.Physics;
import game.gameobject.player.Player;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject implements Physics {
    public BoxColider boxColider;
    public Vector2D gravity = new Vector2D();
    public FrameCounter gravityCounter;
    public FrameCounter slowDownCounter = new FrameCounter(240);
    public Boolean isSlowDown = false;
    Clip kickedSound;

    public Enemy() {
        this.gravity.set(0, 1).scale((float)1.5);
        this.gravityCounter = new FrameCounter(1);
    }

    @Override
    public void run() {
        super.run();
        this.velocityChange();
        this.limitPosition();
        this.kicked();
        this.attack();
        if (this.isSlowDown){
            this.slowDown();
            if (this.slowDownCounter.run()){
                this.isSlowDown = false;
            }
        }
    }

    public void velocityChange() {
        if (this.velocity.y < 0){
            this.gravity.set(0,1).scale((float)1.5);
        } else {
            this.gravity.set(0, 1).scale((float) 0.5);
        }
        if (this.gravityCounter.run()) {
            this.velocity.add(this.gravity);
            this.gravityCounter.reset();
        }
        if (this.velocity.x > 2){
            this.velocity.x = 2;
        }
        if (this.velocity.x < -2){
            this.velocity.x = -2;
        }
    }

    public void limitPosition() {
        if (this.position.y > 600 + 100) {
            this.deactive();
        }
    }

    public void kicked() {
        Player player = GameObject.findIntersected(Player.class, this.boxColider);
        if (player != null) {
            this.kickedSound.start();
            Vector2D newVelocity = player.velocity.scale((float) 0.1);
            this.velocity.set(newVelocity);

            if (player.getBoxColider().top() < this.getBoxColider().bot() && player.velocity.y < 0) {
                float delta1 = player.getBoxColider().top() - this.getBoxColider().bot();
                this.position.add(0, delta1);
            }
            if (player.getBoxColider().bot() > this.getBoxColider().top() && player.velocity.y > 0) {
                float delta2 = player.getBoxColider().bot() - this.getBoxColider().top();
                this.position.add(0, delta2);
            }
            if (player.getBoxColider().right() > this.getBoxColider().left() && player.velocity.x > 0) {
                float delta3 = player.getBoxColider().right() - this.getBoxColider().left();
                this.position.add(delta3, 0);
            }
            if (player.getBoxColider().left() < this.getBoxColider().right() && player.velocity.x < 0) {
                float delta4 = player.getBoxColider().left() - this.getBoxColider().right();
                this.position.add(delta4, 0);
            }

        }
        Enemy otherEnemy = GameObject.findIntersected(Enemy.class,this.boxColider);
        Vector2D oldVelocity = this.velocity;
        if (otherEnemy != null && otherEnemy != this){
            Vector2D newVelocity = otherEnemy.velocity.add(oldVelocity).scale(2).setLength(2);
            this.velocity.set(newVelocity);
        }
    }

    public void attack() {
        Magician magician = GameObject.findIntersected(Magician.class, this.boxColider);
        if (magician != null) {
            magician.dead();
            this.deactive();
            ActualShield shield = GameObject.findIntersected(ActualShield.class, this.boxColider);
            if (shield != null) {
                shield.deactive();
                magician.isImmune = false;
            }

        }
    }
    public void slowDown(){
            this.velocity.setLength(1);
            this.gravity.setLength(1);
    }

        @Override
        public BoxColider getBoxColider () {
            return this.boxColider;
        }


    @Override
    public void reactive() {
        super.reactive();
        this.velocity.set(0,1);
        this.gravity.set(new Vector2D().set(0, 1).scale((float) 0.5));
        this.isSlowDown = false;
    }
}
