package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.TabPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.scene.control.*;

import java.util.Collections;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        // Test for a line
        javafx.scene.shape.Line line = new javafx.scene.shape.Line();

        line.setStartX(100.0);
        line.setStartY(150.0);
        line.setEndX(500.0);
        line.setEndY(150.0);

        //Group root = new Group(Collections.singleton(line));

        Room room = new Room(100, 50);

        //Scene scene = new Scene(room, 750, 750);

//        scene.setOnMouseReleased(event -> {
//            room.Remove();
//        });

        TabPane tabPane = new TabPane();
        Tab tab = new Tab();
        tab.setText("new tab");
        tab.setContent(new Room(100, 100));
        tabPane.getTabs().add(tab);

        //Scene scene = new Scene(tabPane, 750, 750);
        Scene scene = new Scene(room, 750, 750);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();*/

        /*Pane mainPane = new Pane();
        mainPane.setPrefWidth(400);
        mainPane.setPrefHeight(600);

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);
        mainPane.getChildren().add(menuBar);
        menuBar.setPrefWidth(32.0);
        menuBar.setPrefHeight(600.0);

        ScrollPane designerPane = new ScrollPane();
        designerPane.setPrefViewportWidth(330);
        designerPane.setPrefViewportHeight(450);
        SubScene canvas = new SubScene(designerPane, 500, 500);

        Scene scene = new Scene(mainPane, 400, 600);*/

        Parent root = FXMLLoader.load(getClass().getResource("finalversion.fxml"));

        /*ScrollPane sP = (ScrollPane)root.getChildrenUnmodifiable().get(2);
        sP.setContent(new SubScene(new Room(100, 50), 500, 500));*/

//        sP.getContent().relocate(sP.getLayoutX(), sP.getLayoutY());
        /*MenuBar menuBar = (MenuBar)root.getChildrenUnmodifiable().get(1);

        sP.getContent().relocate(sP.getLayoutX(), sP.getLayoutY());

        sP.getContent().setPickOnBounds(true);*/

        ScrollPane scrollPane = (ScrollPane)root.getChildrenUnmodifiable().get(2);
        String s = scrollPane.getContent().getId();
        SubScene subScene = (SubScene)scrollPane.getContent();
        subScene.setRoot(new Room(100, 50));

        System.out.println(s);

        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
