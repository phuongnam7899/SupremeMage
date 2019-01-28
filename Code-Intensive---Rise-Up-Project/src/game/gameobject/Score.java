package game.gameobject;

import game.gameobject.player.Player;

import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.util.ArrayList;

public class Score extends  GameObject {
    public Score(){
        GameObject.topLayer.add(this);
        this.anchor.set(0,0);
    }

    public void render(Graphics g,int x,int y,int size,Color color) {
        if(this.renderer != null) {
            this.renderer.render(g, this);
        }
        g.setColor(color);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, size));
        g.drawString(Player.score + "",x,y);

    }
}
