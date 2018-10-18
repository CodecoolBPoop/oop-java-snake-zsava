package com.codecool.snake;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.SimplePowerup;
import javafx.animation.AnimationTimer;

import java.util.Random;


public class GameLoop extends AnimationTimer {

    public long startTime = System.nanoTime()/10000000;

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {
        for (GameEntity gameObject : Globals.gameObjects) {
            if (gameObject instanceof Animatable) {
                Animatable animObject = (Animatable)gameObject;
                animObject.step();
            }
        }
        enemyspawn();
        powerupspawn();
        Globals.gameObjects.addAll(Globals.newGameObjects);
        Globals.newGameObjects.clear();

        Globals.gameObjects.removeAll(Globals.oldGameObjects);
        Globals.oldGameObjects.clear();
    }

    private void enemyspawn(){
        Random rand = new Random();
        if(rand.nextInt(1000)<25){
            Globals.addGameObject(new SimpleEnemy(Globals.game));
        }


    }

    private void powerupspawn(){
        Random rand = new Random();
        if(rand.nextInt(1000)<10){
            Globals.addGameObject(new SimplePowerup(Globals.game));
        }


    }
}
