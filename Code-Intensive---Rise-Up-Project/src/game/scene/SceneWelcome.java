package game.scene;


import game.gameobject.GameObject;
import tklibs.AudioUtils;

public class SceneWelcome extends Scene {
    BackgroundWelcome backgroundWelcome;
    @Override
    public void init() {
        this.backgroundWelcome = GameObject.recycle(BackgroundWelcome.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/opening.wav");
        this.sound.start();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
