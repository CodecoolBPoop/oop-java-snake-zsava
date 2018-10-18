package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

// a simple enemy TODO make better ones.
public class Enemy2 extends GameEntity implements Animatable, Interactable {
    private double direction;
    private Point2D heading;
    private static final int damage = 20;
    private Random rnd = new Random();
    private int speed = 1;

    public Enemy2(Pane pane) {
        super(pane);

        setImage(Globals.Enemy2);
        pane.getChildren().add(this);
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

        direction = rnd.nextDouble() * 360;
        setRotate(direction);

        if(Globals.getGameObjects().isEmpty()){
            System.out.println(rnd.nextDouble());
            setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
            setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
        }
        else{
            while(getX() == Globals.getGameObjects().get(0).getX() || getY() == Globals.getGameObjects().get(0).getY()){
                setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
                setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
            }
            setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
            setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

        }

        heading = Utils.directionToVector(direction, speed);
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        if (rnd.nextInt(1000)<17){
            direction = rnd.nextDouble() * 360;
            heading = Utils.directionToVector(direction, speed);
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-damage);
        destroy();
    }

    @Override
    public String getMessage() {
        return "20 damage";
    }
}
