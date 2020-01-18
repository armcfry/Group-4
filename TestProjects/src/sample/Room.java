package sample;

import java.awt.*;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import java.math.*;

public class Room extends Group {

    public Room(int width, int height) {
        this.width = width;
        this.height = height;

        room = new Rectangle();
        room.setWidth(width);
        room.setHeight(height);
        room.setX(0);
        room.setY(0);
        room.setFill(javafx.scene.paint.Color.RED);

        getChildren().add(room);
        //getChildren().add(path);
        makeDraggable();
    }

    public void Remove() {
        if (getChildren().size() > 0) {
            getChildren().remove(0);
        }
    }

    private void makeDraggable() {

        this.setPickOnBounds(true);

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                room.setX(Math.round(event.getSceneX()/*/50.0) * 50*/));
                room.setY(Math.round(event.getSceneY()/*/50.0) * 50*/));

                event.consume();
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                room.setX((Math.round(event.getX()/25.0) * 25) - (width / 2));
                room.setY((Math.round(event.getY()/25.0) * 25) - (height / 2));

                event.consume();
            }
        });
    }

    int width, height;
    Rectangle room;

}
