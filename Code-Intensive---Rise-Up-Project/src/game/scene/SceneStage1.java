package game.scene;


import game.gameobject.Background;
import game.gameobject.GameObject;
import game.gameobject.enemy.EnemySummoner;
import game.gameobject.magician.Magician;
import game.gameobject.player.Player;
import game.gameobject.powerup.PowerupSummoner;
import tklibs.AudioUtils;


public class SceneStage1 extends Scene {
    @Override
    public void init() {
        GameObject.recycle(Background.class);
        GameObject.recycle(PowerupSummoner.class);
        GameObject.recycle(EnemySummoner.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(Magician.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/playing.wav");
        this.sound.start();
    }

    @Override
    public void clear() {
        GameObject.deActiveAll();
        GameObject.clearAll();
    }

}
