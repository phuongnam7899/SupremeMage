package game.gameobject.player;
import game.FrameCounter;
import game.gameobject.GameObject;
import game.Vector2D;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements Physics {

    BoxColider boxColider;
    FrameCounter velocityCounter;
    Vector2D oldPosition;
    FrameCounter scoreCounter;
    public static int score =0;

    public Player() {
        GameObject.midLayer.add(this);
        this.boxColider = new BoxColider(this,20,30);
        this.position.set(225,600);
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/warrior/1.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocityCounter = new FrameCounter(2);
        this.oldPosition = new Vector2D(this.position.x,this.position.y);
        this.scoreCounter = new FrameCounter(60);
    }

    @Override
    public void run() {
        this.move();
        this.limitPosition();// gioi han d chuyen
        this.velocityCalc();
        this.scoreCalc();
    }
    public void scoreCalc(){
        if (this.scoreCounter.run()){
            this.score++;
            this.scoreCounter.reset();
        }

    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    private void limitPosition() {
        if(this.position.y < 32)
        {
            this.position.y=32;// neu no < 0 thi cho gan cho no ow diem bat dau
        }
        if (this.position.y > 800 -32)
        {
            this.position.y = 800-32; // neu chieu cao > 600 gan = khung mafn hinh
        }
        if(this.position.x < 32)
        {
            this.position.x =32;
        }
        if(this.position.x > 500- 39)
        {
            this.position.x =  500- 39;
        }
    }

    private void move() {
        int x = (int)MouseInfo.getPointerInfo().getLocation().getX();
        int y = (int)MouseInfo.getPointerInfo().getLocation().getY();
        this.position.set(x,y);
    }

    public Vector2D velocityCalc(){
        if(this.velocityCounter.run()){
            Vector2D newPosition = new Vector2D(this.position.x,this.position.y);
            Vector2D v = new Vector2D(newPosition.x - this.oldPosition.x,newPosition.y - this.oldPosition.y);
            this.velocity.set(v);
            this.oldPosition.set(newPosition);
            this.velocityCounter.reset();
        }
        return this.velocity;
    }
    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
