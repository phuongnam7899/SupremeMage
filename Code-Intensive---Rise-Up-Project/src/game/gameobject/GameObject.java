
package game.gameobject;

import game.Vector2D;
import game.physics.BoxColider;
import game.physics.Physics;
import game.renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {

    // thuoc tinh
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public boolean isActive;
    public Vector2D anchor;

    //static: quan li
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static ArrayList<GameObject> botLayer = new ArrayList<>();
    public static ArrayList<GameObject> midLayer = new ArrayList<>();
    public static ArrayList<GameObject> topLayer = new ArrayList<>();


    public static void addNew(GameObject object) {
        gameObjects.add(object);
    }

    public static <E extends GameObject> E recycle(Class<E> cls) {
        E object = findInactive(cls);
        if (object != null){
            object.reactive();
            return object;
        }
        else {
            try {
//                return new E();
                return cls.getConstructor().newInstance();
            } catch (Exception ex){
                return null;
            }
//
        }
    }
    public static <E extends GameObject> E findInactive(Class<E> cls){
        for (int i = 0; i < gameObjects.size() ; i++) {
            GameObject object = gameObjects.get(i);
            if (!object.isActive
            && cls.isAssignableFrom(object.getClass())){
                return (E)object;
            }
        }
        return null;
    }

    public static <E extends GameObject> ArrayList<E> findObject(Class<E> cls){
        ArrayList<E> list = new ArrayList<>();
        for (int i = 0; i < gameObjects.size() ; i++) {
            GameObject object = gameObjects.get(i);
            if (object.isActive
                    && cls.isAssignableFrom(object.getClass())){
                list.add((E)object);
            }
        }
        return list;
    }


    public static void clearAll() {
        gameObjects.clear();
    }
    public static void deActiveAll(){
        for (int i = 0; i < gameObjects.size() ; i++) {
            GameObject object = gameObjects.get(i);
            object.deactive();
        }
    }

    public static void runAll() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if ( object.isActive){
                object.run();
            }
        }
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < botLayer.size(); i++) {
            GameObject object = botLayer.get(i);
            if (object.isActive){
                object.render(g);
            }
        }
        for (int i = 0; i < midLayer.size(); i++) {
            GameObject object = midLayer.get(i);
            if (object.isActive){
                object.render(g);
            }
        }
        for (int i = 0; i < topLayer.size(); i++) {
            GameObject object = topLayer.get(i);
            if (object.isActive){
                object.render(g);
            }
        }
    }


    //methods

    public GameObject() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.isActive = true;
        addNew(this); //cu tao moi thi cho game.gameobject vao mang quan li
        this.anchor = new Vector2D(0.5f,0.5f);
    }

    public void run() {
        this.position.add(this.velocity);
    }

    public void render(Graphics g) {
        if(this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

    public static <E extends GameObject> E findIntersected (Class<E> cls, BoxColider boxColider) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if ( cls.isAssignableFrom(object.getClass()) //class you want?
                && object instanceof Physics // physics?
                && ((Physics) object).getBoxColider().intersected(boxColider)// intersect?
                && object.isActive){
            return (E) object;
        }
    }
        return null;
    }
    public void deactive(){
        this.isActive = false;
    }
    public void reactive(){
        this.isActive = true;
    }

}