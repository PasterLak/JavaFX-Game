package com;

import com.basic.ResourcesLoader;
import com.game.AudioController;
import com.game.GameController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {


    private AudioController audioController;
    private GameController gameController;

    public static boolean shiftPressed = false;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        primaryStage.setTitle("Game version 0.6");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setResizable(false);
        primaryStage.show();

        setCursor(primaryStage);
        primaryStage.getScene().setOnMouseClicked(e -> setCursor(primaryStage));

        audioController = new AudioController();
        gameController = new GameController();


        root.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke)
            {

                if(ke.getCode() == KeyCode.TAB)
                {
                    shiftPressed = true;
                }
            }
        });
        root.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke)
            {
                if(shiftPressed)
                {
                    shiftPressed = false;
                }
            }
        });

    }

    private void setCursor(Stage primaryStage)
    {
        primaryStage.getScene().setCursor(new ImageCursor(ResourcesLoader.getImage("sprites/UI/cursor.png",32,32)));
    }


    public static void main(String[] args)
    {

        launch(args);

    }
}
