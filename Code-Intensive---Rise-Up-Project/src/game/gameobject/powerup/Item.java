package game.gameobject.powerup;

import game.FrameCounter;
import game.gameobject.GameObject;
import game.physics.BoxColider;
import game.physics.Physics;

import java.util.Random;

public class Item extends GameObject implements Physics {
    BoxColider boxColider;
    int x;
    int y;
    Random rand = new Random();
    FrameCounter velocityChangeCounter;

    public Item()
    {
        this.x = rand.nextInt(350) + 100;
        this.y = 0;
        this.position.set(this.x,this.y);
        this.velocity.set(0,0);
        this.boxColider = new BoxColider(this,32,32);
        this.velocityChangeCounter = new FrameCounter(10);
    }
    @Override
    public void run() {
        this.move();
    }
    public void move(){
            int vX;
            int vY = 2;
            if (this.velocityChangeCounter.run()){
                if (this.position.x < 225){
                    vX = rand.nextInt(5) - 2;
                } else{
                    vX = rand.nextInt(2) - 3;
                }
                this.velocity.set(vX,vY).setLength(1);
                this.velocityChangeCounter.reset();
            }
            super.run();
        }
    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}

