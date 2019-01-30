package game.scene.tutorial;

import game.gameobject.GameObject;
import game.scene.Scene;
import tklibs.AudioUtils;

public class SceneTutorial3 extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundTutorial3.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/opening.wav");
        this.sound.start();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
        GameObject.deActiveAll();
    }
}
