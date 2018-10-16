package com.codecool.snake;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        game.setTableBackground(new Image("/dirty_background.jpg"));

        Text gameOver = new Text("Game over!");
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(400, 200);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(gameOver, 0, 0);
        gridPane.setVisible(true);
        gameOver.setStyle("-fx-font: normal bold 20px 'serif' ");
        gridPane.setStyle("-fx-background-color: BEIGE;");
        game.getChildren().add(gridPane);


        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
        game.start();
        game.createButtons();
    }

}
