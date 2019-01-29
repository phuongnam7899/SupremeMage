package game.scene.tutorial;


import game.FrameCounter;
import game.gameobject.GameObject;
import game.scene.Scene;
import tklibs.AudioUtils;

import java.lang.reflect.GenericArrayType;

public class SceneTutorial2 extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundTutorial2.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/opening.wav");
        this.sound.start();
    }

    @Override
    public void clear() {
        GameObject.deActiveAll();
        GameObject.clearAll();
    }
}