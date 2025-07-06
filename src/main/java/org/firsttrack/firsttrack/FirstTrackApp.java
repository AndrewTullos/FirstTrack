package org.firsttrack.firsttrack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


import java.io.IOException;

public class FirstTrackApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        System.out.println(getClass().getResource("/org/firsttrack/firsttrack/usaa-logo.png"));
        FXMLLoader fxmlLoader = new FXMLLoader(FirstTrackApp.class.getResource("/org/firsttrack/firsttrack/fxml/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 720);
        Image icon = new Image(getClass().getResourceAsStream("/org/firsttrack/firsttrack/usaa-logo.png"));
        stage.getIcons().add(icon);


        stage.setTitle("On Track");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}