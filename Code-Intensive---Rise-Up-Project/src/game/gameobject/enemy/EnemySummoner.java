package game.gameobject.enemy;

import game.FrameCounter;
import game.GameWindow;
import game.Settings;
import game.gameobject.GameObject;
import game.gameobject.enemy.Ghost;

import java.util.ArrayList;
import java.util.Random;

public class EnemySummoner extends GameObject {
    Random rand = new Random();
    FrameCounter summonCounter;
    FrameCounter scoreCounter;
    int summonCount;

    public EnemySummoner() {
        this.position.set(0, 0);
        this.summonCount = 50;
        this.summonCounter = new FrameCounter(50);
        this.scoreCounter = new FrameCounter(1200);
    }

    @Override
    public void run() {
        super.run();
        this.summonEnemy();
    }

    private void summonEnemy() {
        GameObject.midLayer.add(this);
        if (this.summonCounter.run()) {
            int randX = rand.nextInt(Settings.SCREEN_WIDTH);
            this.position.set(randX, 0);
            int randEnemy = rand.nextInt(4);
            if (randEnemy == 0) {
                Bat bat = GameObject.recycle(Bat.class);
                bat.position.set(this.position);
            }
            if (randEnemy == 1) {
                Warrior warrior = GameObject.recycle(Warrior.class);
                warrior.position.set(this.position);
            }
            if (randEnemy == 2) {
                Ghost ghost = GameObject.recycle(Ghost.class);
                ghost.position.set(this.position);
            }
            if (randEnemy == 3) {
                Alien1 alien1 = GameObject.recycle(Alien1.class);
                alien1.position.set(this.position);
            }
            this.summonCounter.reset();
        }
        if (this.scoreCounter.run() && this.summonCount > 10){
            this.summonCount -= 2;
            this.summonCounter = new FrameCounter(summonCount);
        }
    }
}