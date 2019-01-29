package game.scene;


import game.gameobject.GameObject;
import tklibs.AudioUtils;

public class SceneWelcome extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundWelcome.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/opening.wav");
        this.sound.start();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
        GameObject.deActiveAll();
    }
}
