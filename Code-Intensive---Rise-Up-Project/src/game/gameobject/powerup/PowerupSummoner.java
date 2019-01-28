package game.gameobject.powerup;

import game.FrameCounter;
import game.GameWindow;
import game.Settings;
import game.gameobject.GameObject;
import game.gameobject.enemy.Ghost;

import java.util.ArrayList;
import java.util.Random;

public class PowerupSummoner extends GameObject {
    Random rand = new Random();
    FrameCounter summonCounter;
    FrameCounter scoreCounter;
    int summonCount;

    public PowerupSummoner() {
        this.position.set(0, 0);
        this.summonCount = 300;
        this.summonCounter = new FrameCounter(50);
        this.scoreCounter = new FrameCounter(1400);
    }

    @Override
    public void run() {
        super.run();
        this.summonPowerup();
    }

    private void summonPowerup() {
        GameObject.midLayer.add(this);
        if (this.summonCounter.run()) {
            this.summonCounter = new FrameCounter(summonCount);
            int randX = rand.nextInt(Settings.SCREEN_WIDTH);
            this.position.set(randX, 0);
            int randPowerup = rand.nextInt(3);
            if (randPowerup == 0) {
                Freeze freeze = GameObject.recycle(Freeze.class);
                freeze.position.set(this.position);
            }
            if (randPowerup == 1) {
               Boom boom = GameObject.recycle(Boom.class);
                boom.position.set(this.position);
            }
            if (randPowerup == 2) {
                Shield shield = GameObject.recycle(Shield.class);
                shield.position.set(this.position);
            }
            this.summonCounter.reset();
        }
        if (this.scoreCounter.run() && this.summonCount > 180){
            this.summonCount -= 5;
        }
    }
}