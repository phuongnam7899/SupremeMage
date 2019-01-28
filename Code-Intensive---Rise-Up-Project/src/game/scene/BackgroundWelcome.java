package game.scene;


import game.GameWindow;
import game.Settings;
import game.gameobject.GameObject;
import game.renderer.SingleImageRenderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class BackgroundWelcome extends GameObject {

    public BackgroundWelcome() {
        GameObject.botLayer.add(this);
        BufferedImage image = SpriteUtils.loadImage("assets/images/scenes/scene/Start1.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.SCREEN_WIDTH / 2
                , Settings.SCREEN_HEIGHT / 2);
    }

    @Override
    public void run() {
        super.run();
        if(GameWindow.isAnyKeyPress) {
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
