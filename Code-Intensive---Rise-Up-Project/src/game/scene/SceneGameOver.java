package game.scene;

import game.gameobject.GameObject;
import tklibs.AudioUtils;

public class SceneGameOver extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundGameOver.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/ending.wav");
        this.sound.start();
    }

    @Override
    public void clear() {
        GameObject.deActiveAll();
        GameObject.clearAll();
    }
}
