package game.renderer;

import game.gameobject.GameObject;

import java.awt.*;

//abstract: chi dinh nghia ra ham,class nao can dung thi phai override
public abstract class Renderer {
    abstract public void render(Graphics g, GameObject master);
}
