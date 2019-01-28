package game.scene;


import game.gameobject.Background;
import game.gameobject.GameObject;
import game.gameobject.Score;
import game.gameobject.enemy.Alien1;
import game.gameobject.enemy.EnemySummoner;
import game.gameobject.enemy.Ghost;
import game.gameobject.enemy.Warrior;
import game.gameobject.magician.Magician;
import game.gameobject.player.Player;
import game.gameobject.powerup.Boom;
import game.gameobject.powerup.Freeze;
import game.gameobject.powerup.PowerupSummoner;
import game.gameobject.powerup.Shield;
import tklibs.AudioUtils;


public class SceneStage1 extends Scene {
    @Override
    public void init() {

        GameObject.recycle(Background.class);
        GameObject.recycle(PowerupSummoner.class);
        GameObject.recycle(EnemySummoner.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(Magician.class);
        GameObject.recycle(Score.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/playing.wav");
        this.sound.start();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }

}
