package game.scene;


import game.GameWindow;
import game.Settings;
import game.gameobject.GameObject;
import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import game.scene.tutorial.SceneTutorial1;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BackgroundWelcome extends GameObject {

    public BackgroundWelcome() {
        GameObject.botLayer.add(this);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start1.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start2.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start3.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start4.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start5.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start6.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start7.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start8.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start9.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start10.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start11.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start12.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start13.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start14.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start15.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start16.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start17.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start18.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start19.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start20.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start21.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start22.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start23.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start24.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start25.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start26.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start27.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start28.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start29.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start30.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start31.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start32.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start33.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start34.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start36.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start36.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start37.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start38.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start39.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start40.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start41.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start42.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start43.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start44.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start45.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start46.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start47.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start48.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start49.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start50.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start51.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start52.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start53.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start54.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start55.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start56.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start57.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start58.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start59.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start60.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start61.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start62.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start63.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start64.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start65.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start66.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start67.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start68.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start69.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start70.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start71.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start72.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start73.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start74.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start75.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start76.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start77.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start78.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start79.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start80.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start81.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start82.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start83.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start84.png"));
        images.add(SpriteUtils.loadImage("assets/images/scenes/scene/start/Start85.png"));
        this.renderer = new Animation(images);
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
