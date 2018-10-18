package com.codecool.snake;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;


public class AlertBox {

    public static void display (){
        Stage window = new Stage();

        window.initModality(null);
        window.setTitle("Restart");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("Eddig jó");
        Button restartButton = new Button("Restart");
        restartButton.setOnAction((event) -> {
            System.out.println("Restart");
            Game newGame = new Game();
            newGame.restart();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, restartButton);
        layout.setAlignment(Pos.CENTER);

        Scene newScene = new Scene(layout);
        window.setScene(newScene);
        window.showAndWait();
    }



}
