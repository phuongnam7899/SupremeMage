package game.scene.tutorial;

import game.FrameCounter;
import game.GameWindow;
import game.Settings;
import game.gameobject.GameObject;
import game.renderer.SingleImageRenderer;
import game.scene.Scene;
import game.scene.SceneManager;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundTutorial1 extends GameObject {
    FrameCounter cooldown = new FrameCounter(60);
    public BackgroundTutorial1(){
        GameObject.botLayer.add(this);
        BufferedImage image = SpriteUtils.loadImage("assets/images/earth/Earth1.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.SCREEN_WIDTH / 2
                , Settings.SCREEN_HEIGHT / 2);
    }

    @Override
    public void run() {
        super.run();
        if (this.cooldown.run()){
            if (GameWindow.isAnyKeyPress){
                SceneManager.signNewScene(new SceneTutorial2());
            }
        }
    }
}