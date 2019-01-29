package game.gameobject.powerup;

import game.gameobject.GameObject;
import game.gameobject.magician.Magician;
import game.gameobject.player.Player;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Animation;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Shield extends Item implements Physics {
    Clip activeSound;

    public Shield(){
        GameObject.midLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/6.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/7.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/8.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/9.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/10.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/11.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/12.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/13.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/14.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/15.png"));
        images.add(SpriteUtils.loadImage("assets/images/power-up/shield/16.png"));
        this.renderer = new Animation(images,10);
        this.activeSound = AudioUtils.loadSound("assets/music/sfx/shieldactive.wav");
    }

    @Override
    public void run() {
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
        Player player = GameObject.findIntersected(Player.class, this.boxColider);
        if(player!=null){
            this.activeSound.start();
            ArrayList<Magician>magicians = GameObject.findObject(Magician.class);
            for (int i = 0; i < magicians.size() ; i++) {
                Magician magician = magicians.get(i);
                magician.addShield();
                magician.isImmune = true;
            }
            this.deactive();
        }
    }
    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }

    @Override
    public void reactive() {
        super.reactive();
        this.activeSound = AudioUtils.loadSound("assets/music/sfx/shieldactive.wav");
    }
}
