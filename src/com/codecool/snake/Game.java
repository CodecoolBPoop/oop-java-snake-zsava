package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import jdk.nashorn.internal.objects.Global;

import java.util.concurrent.TimeUnit;

public class Game extends Pane {

    public Game() {
        init();
    }

    public void init(){
        new SnakeHead(this, 500, 500);

        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);

        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);
    }

    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
            }
        });
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();

    }

    public void restart(){
        for (Node child: getChildren()){
            if(child instanceof GameEntity){
                Globals.removeGameObject((GameEntity)child);
            }
        }
        getChildren().clear();
        init();
        Globals.gameLoop.startTime = System.nanoTime()/10000000;
        Globals.gameLoop.start();
        createButtons();
    }

    public void setTableBackground(Image tableBackground) {
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

    }

    public void createButtons() {
        Button newGameButton = new Button("New Game");
        this.getChildren().add(newGameButton);
        newGameButton.setLayoutX(10);
        newGameButton.setLayoutY(10);

        newGameButton.setOnAction((event) -> {
            System.out.println("Restart");
            restart();
        });

    }

}
