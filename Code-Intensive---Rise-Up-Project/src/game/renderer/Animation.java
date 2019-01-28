package game.renderer;

import game.gameobject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImageIndex;
    int nextImageCount;
    public boolean isOnce;

    public Animation(ArrayList<BufferedImage> images) {
        this.images = images;
        this.currentImageIndex = 0;
        this.nextImageCount = 6;
        this.isOnce = false;
    }

    public Animation(ArrayList<BufferedImage> images, int nextImageCount) {
        this.images = images;
        this.currentImageIndex = 0;
        this.nextImageCount = nextImageCount;
        this.isOnce =  false;
    }
    public Animation(ArrayList<BufferedImage> images, int nextImageCount,boolean isOnce) {
        this.images = images;
        this.currentImageIndex = 0;
        this.nextImageCount = nextImageCount;
        this.isOnce =  isOnce;
    }


    int countRender; //TODO: continue editing
    @Override
    public void render(Graphics g, GameObject master) {
        BufferedImage currentImage = this.images.get(this.currentImageIndex);
        g.drawImage(currentImage
                , (int) (master.position.x - master.anchor.x * currentImage.getWidth())
                , (int) (master.position.y - master.anchor.y * currentImage.getHeight())
                , null);

        this.countRender++;
        if(this.countRender > this.nextImageCount) {
            this.currentImageIndex++;
            if(this.currentImageIndex >= this.images.size()) {
                if(this.isOnce) {
                    master.deactive();
                } else {
                    this.currentImageIndex = 0;
                }
            }
            this.countRender = 0;
        }
    }
}
