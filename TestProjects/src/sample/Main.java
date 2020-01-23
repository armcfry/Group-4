package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("finalversion.fxml"));

        ScrollPane scrollPane = (ScrollPane)root.getChildrenUnmodifiable().get(2);
        String s = scrollPane.getContent().getId();
        SubScene subScene = (SubScene)scrollPane.getContent();
        subScene.setRoot(new Room(100, 100, 100, 50));

        primaryStage.setTitle("Roomba Simulator 3000");
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
