package game.gameobject.powerup.freeze;

import game.FrameCounter;
import game.Settings;
import game.gameobject.GameObject;

import java.util.ArrayList;
import java.util.Random;

public class CrystalGenerate extends GameObject {
    Random rand = new Random();
    int summonCount;
    FrameCounter existTime;
    boolean isGenerate;
    public CrystalGenerate(){
        GameObject.topLayer.add(this);
        this.isGenerate =true;
        this.position.set(0, 0);
        this.existTime = new FrameCounter(240);
        this.summonCount = 400;
    }

    @Override
    public void run() {
            if (this.isGenerate){
                this.CrystalMake();
                this.isGenerate = false;
            }
            if (this.existTime.run()){
                this.deactive();
            }
        ArrayList<Crystal> crystals = GameObject.findObject(Crystal.class);
        System.out.println(crystals.size());

    }
    public void CrystalMake(){
        for (int i = 0; i < this.summonCount ; i++) {
            this.position.x = rand.nextInt(Settings.SCREEN_WIDTH +200) - 200;
            this.position.y = rand.nextInt((Settings.SCREEN_HEIGHT)  ) - 400;
            Crystal crystal = new Crystal();
            crystal.position.set(this.position);
            crystal.velocity.set(-1,2).setLength(1);
        }
    }

    @Override
    public void reactive() {
        super.reactive();
        this.isGenerate = true;
        this.position.set(0, 0);
        this.existTime = new FrameCounter(240);
        this.summonCount = 400;
        ArrayList<Crystal> crystals = GameObject.findObject(Crystal.class);
        for (int i = 0; i < crystals.size() ; i++) {
            Crystal crystal = crystals.get(i);
            crystal.reactive();
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        ArrayList<Crystal> crystals = GameObject.findObject(Crystal.class);
        for (int i = 0; i < crystals.size() ; i++) {
            Crystal crystal = crystals.get(i);
            crystal.deactive();
        }
    }
}
